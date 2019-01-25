/*
 * Copyright (C) KRT, 2019 by kiterunner_t
 * TO THE HAPPY FEW
 */

package com.krt.order.config;

import com.alibaba.fescar.spring.annotation.GlobalTransactionScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.krt.order.OrderConst;


@Configuration
public class FescarBean {
    @Bean
    public GlobalTransactionScanner transactionScanner() {
        return new GlobalTransactionScanner(OrderConst.AppName, OrderConst.TxServiceGroup);
    }
}

