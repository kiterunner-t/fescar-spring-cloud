/*
 * Copyright (C) KRT, 2019 by kiterunner_t
 * TO THE HAPPY FEW
 */

package com.krt.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@ComponentScan(basePackages = OrderConst.BasePackage)
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}

