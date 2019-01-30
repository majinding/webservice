package cn.majingjing.ws.server.file;

import org.apache.cxf.common.logging.LogUtils;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingMessage;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyAbstractPhaseInterceptor extends AbstractPhaseInterceptor<Message> {
    private static final Logger LOG = LogUtils.getL7dLogger(LoggingInInterceptor.class);
    private int limit;
    private PrintWriter writer;

    public MyAbstractPhaseInterceptor() {
        super("receive");
        this.limit = 102400*100;
    }

    public MyAbstractPhaseInterceptor(String phase) {
        super(phase);
        this.limit = 102400*100;
    }

    public MyAbstractPhaseInterceptor(int lim) {
        this();
        this.limit = lim;
    }

    public MyAbstractPhaseInterceptor(PrintWriter w) {
        this();
        this.writer = w;
    }

    public void setPrintWriter(PrintWriter w) {
        this.writer = w;
    }

    public PrintWriter getPrintWriter() {
        return this.writer;
    }

    public void setLimit(int lim) {
        this.limit = lim;
    }

    public int getLimit() {
        return this.limit;
    }

    public void handleMessage(Message message) throws Fault {
        if (this.writer != null || LOG.isLoggable(Level.INFO)) {
            this.logging(message);
        }

    }

    protected String transform(String originalLogString) {
        return originalLogString;
    }

    private void logging(Message message) throws Fault {
        String id = (String)message.getExchange().get(LoggingMessage.ID_KEY);
        if (id == null) {
            id = LoggingMessage.nextId();
            message.getExchange().put(LoggingMessage.ID_KEY, id);
        }

        LoggingMessage buffer = new LoggingMessage("Inbound Message\n----------------------------", id);
        String encoding = (String)message.get(Message.ENCODING);
        if (encoding != null) {
            buffer.getEncoding().append(encoding);
        }

        String ct = (String)message.get("Content-Type");
        if (ct != null) {
            buffer.getContentType().append(ct);
        }

        Object headers = message.get(Message.PROTOCOL_HEADERS);
        if (headers != null) {
            buffer.getHeader().append(headers);
        }

        String uri = (String)message.get(Message.REQUEST_URI);
        if (uri != null) {
            buffer.getAddress().append(uri);
        }

        InputStream is = (InputStream)message.getContent(InputStream.class);
        if (is != null) {

            CachedOutputStream bos = new CachedOutputStream();

            try {
                IOUtils.copy(is, bos);

                bos.flush();
                is.close();
                message.setContent(InputStream.class, bos.getInputStream());
                if (bos.getTempFile() != null) {
                    buffer.getMessage().append("\nMessage (saved to tmp file):\n");
                    buffer.getMessage().append("Filename: " + bos.getTempFile().getAbsolutePath() + "\n");
                }

                if (bos.size() > this.limit) {
                    buffer.getMessage().append("(message truncated to " + this.limit + " bytes)\n");
                }

                bos.writeCacheTo(buffer.getPayload(), this.limit);
                bos.close();
            } catch (IOException var11) {
                throw new Fault(var11);
            }
        }

        if (this.writer != null) {
            this.writer.println(this.transform(buffer.toString()));
        } else if (LOG.isLoggable(Level.INFO)) {
            LOG.info(this.transform(buffer.toString()));
        }

    }
}