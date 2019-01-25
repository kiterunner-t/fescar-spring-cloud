/**
 * Copyright (C) KRT, 2019 by kiterunner_t
 * TO THE HAPPY FEW
 */

package com.krt.equipment.dao.entity;

import java.sql.Timestamp;

import lombok.Data;


@Data
public class HmiEquipmentEntity {
    private Integer equipmentId;
    private Integer hmiId;
    private String hmiIp;
    private Timestamp createTime;
    private Timestamp modifyTime;


    public HmiEquipmentEntity(Integer equipmentId, Integer hmiId, String ip) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        this.hmiIp = ip;
        this.equipmentId = equipmentId;
        this.hmiId = hmiId;
        this.createTime = now;
        this.modifyTime = now;
    }
}

