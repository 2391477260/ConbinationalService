package com.hnust.consumerb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class ConsumerbApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerbApplication.class, args);
    }

}
