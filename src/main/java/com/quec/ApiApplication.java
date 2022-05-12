package com.quec;

import com.quec.demo.QueCloudDevUplinkDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApiApplication.class, args);
        QueCloudDevUplinkDemo queCloudDevUplinkDemo = new QueCloudDevUplinkDemo();
        queCloudDevUplinkDemo.msgUpLinkDemo();
    }
}
