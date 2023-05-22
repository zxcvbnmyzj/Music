/*
 Navicat Premium Data Transfer

 Source Server         : User
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : redisuser

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 22/05/2023 09:21:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for album
-- ----------------------------
DROP TABLE IF EXISTS `album`;
CREATE TABLE `album`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `albumName` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `singerId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`, `singerId`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of album
-- ----------------------------

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `favoritesId` bigint(20) NOT NULL,
  `musicId` bigint(20) NOT NULL,
  `favoritesDate` datetime NOT NULL,
  PRIMARY KEY (`id`, `favoritesId`, `musicId`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of collect
-- ----------------------------

-- ----------------------------
-- Table structure for favorites
-- ----------------------------
DROP TABLE IF EXISTS `favorites`;
CREATE TABLE `favorites`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) NOT NULL,
  `createDate` datetime NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `userId`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of favorites
-- ----------------------------

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
  `id` bigint(20) NOT NULL,
  `fileName` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `fileUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of file
-- ----------------------------

-- ----------------------------
-- Table structure for lyric
-- ----------------------------
DROP TABLE IF EXISTS `lyric`;
CREATE TABLE `lyric`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `lyricUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lyric
-- ----------------------------

-- ----------------------------
-- Table structure for music
-- ----------------------------
DROP TABLE IF EXISTS `music`;
CREATE TABLE `music`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `musicName` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `musicSingerId` bigint(255) NOT NULL,
  `musicUrlId` bigint(255) NOT NULL,
  `musicStyleId` bigint(255) NOT NULL,
  `albumId` bigint(255) NOT NULL,
  `lyricId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`, `albumId`, `musicSingerId`, `musicUrlId`, `musicStyleId`, `lyricId`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of music
-- ----------------------------
INSERT INTO `music` VALUES (1, '半岛铁盒', 1, 1, 1, 0, 0);

-- ----------------------------
-- Table structure for singer
-- ----------------------------
DROP TABLE IF EXISTS `singer`;
CREATE TABLE `singer`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `SName` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Area` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of singer
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` int(30) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `userPass` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `userSex` varchar(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `userEmail` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `userState` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '红黑', '123456', '男', '125@qq.com', '已删除');
INSERT INTO `user` VALUES (2, '二叉', '123', '女', '153@qq.com', '正常');
INSERT INTO `user` VALUES (3, 'yohane', '123456', '男', '189@qq.com', '正常');
INSERT INTO `user` VALUES (4, '坏人', '123', '男', '15@qq.com', '正常');
INSERT INTO `user` VALUES (7, '小小怪', '123', '男', '15@qq.com', '已删除');
INSERT INTO `user` VALUES (8, '大大怪', '123', '男', '15@qq.com', '已删除');
INSERT INTO `user` VALUES (9, '昔日', '123', '男', '15@qq.com', '已删除');
INSERT INTO `user` VALUES (10, '呆呆杨', '123', '男', '10@qq.com', '正常');
INSERT INTO `user` VALUES (11, '人热', '123', '男', '10@qq.com', '正常');
INSERT INTO `user` VALUES (12, '王磊', '1526', '男', '159@qq.com', '正常');
INSERT INTO `user` VALUES (13, '胡盛旻', '156', '女', '1568@qq.com', '正常');

SET FOREIGN_KEY_CHECKS = 1;
