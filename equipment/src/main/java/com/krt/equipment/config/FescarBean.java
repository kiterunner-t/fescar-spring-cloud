/*
 * Copyright (C) KRT, 2019 by kiterunner_t
 * TO THE HAPPY FEW
 */

package com.krt.equipment.config;

import com.alibaba.fescar.spring.annotation.GlobalTransactionScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.krt.equipment.EquipmentConst;


@Configuration
public class FescarBean {
    @Bean
    public GlobalTransactionScanner transactionScanner() {
        return new GlobalTransactionScanner(EquipmentConst.AppName, EquipmentConst.TxServiceGroup);
    }
}

