CREATE TABLE `hmi_equipment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `hmi_id` bigint(20) NOT NULL,
  `equipment_id` bigint NOT NULL,
  `hmi_ip` CHAR(30) NOT NULL,
  `create_time` datetime NOT NULL,
  `modify_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `bd_equipment` (
  `equipment_id` bigint not null,
  `equipment_code` CHAR(30) NOT NULL,
  `equipment_name` CHAR(30) NOT NULL,
  `ip_addr` CHAR(30) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `create_time` datetime NOT NULL,
  `modify_time` datetime NOT NULL,
  PRIMARY KEY (`equipment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `hmi_order` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `equipment_id` bigint NOT NULL,
  `create_time` datetime NOT NULL,
  `modify_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_unionkey` (`xid`,`branch_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8


INSERT INTO bd_equipment (
    equipment_id, equipment_code, equipment_name, ip_addr,
    start_time, end_time,
    create_time, modify_time
)
VALUES (
    1, "TEST-EQUIP-1", "测试设备1", "127.0.0.1",
    "2019-01-01 00:00:00", "2099-01-01 00:00:00",
    "2019-01-01 00:00:00", "2019-01-01 00:00:00"
);

