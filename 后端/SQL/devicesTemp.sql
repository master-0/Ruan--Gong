/*
 Navicat Premium Data Transfer

 Source Server         : ruangong_shr
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : 39.102.35.212:3306
 Source Schema         : DeviceManagement

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 23/06/2020 23:06:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for devicesTemp
-- ----------------------------
DROP TABLE IF EXISTS `devicesTemp`;
CREATE TABLE `devicesTemp`  (
  `dev_id` int(20) NOT NULL COMMENT '设备编号',
  `dev_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备名称',
  `dev_type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备型号',
  `dev_prise` float(10, 2) NOT NULL COMMENT '买入价格',
  `dev_date` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '购置日期(自动获取)',
  `dev_period` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '保质期',
  `charge_account` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经办人账号',
  `user_account` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出借人账号',
  `manager_account` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人账号',
  `dev_work_status` int(1) NULL DEFAULT NULL COMMENT '设备状态(1:正常,2:报废,3:故障,4:维修,5:待报废)',
  `dev_status` int(1) NULL DEFAULT NULL COMMENT '设备工作状态(1:空闲,2:出借)',
  `dev_auth` int(1) NOT NULL COMMENT '设备权限等级',
  PRIMARY KEY (`dev_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of devicesTemp
-- ----------------------------
INSERT INTO `devicesTemp` VALUES (-1, 'TestName', 'TestType', 0.00, 'TestDate', 'TestPeriod', 'TestChargeAccount', 'TestUserAccount', 'TestManagerAccount', 3, 0, 0);
INSERT INTO `devicesTemp` VALUES (0, 'devtemp1', 'tyoe', 100.00, 'Mon Jun 15 14:16:24 CST 2020', '100', 'Charge', NULL, NULL, 1, 1, 3);
INSERT INTO `devicesTemp` VALUES (1, 'devtemp2', 'tyoe', 100.00, 'Mon Jun 15 15:40:40 CST 2020', '100', 'Charge', NULL, NULL, 1, 1, 3);
INSERT INTO `devicesTemp` VALUES (2, 'devtemp3', 'tyoe', 100.00, 'Mon Jun 15 15:48:41 CST 2020', '100', 'Charge', NULL, NULL, 1, 1, 3);
INSERT INTO `devicesTemp` VALUES (3, 'devtemp3', 'tyoe', 100.00, 'Mon Jun 15 15:48:42 CST 2020', '100', 'Charge', NULL, NULL, 1, 1, 3);
INSERT INTO `devicesTemp` VALUES (4, 'devtemp3', 'tyoe', 100.00, 'Mon Jun 15 15:48:42 CST 2020', '100', 'Charge', NULL, NULL, 1, 1, 3);
INSERT INTO `devicesTemp` VALUES (5, 'newDevName', 'newDevType', 100.00, 'Mon Jun 15 23:32:20 CST 2020', 'newDevPeriod', 'TestUserAccount', NULL, NULL, 1, 1, 3);
INSERT INTO `devicesTemp` VALUES (6, 'newDevName', 'newDevType', 100.00, 'Tue Jun 16 00:02:52 CST 2020', 'newDevPeriod', 'TestUserAccount', NULL, NULL, 1, 1, 3);
INSERT INTO `devicesTemp` VALUES (7, 'dev_3', 'type_3', 100.00, 'Tue Jun 16 06:37:11 UTC 2020', '1000', 'Charge', NULL, NULL, 1, 1, 3);
INSERT INTO `devicesTemp` VALUES (8, 'dev_3', 'type_2', 100.00, 'Tue Jun 16 06:40:47 UTC 2020', '100', '17182625', NULL, NULL, 1, 1, 2);
INSERT INTO `devicesTemp` VALUES (9, 'devTemp', 'tope', 100.00, 'Tue Jun 16 10:01:38 UTC 2020', '365', 'Charge', NULL, NULL, 1, 1, 3);
INSERT INTO `devicesTemp` VALUES (10, 'newDevName', 'newDevType', 100.00, 'Tue Jun 16 20:52:56 CST 2020', 'newDevPeriod', 'TestUserAccount', NULL, NULL, 1, 1, 3);
INSERT INTO `devicesTemp` VALUES (11, 'newDevName', 'newDevType', 100.00, 'Wed Jun 17 15:48:53 CST 2020', 'newDevPeriod', 'TestUserAccount', NULL, NULL, 1, 1, 3);
INSERT INTO `devicesTemp` VALUES (12, 'newDevName', 'newDevType', 100.00, 'Wed Jun 17 16:29:02 CST 2020', 'newDevPeriod', 'TestUserAccount', NULL, NULL, 1, 1, 3);
INSERT INTO `devicesTemp` VALUES (13, 'newDevName', 'newDevType', 100.00, 'Wed Jun 17 17:35:55 CST 2020', 'newDevPeriod', 'TestUserAccount', NULL, NULL, 1, 1, 3);
INSERT INTO `devicesTemp` VALUES (14, 'dev_2', 'type_1', 100.00, 'Wed Jun 17 13:18:03 UTC 2020', '365', 'TestUserAccount', NULL, NULL, 1, 1, 2);
INSERT INTO `devicesTemp` VALUES (15, 'dev_2', 'type_1', 11.00, 'Wed Jun 17 13:27:14 UTC 2020', '11', '17182625', NULL, NULL, 1, 1, 3);
INSERT INTO `devicesTemp` VALUES (16, 'dev_2', 'type_2', 11.00, 'Wed Jun 17 13:27:30 UTC 2020', '1', '17182625', NULL, NULL, 1, 1, 2);
INSERT INTO `devicesTemp` VALUES (17, 'dev_2', 'type_2', 100.00, 'Wed Jun 17 13:27:53 UTC 2020', '365', 'TestUserAccount', NULL, NULL, 1, 1, 3);
INSERT INTO `devicesTemp` VALUES (18, 'dev_2', 'type_2', 100.00, 'Wed Jun 17 13:27:53 UTC 2020', '365', 'TestUserAccount', NULL, NULL, 1, 1, 3);
INSERT INTO `devicesTemp` VALUES (19, 'dev_2', 'type_2', 100.00, 'Wed Jun 17 13:27:53 UTC 2020', '365', 'TestUserAccount', NULL, NULL, 1, 1, 3);
INSERT INTO `devicesTemp` VALUES (20, 'dev_2', 'type_2', 1.00, 'Wed Jun 17 13:28:59 UTC 2020', '100', 'TestUserAccount', NULL, NULL, 1, 1, 3);
INSERT INTO `devicesTemp` VALUES (21, 'dev_2', 'type_1', 112.00, 'Wed Jun 17 14:48:31 UTC 2020', '114', '17182625', NULL, NULL, 1, 1, 3);
INSERT INTO `devicesTemp` VALUES (22, 'dev_1', 'type_2', 12.00, 'Wed Jun 17 15:55:48 UTC 2020', '5', '17182625', NULL, NULL, 1, 1, 3);
INSERT INTO `devicesTemp` VALUES (23, 'dev_shr', 'type_3', 10203030.00, 'Mon Jun 22 13:17:42 UTC 2020', '7777', '17182627', NULL, NULL, 1, 1, 1);
INSERT INTO `devicesTemp` VALUES (24, 'dev_shr', 'type_3', 10203030.00, 'Mon Jun 22 13:17:42 UTC 2020', '7777', '17182627', NULL, NULL, 1, 1, 1);
INSERT INTO `devicesTemp` VALUES (25, 'dev_1', 'type_1', 100.00, 'Tue Jun 23 13:26:53 UTC 2020', '209', 'Charge', NULL, NULL, 1, 1, 3);
INSERT INTO `devicesTemp` VALUES (26, 'dev_1', 'type_1', 100.00, 'Tue Jun 23 13:26:53 UTC 2020', '209', 'Charge', NULL, NULL, 1, 1, 3);
INSERT INTO `devicesTemp` VALUES (27, 'newDevName', 'newDevType', 100.00, 'Tue Jun 23 21:34:02 CST 2020', 'newDevPeriod', 'TestUserAccount', NULL, NULL, 1, 1, 3);
INSERT INTO `devicesTemp` VALUES (28, 'newDevName', 'newDevType', 100.00, 'Tue Jun 23 21:44:09 CST 2020', 'newDevPeriod', 'TestUserAccount', NULL, NULL, 1, 1, 3);
INSERT INTO `devicesTemp` VALUES (29, 'dev_456', 'type_013', 100.00, 'Tue Jun 23 13:59:19 UTC 2020', '340', 'Charge', NULL, NULL, 1, 1, 3);
INSERT INTO `devicesTemp` VALUES (30, 'dev_456', 'type_013', 100.00, 'Tue Jun 23 13:59:19 UTC 2020', '340', 'Charge', NULL, NULL, 1, 1, 3);
INSERT INTO `devicesTemp` VALUES (31, 'dev_456', 'type_013', 100.00, 'Tue Jun 23 13:59:19 UTC 2020', '340', 'Charge', NULL, NULL, 1, 1, 3);

SET FOREIGN_KEY_CHECKS = 1;
