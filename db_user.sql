/*
Navicat MySQL Data Transfer

Source Server         : ej
Source Server Version : 50725
Source Host           : 134.175.100.63:3306
Source Database       : queue

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2020-03-04 17:33:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for db_user
-- ----------------------------
DROP TABLE IF EXISTS `db_user`;
CREATE TABLE `db_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_user
-- ----------------------------
INSERT INTO `db_user` VALUES ('1', '123', '对公业务');

-- ----------------------------
-- Table structure for money_user
-- ----------------------------
DROP TABLE IF EXISTS `money_user`;
CREATE TABLE `money_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of money_user
-- ----------------------------

-- ----------------------------
-- Table structure for owner
-- ----------------------------
DROP TABLE IF EXISTS `owner`;
CREATE TABLE `owner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of owner
-- ----------------------------

-- ----------------------------
-- Table structure for vip_user
-- ----------------------------
DROP TABLE IF EXISTS `vip_user`;
CREATE TABLE `vip_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vip_user
-- ----------------------------
