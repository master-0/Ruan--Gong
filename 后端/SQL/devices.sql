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

 Date: 23/06/2020 23:06:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for devices
-- ----------------------------
DROP TABLE IF EXISTS `devices`;
CREATE TABLE `devices`  (
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
-- Records of devices
-- ----------------------------
INSERT INTO `devices` VALUES (-1, 'TestDevName', 'TestDevType', 0.00, 'Fri May 29 10:06:15 UTC 2020', 'TestDevPeriod', 'TestChargeAccount', NULL, 'TestUserAccount', 1, 1, 0);
INSERT INTO `devices` VALUES (0, 'Dev_1', 'type_1', 1000.00, 'Fri May 29 10:06:15 UTC 2020', '365', 'Charge', NULL, 'Manager1', 1, 1, 3);
INSERT INTO `devices` VALUES (1, 'Dev_1', 'type_1', 1000.00, 'Fri May 29 10:06:15 UTC 2020', '365', 'Charge', '17182624', 'Manager1', 1, 2, 3);
INSERT INTO `devices` VALUES (2, 'Dev_1', 'type_1', 1000.00, 'Fri May 29 10:06:15 UTC 2020', '365', 'Charge', '17182624', 'Manager1', 1, 2, 3);
INSERT INTO `devices` VALUES (3, 'Dev_1', 'type_1', 1000.00, 'Fri May 29 10:06:15 UTC 2020', '365', 'Charge', '17182627', 'Manager1', 2, 2, 3);
INSERT INTO `devices` VALUES (4, 'Dev_1', 'type_1', 1000.00, 'Fri May 29 10:06:15 UTC 2020', '365', 'Charge', 'TestUserAccount', 'Manager1', 1, 2, 3);
INSERT INTO `devices` VALUES (5, 'Dev_1', 'type_1', 1000.00, 'Fri May 29 10:06:15 UTC 2020', '365', 'Charge', '17182626', 'Manager1', 1, 2, 3);
INSERT INTO `devices` VALUES (6, 'Dev_3', 'type_1', 1000.00, 'Fri May 29 10:06:15 UTC 2020', '365', 'Charge', 'Userym', 'Manager1', 1, 2, 3);
INSERT INTO `devices` VALUES (7, 'Dev_1', 'type_1', 1000.00, 'Fri May 29 10:06:15 UTC 2020', '365', 'Charge', NULL, 'Manager1', 3, 1, 3);
INSERT INTO `devices` VALUES (8, 'Dev_1', 'type_1', 1000.00, 'Fri May 29 10:06:15 UTC 2020', '365', 'Charge', '17182624', 'Manager1', 1, 2, 3);
INSERT INTO `devices` VALUES (9, 'Dev_4', 'type_1', 1000.00, 'Fri May 29 10:06:15 UTC 2020', '365', 'Charge', 'Userym', 'Manager1', 1, 2, 3);
INSERT INTO `devices` VALUES (10, 'Dev_2', 'type_2', 1000.00, 'Fri May 29 10:07:01 UTC 2020', '365', 'Charge', '17182625', 'Manager2', 3, 2, 3);
INSERT INTO `devices` VALUES (11, 'Dev_2', 'type_2', 1000.00, 'Fri May 29 10:07:01 UTC 2020', '365', 'Charge', 'TestUserAccount', 'Manager2', 1, 2, 3);
INSERT INTO `devices` VALUES (12, 'Dev_2', 'type_2', 1000.00, 'Fri May 29 10:07:01 UTC 2020', '365', 'Charge', '17182625', 'Manager2', 3, 2, 3);
INSERT INTO `devices` VALUES (13, 'Dev_2', 'type_2', 1000.00, 'Fri May 29 10:07:01 UTC 2020', '365', 'Charge', '17182624', 'Manager2', 1, 2, 3);
INSERT INTO `devices` VALUES (14, 'Dev_2', 'type_2', 1000.00, 'Fri May 29 10:07:01 UTC 2020', '365', 'Charge', '17182625', 'Manager2', 1, 2, 3);
INSERT INTO `devices` VALUES (15, 'Dev_1', 'type_2', 1000.00, 'Fri May 29 10:07:01 UTC 2020', '365', 'Charge', '17182624', 'TestUserAccount', 3, 2, 3);
INSERT INTO `devices` VALUES (16, 'Dev_1', 'type_2', 1000.00, 'Fri May 29 10:07:01 UTC 2020', '365', 'Charge', '17182680', 'TestUserAccount', 3, 2, 3);
INSERT INTO `devices` VALUES (17, 'Dev_2', 'type_2', 1000.00, 'Fri May 29 10:07:01 UTC 2020', '365', 'Charge', '17182624', 'TestUserAccount', 3, 2, 3);
INSERT INTO `devices` VALUES (18, 'Dev_2', 'type_2', 1000.00, 'Fri May 29 10:07:01 UTC 2020', '365', 'Charge', NULL, 'TestUserAccount', 3, 1, 3);
INSERT INTO `devices` VALUES (19, 'Dev_2', 'type_2', 1000.00, 'Fri May 29 10:07:01 UTC 2020', '365', 'Charge', '17182624', 'TestUserAccount', 2, 2, 3);
INSERT INTO `devices` VALUES (21, 'dev_5', 'type_1', 100.00, 'Sun May 31 10:06:23 UTC 2020', '365', 'Charge', 'TestUserAccount', 'Manager1', 1, 2, 3);
INSERT INTO `devices` VALUES (22, 'dev_test', 'type_3', 1000.00, 'Sun May 31 14:54:03 UTC 2020', '365', 'Charge', NULL, 'Manager1', 2, 1, 3);
INSERT INTO `devices` VALUES (23, 'dev_test', 'type_3', 1000.00, 'Sun May 31 14:54:03 UTC 2020', '365', 'Charge', NULL, 'Manager1', 3, 1, 3);
INSERT INTO `devices` VALUES (24, 'dev_test', 'type_3', 1000.00, 'Sun May 31 14:54:03 UTC 2020', '365', 'Charge', '17182680', 'Manager1', 3, 2, 3);
INSERT INTO `devices` VALUES (25, 'devtemp2', 'tyoe', 100.00, 'Mon Jun 15 15:40:40 CST 2020', '100', 'Charge', '17182624', 'Manager1', 3, 2, 3);
INSERT INTO `devices` VALUES (26, 'devtemp3', 'tyoe', 100.00, 'Mon Jun 15 15:48:41 CST 2020', '100', 'Charge', '17182627', 'Manager1', 3, 2, 3);
INSERT INTO `devices` VALUES (27, 'devtemp3', 'tyoe', 100.00, 'Mon Jun 15 15:48:42 CST 2020', '100', 'Charge', '17182624', 'TestUserAccount', 1, 2, 3);
INSERT INTO `devices` VALUES (28, 'devtemp3', 'tyoe', 100.00, 'Mon Jun 15 15:48:42 CST 2020', '100', 'Charge', '17182608', 'TestUserAccount', 1, 2, 3);
INSERT INTO `devices` VALUES (29, 'newDevName', 'newDevType', 100.00, 'Mon Jun 15 22:06:46 CST 2020', 'newDevPeriod', 'TestUserAccount', '17182608', 'TestUserAccount', 1, 2, 3);
INSERT INTO `devices` VALUES (30, 'newDevName', 'newDevType', 100.00, 'Mon Jun 15 22:08:56 CST 2020', 'newDevPeriod', 'TestUserAccount', '17182608', 'TestUserAccount', 1, 2, 3);
INSERT INTO `devices` VALUES (31, 'dev_3', 'type_3', 100.00, 'Tue Jun 16 06:37:11 UTC 2020', '1000', 'Charge', '17182625', 'Manager1', 1, 2, 3);
INSERT INTO `devices` VALUES (32, 'dev_3', 'type_3', 100.00, 'Tue Jun 16 06:37:11 UTC 2020', '1000', 'Charge', '17182625', 'Manager1', 1, 2, 3);
INSERT INTO `devices` VALUES (33, 'dev_3', 'type_3', 100.00, 'Tue Jun 16 06:37:11 UTC 2020', '1000', 'Charge', '17182625', 'Manager1', 1, 2, 3);
INSERT INTO `devices` VALUES (34, 'dev_3', 'type_2', 100.00, 'Tue Jun 16 06:40:47 UTC 2020', '100', '17182625', '17182627', 'Manager2', 4, 2, 2);
INSERT INTO `devices` VALUES (35, 'devTemp', 'tope', 100.00, 'Tue Jun 16 10:01:38 UTC 2020', '365', 'Charge', '17182627', 'Manager1', 5, 2, 3);
INSERT INTO `devices` VALUES (36, 'newDevName', 'newDevType', 100.00, 'Wed Jun 17 17:35:55 CST 2020', 'newDevPeriod', 'TestUserAccount', NULL, 'Manager2', 1, 1, 3);
INSERT INTO `devices` VALUES (37, 'newDevName', 'newDevType', 100.00, 'Wed Jun 17 17:35:55 CST 2020', 'newDevPeriod', 'TestUserAccount', NULL, 'Manager1', 1, 1, 3);
INSERT INTO `devices` VALUES (38, 'newDevName', 'newDevType', 100.00, 'Wed Jun 17 17:35:55 CST 2020', 'newDevPeriod', 'TestUserAccount', NULL, 'Manager1', 1, 1, 3);
INSERT INTO `devices` VALUES (39, 'dev_2', 'type_1', 100.00, 'Wed Jun 17 13:18:03 UTC 2020', '365', 'TestUserAccount', '17182608', 'Manager2', 1, 2, 2);
INSERT INTO `devices` VALUES (40, 'dev_2', 'type_2', 100.00, 'Wed Jun 17 13:27:53 UTC 2020', '365', 'TestUserAccount', '17182625', 'Manager2', 1, 2, 3);
INSERT INTO `devices` VALUES (41, 'dev_2', 'type_2', 100.00, 'Wed Jun 17 13:27:53 UTC 2020', '365', 'TestUserAccount', NULL, 'Manager1', 1, 1, 3);
INSERT INTO `devices` VALUES (42, 'dev_2', 'type_1', 112.00, 'Wed Jun 17 14:48:31 UTC 2020', '114', '17182625', NULL, 'Manager1', 1, 1, 3);
INSERT INTO `devices` VALUES (43, 'dev_shr', 'type_3', 10203030.00, 'Mon Jun 22 13:17:42 UTC 2020', '7777', '17182627', NULL, 'Manager1', 1, 1, 1);
INSERT INTO `devices` VALUES (44, 'dev_1', 'type_2', 12.00, 'Wed Jun 17 15:55:48 UTC 2020', '5', '17182625', NULL, 'Manager1', 1, 1, 3);
INSERT INTO `devices` VALUES (45, 'dev_1', 'type_1', 100.00, 'Tue Jun 23 13:26:53 UTC 2020', '209', 'Charge', NULL, 'Manager1', 1, 1, 3);
INSERT INTO `devices` VALUES (46, 'dev_1', 'type_1', 100.00, 'Tue Jun 23 13:26:53 UTC 2020', '209', 'Charge', NULL, 'Manager2', 1, 1, 3);
INSERT INTO `devices` VALUES (47, 'dev_456', 'type_013', 100.00, 'Tue Jun 23 13:59:19 UTC 2020', '340', 'Charge', NULL, 'Manager1', 1, 1, 3);
INSERT INTO `devices` VALUES (48, 'dev_456', 'type_013', 100.00, 'Tue Jun 23 13:59:19 UTC 2020', '340', 'Charge', NULL, 'Manager2', 1, 1, 3);
INSERT INTO `devices` VALUES (49, 'dev_456', 'type_013', 100.00, 'Tue Jun 23 13:59:19 UTC 2020', '340', 'Charge', NULL, 'Manager2', 1, 1, 3);

SET FOREIGN_KEY_CHECKS = 1;
