/*
 * Copyright (C) KRT, 2019 by kiterunner_t
 * TO THE HAPPY FEW
 */

package com.krt.equipment.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.krt.equipment.EquipmentConst;


@FeignClient(value = EquipmentConst.OrderAppName)
public interface OrderClient {
    @PostMapping(value = "/order/add")
    void add(@RequestParam("equipId") int equipId);
}

