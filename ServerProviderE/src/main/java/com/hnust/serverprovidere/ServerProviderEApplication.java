package com.hnust.serverprovidere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServerProviderEApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerProviderEApplication.class, args);
    }

}
