/**
 * Copyright (C) KRT, 2019 by kiterunner_t
 * TO THE HAPPY FEW
 */

package com.krt.equipment.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krt.equipment.service.EquipmentService;


@Api(value = "hmi equipment", description = "获取和添加设备")
@RestController
@RequestMapping("/hmi/equipment")
public class EquipmentController {
    @Autowired private EquipmentService equipmentService;


    @PostMapping(value = "addEquipments")
    @ApiOperation(value = "添加设备到HMI", notes = "")
    public String addEquipments(@RequestParam Integer hmiId,
                                @RequestBody List<Integer> equipmentIdList){
        equipmentService.addEquipments(hmiId, equipmentIdList);
        return "ResponseSuccess";
    }
}

