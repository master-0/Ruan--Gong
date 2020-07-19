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

 Date: 23/06/2020 23:07:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user_id` int(20) NOT NULL COMMENT '用户编号',
  `user_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `user_account` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `user_password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `user_authority` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_account`(`user_account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (-1, 'TestUserName', 'TestUserAccount', 'TestUserPassword', 0);
INSERT INTO `users` VALUES (0, 'SunHaoran', '17182627', '17182627', 0);
INSERT INTO `users` VALUES (1, 'AAedion', '17182626', '17182626', -1);
INSERT INTO `users` VALUES (2, 'WangRunxin', '17182625', '17182625', 0);
INSERT INTO `users` VALUES (3, 'LiZiyi', '17182624', '17182624', 0);
INSERT INTO `users` VALUES (4, 'LiYixiang', '17182608', '17182608', 0);
INSERT INTO `users` VALUES (5, 'ZuoMingxin', '17182609', '17182609', -1);
INSERT INTO `users` VALUES (6, 'Boss1', 'Boss1', 'Boss1', 0);
INSERT INTO `users` VALUES (7, 'Charge', 'Charge', 'Charge', 1);
INSERT INTO `users` VALUES (8, 'Manager1', 'Manager1', 'Manager1', 2);
INSERT INTO `users` VALUES (9, 'Manager2', 'Manager2', 'Manager2', 2);
INSERT INTO `users` VALUES (10, 'User1', 'User1', 'User1', 3);
INSERT INTO `users` VALUES (11, 'Usertest', 'UserTest', '12345', 3);
INSERT INTO `users` VALUES (12, 'User123', 'User123', '321', 3);
INSERT INTO `users` VALUES (13, 'User321', 'User321', '123', 3);
INSERT INTO `users` VALUES (14, 'User', 'Userym', '321', 3);
INSERT INTO `users` VALUES (15, 'lfb', '17182680', 'aaaaaa', 0);
INSERT INTO `users` VALUES (16, 'NewName', 'NewAccount', 'NewPassword', 3);
INSERT INTO `users` VALUES (17, 'abc', 'abc', 'abc', 3);
INSERT INTO `users` VALUES (18, 'sunhaorantest', '17182627test', 'test', 3);
INSERT INTO `users` VALUES (19, 'aaaaaaaa', 'aaaaaaaa', 'aaaaaa', 3);
INSERT INTO `users` VALUES (20, 'djjxmxnxbxkz', 'snnzkzmzmxm', '111111', 3);

SET FOREIGN_KEY_CHECKS = 1;
