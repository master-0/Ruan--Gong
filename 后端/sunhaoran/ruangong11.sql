/*
 Navicat Premium Data Transfer

 Source Server         : sunhaoran
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : ruangong11

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 04/04/2020 20:21:30
*/

SET NAMES utf8mb4;
drop database if exists DeviceManagement;
create database DeviceManagement;
use DeviceManagement;
SET FOREIGN_KEY_CHECKS = 0;


-- ----------------------------
-- Table structure for logs
-- ----------------------------
DROP TABLE IF EXISTS `logs`;
CREATE TABLE `logs`  (
  `log_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '日志编号',
  `dev_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备编号',
  `dev_status` int(1) NULL DEFAULT NULL COMMENT '设备出借状态(1:空闲,2:出借)',
  `dev_work_status` int(1) NULL DEFAULT NULL COMMENT '设备状态(1:正常,2:报废,3:故障,4:维修)',
  `token_id` int(1) NULL DEFAULT NULL COMMENT '指令编号(1:借取,2:归还,3:修理,4:报废,5:确认报废记录)',
  `token_status` int(1) NULL DEFAULT NULL COMMENT '指令执行状态(1:执行成功,2:执行失败)',
  `user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '执行操作用户编号',
  `change_time` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更改日期,格式\"xxxxyear_xxmonth_xxday\"(24小时制)',
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

alter table logs comment '设备日志记录表';

-- ----------------------------
-- Table structure for devices
-- ----------------------------
DROP TABLE IF EXISTS `devices`;
CREATE TABLE `devices`  (
  `dev_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备编号',
  `dev_type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备类别',
  `dev_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备名称',
  `dev_type_num` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备型号',
  `dev_prise` float(10, 2) NOT NULL COMMENT '买入价格',
  `dev_date` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '购置日期,格式\"xxxxyear_xxmonth_xxday\"(24小时制)',
  `dev_prov` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '生产厂家',
  `dev_period` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '保质期',
  `charge_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经办人id',
  `manager_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人id',
  `dev_work_status` int(1) NULL DEFAULT NULL COMMENT '设备工作状态(1:空闲,2:出借)',
  `dev_status` int(1) NULL DEFAULT NULL COMMENT '设备状态(1:正常,2:报废,3:故障,4:维修)',
  PRIMARY KEY (`dev_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

alter table devices comment '设备信息表';

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user_id` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '用户编号',
  `user_name` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `user_account` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '用户账号',
  `user_password` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '用户密码',
  `user_power` int(1) NULL DEFAULT NULL COMMENT '用户权限(1.领导,2.设备负责人,3.经办人,4.一般用户)',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

alter table users comment '用户表';

SET FOREIGN_KEY_CHECKS = 1;
