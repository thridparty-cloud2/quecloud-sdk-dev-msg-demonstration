package com.quec.demo;

import com.quec.amqphandle.HandleMessage;
import com.quec.client.AmqpClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QueCloudDevUplinkDemo {

    public void msgUpLinkDemo() throws Exception {
        AmqpClient amqpClient = new AmqpClient("24b9rucZxRMAkMhHbFSxPanj","6AYBWJYrv1qLrrCKfDvDw2TxQftGNLR3r8p4TA6y","amqps://iot-amqp.quectelcn.com:5671/quec-open","a.000000005503.aep_queue_41_20221101143859");
        HandleMessage handleMessage = new HandleMessageImpl();
        amqpClient.start(handleMessage);
        log.info("开始监听");
    }

}
