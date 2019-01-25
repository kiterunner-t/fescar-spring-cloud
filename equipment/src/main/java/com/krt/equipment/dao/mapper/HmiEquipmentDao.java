/**
 * Copyright (C) KRT, 2019 by kiterunner_t
 * TO THE HAPPY FEW
 */

package com.krt.equipment.dao.mapper;

import org.springframework.stereotype.Repository;

import com.krt.equipment.dao.entity.HmiEquipmentEntity;


@Repository
public interface HmiEquipmentDao {
    void addEquipment(HmiEquipmentEntity hmiEquipmentEntity);
}
