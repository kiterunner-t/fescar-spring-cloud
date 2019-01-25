/**
 * Copyright (C) KRT, 2019 by kiterunner_t
 * TO THE HAPPY FEW
 */

package com.krt.equipment.service;

import java.sql.Timestamp;
import java.util.List;

import com.alibaba.fescar.core.context.RootContext;
import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krt.equipment.dao.mapper.EquipmentDao;
import com.krt.equipment.dao.mapper.HmiEquipmentDao;
import com.krt.equipment.dao.entity.HmiEquipmentEntity;
import com.krt.equipment.remote.OrderClient;


@Service
public class EquipmentService {
    @Autowired private EquipmentDao equipmentDao;
    @Autowired private HmiEquipmentDao hmiEquipmentDao;

    @Autowired private OrderClient orderClient;


    @GlobalTransactional
    public void addEquipments(Integer hmiId, List<Integer> equipmentIdList) {
        System.out.println("============>>>>>>>> " + RootContext.getXID());

        // just a example, please do not like this ...
        Timestamp current = new Timestamp(System.currentTimeMillis());
        for (Integer equipId: equipmentIdList) {
            orderClient.add(equipId);

            String ip = equipmentDao.getEquipmentIp(equipId, current);
            hmiEquipmentDao.addEquipment(new HmiEquipmentEntity(equipId, hmiId, ip));
        }
    }
}

