/*
 * Copyright (C) KRT, 2019 by kiterunner_t
 * TO THE HAPPY FEW
 */

package com.krt.order.dao.mapper;

import org.apache.ibatis.annotations.Param;

import com.krt.order.dao.entity.OrderEntity;


public interface OrderDao {
    void insert(@Param("order") OrderEntity order);
}

