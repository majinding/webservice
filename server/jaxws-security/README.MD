ws-client

采用`jaxws`的`handler`来增加`security`校验

##### 测试请求报文
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://server.ws.majingjing.cn/">
    <soapenv:Header>
        <AuthenticationToken xmlns="http://www.majingjing.cn/auth">
            <Username>zhansan</Username>
            <Password>1234567</Password>
        </AuthenticationToken>
    </soapenv:Header>
    <soapenv:Body>
        <ser:abc>
            <!--Optional:-->
            <arg0>bc</arg0>
        </ser:abc>
    </soapenv:Body>
</soapenv:Envelope>
```

##### 测试响应报文
````xml
<soapenv:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://server.ws.majingjing.cn/" xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
   <soapenv:Header/>
   <soapenv:Body>
      <soapenv:Fault>
         <faultcode>SOAP-ENV:Server</faultcode>
         <faultstring>授权失败！</faultstring>
      </soapenv:Fault>
   </soapenv:Body>
</soapenv:Envelope>
````

正确的请求密码为 `123456`