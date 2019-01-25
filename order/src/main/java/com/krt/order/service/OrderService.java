/*
 * Copyright (C) KRT, 2019 by kiterunner_t
 * TO THE HAPPY FEW
 */

package com.krt.order.service;

import java.sql.Timestamp;

import com.alibaba.fescar.core.context.RootContext;
import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krt.order.dao.entity.OrderEntity;
import com.krt.order.dao.mapper.OrderDao;


@Service
public class OrderService {
    @Autowired private OrderDao orderDao;


    @GlobalTransactional
    public void add(int equipId) {
        System.out.println("============>>>>>>>> " + RootContext.getXID());

        OrderEntity order = new OrderEntity();
        order.setEquipmentId(equipId);

        Timestamp current = new Timestamp(System.currentTimeMillis());
        order.setCreateTime(current);
        order.setModifyTime(current);
        orderDao.insert(order);
    }
}

