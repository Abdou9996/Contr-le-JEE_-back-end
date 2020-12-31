package com.sid.eurekadescovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDescoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaDescoveryApplication.class, args);

    }

}
