/*
Navicat MySQL Data Transfer

Source Server         : 234432
Source Server Version : 50151
Source Host           : localhost:3306
Source Database       : mybatis01

Target Server Type    : MYSQL
Target Server Version : 50151
File Encoding         : 65001

Date: 2017-08-06 10:52:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `items`
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `detail` text,
  `pic` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of items
-- ----------------------------
INSERT INTO `items` VALUES ('1', '宝马760', '258', '89-258', null, null);
INSERT INTO `items` VALUES ('2', '宝马X3', '30', '25-35', null, null);
INSERT INTO `items` VALUES ('3', '宝马525Li', '43', '40-50', null, null);
INSERT INTO `items` VALUES ('4', '宝齐莱', '6', null, null, null);

-- ----------------------------
-- Table structure for `orderdetail`
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `id` int(11) NOT NULL DEFAULT '0',
  `orders_id` int(11) DEFAULT NULL,
  `items_id` int(11) DEFAULT NULL,
  `items_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `orders_id` (`orders_id`),
  KEY `items_id` (`items_id`),
  CONSTRAINT `orderdetail_ibfk_1` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `orderdetail_ibfk_2` FOREIGN KEY (`items_id`) REFERENCES `items` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
INSERT INTO `orderdetail` VALUES ('1', '0', '1', '1');
INSERT INTO `orderdetail` VALUES ('2', '1', '2', '1');
INSERT INTO `orderdetail` VALUES ('3', '3', '3', '1');
INSERT INTO `orderdetail` VALUES ('4', '0', '4', '1');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL DEFAULT '0',
  `user_id` int(11) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('0', '2', '1', '2017-07-05 20:49:09', '');
INSERT INTO `orders` VALUES ('1', '5', '1', '2017-07-25 20:49:40', '');
INSERT INTO `orders` VALUES ('3', '6', '1', '2017-07-29 20:50:10', '');
INSERT INTO `orders` VALUES ('4', '2', '1', '2017-07-29 09:26:35', null);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', '吴京', '男', '2017-07-09 12:16:15', '比安提');
INSERT INTO `user` VALUES ('5', '唐晶', '女', '2017-07-07 23:02:32', '比安提');
INSERT INTO `user` VALUES ('6', '吴京', null, null, null);
