/**
 * Copyright (C) KRT, 2019 by kiterunner_t
 * TO THE HAPPY FEW
 */

package com.krt.equipment.dao.mapper;

import java.sql.Timestamp;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface EquipmentDao {
    String getEquipmentIp(@Param("equipmentId") Integer equipmentId,
                          @Param("now") Timestamp now);
}

