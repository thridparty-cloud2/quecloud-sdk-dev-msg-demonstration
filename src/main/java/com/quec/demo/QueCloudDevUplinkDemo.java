package com.quec.demo;

import com.quec.amqphandle.HandleMessage;
import com.quec.client.AmqpClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QueCloudDevUplinkDemo {

    public void msgUpLinkDemo() throws Exception {
        AmqpClient amqpClient = new AmqpClient("${accessKey}","${accessSecret}","${connectionUrl}","${queueName}");
        HandleMessage handleMessage = new HandleMessageImpl();
        amqpClient.start(handleMessage);
        log.info("开始监听队列");
    }

}
