/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 100132
 Source Host           : localhost:3306
 Source Schema         : community

 Target Server Type    : MySQL
 Target Server Version : 100132
 File Encoding         : 65001

 Date: 16/11/2020 00:03:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NOT NULL,
  `type` int(255) NULL DEFAULT NULL,
  `commentator` bigint(255) NOT NULL COMMENT '评论人id',
  `gmt_create` bigint(255) NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(255) NOT NULL COMMENT '更新时间',
  `like_count` bigint(255) NOT NULL DEFAULT 0 COMMENT '点赞数',
  `content` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comment_count` int(255) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 1, 1, 1, 1564822367111, 1564822367111, 0, '1312312', 0);
INSERT INTO `comment` VALUES (2, 1, 1, 1, 1564822552400, 1564822552400, 0, '3123112', 0);
INSERT INTO `comment` VALUES (3, 1, 1, 1, 1564823515557, 1564823515557, 0, '可以', 0);
INSERT INTO `comment` VALUES (4, 1, 1, 1, 1564824817710, 1564824817710, 0, '1321213', 0);
INSERT INTO `comment` VALUES (5, 1, 1, 1, 1564824836844, 1564824836844, 0, '1321213', 0);
INSERT INTO `comment` VALUES (6, 1, 1, 1, 1564824884042, 1564824884042, 0, '31231', 0);
INSERT INTO `comment` VALUES (7, 1, 1, 1, 1564825018620, 1564825018620, 0, '312312', 0);
INSERT INTO `comment` VALUES (8, 1, 1, 1, 1564825059822, 1564825059822, 0, '第N个评论', 0);
INSERT INTO `comment` VALUES (9, 1, 1, 1, 1565066108144, 1565066108144, 0, '312312', 0);
INSERT INTO `comment` VALUES (10, 1, 1, 1, 1565066123164, 1565066123164, 0, '12312312', 0);
INSERT INTO `comment` VALUES (11, 1, 1, 1, 1565066154036, 1565066154036, 0, '这是几个评论呀！！！', 0);
INSERT INTO `comment` VALUES (12, 1, 1, 1, 1565068151830, 1565068151830, 0, '啊实打实打算', 0);
INSERT INTO `comment` VALUES (13, 1, 1, 1, 1565068151830, 1565068151830, 0, '啊实打实打算', 0);
INSERT INTO `comment` VALUES (14, 1, 1, 1, 1565069116677, 1565069116677, 0, '23123', 0);
INSERT INTO `comment` VALUES (15, 1, 1, 1, 1565069424687, 1565069424687, 0, '3123123', 0);
INSERT INTO `comment` VALUES (16, 1, 1, 1, 1565070140366, 1565070140366, 0, '31231', 0);
INSERT INTO `comment` VALUES (17, 1, 1, 1, 1565070162724, 1565070162724, 0, '31313', 0);

-- ----------------------------
-- Table structure for notification
-- ----------------------------
DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `notifier` bigint(255) NOT NULL,
  `receiver` bigint(255) NOT NULL,
  `outerId` bigint(20) NOT NULL,
  `type` int(255) NOT NULL,
  `gmt_create` bigint(255) NOT NULL,
  `status` int(255) NOT NULL DEFAULT 0,
  `notifier_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `outer_title` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `gmt_create` bigint(20) NULL DEFAULT NULL,
  `gmt_modified` bigint(20) NULL DEFAULT NULL,
  `creator` bigint(11) NULL DEFAULT NULL,
  `comment_count` int(11) NULL DEFAULT 0,
  `view_count` int(11) NULL DEFAULT 0,
  `like_count` int(11) NULL DEFAULT NULL,
  `tag` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (1, '我的第一个问题', '问题的补充', 1564821639056, 1564821639056, 1, 17, 58, 0, '无法添加标题');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `account_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `token` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_create` bigint(20) NULL DEFAULT NULL,
  `gmt_modified` bigint(20) NULL DEFAULT NULL,
  `bio` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '49390399', '晨边啊啊', 'c328f68e-efe6-4573-be01-6cc7a0c8bf73', 1564821608312, 1565551052715, NULL, 'https://avatars2.githubusercontent.com/u/49390399?v=4');

SET FOREIGN_KEY_CHECKS = 1;
