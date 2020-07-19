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

 Date: 23/06/2020 23:06:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for emails
-- ----------------------------
DROP TABLE IF EXISTS `emails`;
CREATE TABLE `emails`  (
  `user_account` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `email_address` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`user_account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emails
-- ----------------------------
INSERT INTO `emails` VALUES ('17182626', '296684505@qq.com');
INSERT INTO `emails` VALUES ('17182627', '164878954@qq.com');
INSERT INTO `emails` VALUES ('TestUserAccount', '296684505@qq.com');

SET FOREIGN_KEY_CHECKS = 1;
