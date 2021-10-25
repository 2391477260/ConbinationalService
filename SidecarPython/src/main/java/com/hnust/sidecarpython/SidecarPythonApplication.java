package com.hnust.sidecarpython;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SidecarPythonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SidecarPythonApplication.class, args);
    }

}
