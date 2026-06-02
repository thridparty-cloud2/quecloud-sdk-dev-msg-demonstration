###### **This demo showcases the product and device uplink and downlink APIs provided by the quecloud-sdk-dev-msg jar.**
# Development Environment
- JDK1.8
- maven 3.6.3
# Device Downlink Guide
- 1. QueCloudDevDownlinkDemo.java demonstrates the device command delivery flow and explains the required parameters.
- 2. Update AccessKey, AccessSecret, and endpoint in QueCloudDevDownlinkDemo.java. AccessKey and AccessSecret are generated in the device management platform, and endpoint is the service URL. For the production environment in China, use iot-api.quectelcn.com.
- 3. Replace the placeholder values based on the parameter requirements of each method.
- 4. Run the method you want to test.
## Multi-Tenant
If you need to access data for multiple users, create separate MsgClient instances with different AccessKey and AccessSecret values.

# Device Uplink Guide
- 1. QueCloudDevUplinkDemo.java demonstrates the device uplink flow, that is, receiving messages from RabbitMQ, and explains the required parameters.
- 2. Update AccessKey, AccessSecret, connectionUrl, and queueName.
- 3. Implement the HandleMessage interface.
## Multi-Tenant
If you need to listen to multiple queues at the same time, create separate AmqpClient instances with different AccessKey, AccessSecret, connectionUrl, and queueName values.
# Online Contact
<img style="width:20%;" src="/IMG/CBBE3E2F06944E79CF5C87267B909136.png" />