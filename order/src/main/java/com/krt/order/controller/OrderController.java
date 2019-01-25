/*
 * Copyright (C) KRT, 2019 by kiterunner_t
 * TO THE HAPPY FEW
 */

package com.krt.order.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krt.order.service.OrderService;


@Api(value = "order", description = "order")
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired private OrderService orderService;


    @PostMapping(value = "add")
    @ApiOperation(value = "添加order", notes = "")
    public String add(@RequestParam int equipId) {
        orderService.add(equipId);
        return "ResponseSuccess";
    }
}

