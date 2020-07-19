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

 Date: 23/06/2020 23:05:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attentions
-- ----------------------------
DROP TABLE IF EXISTS `attentions`;
CREATE TABLE `attentions`  (
  `user_account` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '用户账号',
  `dev_id` int(20) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of attentions
-- ----------------------------
INSERT INTO `attentions` VALUES ('17182608', 1);
INSERT INTO `attentions` VALUES ('17182608', 14);
INSERT INTO `attentions` VALUES ('TestUserAccount', 12);
INSERT INTO `attentions` VALUES ('TestUserAccount', 30);
INSERT INTO `attentions` VALUES ('17182626', 5);
INSERT INTO `attentions` VALUES ('17182608', 11);
INSERT INTO `attentions` VALUES ('17182624', 15);
INSERT INTO `attentions` VALUES ('17182624', 16);
INSERT INTO `attentions` VALUES ('17182624', 17);
INSERT INTO `attentions` VALUES ('17182624', 19);
INSERT INTO `attentions` VALUES ('17182624', 21);
INSERT INTO `attentions` VALUES ('17182624', 24);
INSERT INTO `attentions` VALUES ('17182624', 25);
INSERT INTO `attentions` VALUES ('17182624', 27);
INSERT INTO `attentions` VALUES ('17182627', 0);
