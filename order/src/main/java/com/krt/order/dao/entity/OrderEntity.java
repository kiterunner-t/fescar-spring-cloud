/*
 * Copyright (C) KRT, 2019 by kiterunner_t
 * TO THE HAPPY FEW
 */

package com.krt.order.dao.entity;

import java.sql.Timestamp;

import lombok.Data;


@Data
public class OrderEntity {
    private long id;
    private long equipmentId;
    private Timestamp createTime;
    private Timestamp modifyTime;
}

