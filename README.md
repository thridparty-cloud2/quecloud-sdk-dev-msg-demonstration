###### **本demo是针对产品、设备上下行sdk方法介绍(即：quecloud-sdk-dev-msg jar的介绍)**
# 开发环境
- JDK1.8
- maven 3.6.3
# 设备下行方法介绍
- 1.QueCloudDevDownlinkDemo.java中有设备指令下发调用过程及参数说明
- 2.更改QueCloudDevDownlinkDemo.java 中AccessKey、AccessSecret、endpoint(AccessKey和AccessSecre是设备管理平台用户创建AccessKey和AccessSecret,endpoint是链接地址，国内生成环境值为 iot-api.quectelcn.com)
- 3.根据每个方法的参数说明替换方法中的参数
- 4.执行相应的方法即可
## 多租户
针对需要获取不同用户的数据,根据AccessKey和AccessSecre创建不同MgrClient对象即可

# 设备上行方法介绍
- 1.QueCloudDevUplinkDemo.java中有设备上行(即:从rabbitmq接收数据)调用过程及参数说明
- 2.更改AccessKey、AccessSecret、connectionUrl(连接地址)、queueName(队列名称)
- 3.实现HandleMessage接口
## 多租户
针对需要同时监听不同的队列,根据AccessKey、AccessSecret、connectionUrl、queueName创建不同AmqpClient对象即可
# 在线交流
<img style="width:10%;" src="/IMG/CBBE3E2F06944E79CF5C87267B909136.png" />