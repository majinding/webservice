##cxf-file示例

### 发布项目
1. 直接在类CxfServerPublish运行main方法

访问地址： http://127.0.0.1:8080/ws/file?wsdl 验证服务是否发布成功

### 调用
1. cmd命令 wsimport -keep http://127.0.0.1:8080/ws/file?wsdl
2. 运行 cn.majingjing.ws.CxfClient 中的单元测试

