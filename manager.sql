/*
 Navicat MySQL Data Transfer

 Source Server         : repair_management
 Source Server Type    : MySQL
 Source Server Version : 80030 (8.0.30)
 Source Host           : localhost:3306
 Source Schema         : manager

 Target Server Type    : MySQL
 Target Server Version : 80030 (8.0.30)
 File Encoding         : 65001

 Date: 26/12/2022 22:54:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for complain
-- ----------------------------
DROP TABLE IF EXISTS `complain`;
CREATE TABLE `complain`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `owner_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of complain
-- ----------------------------
INSERT INTO `complain` VALUES (1, 'c', 'very good');

-- ----------------------------
-- Table structure for dispatcher
-- ----------------------------
DROP TABLE IF EXISTS `dispatcher`;
CREATE TABLE `dispatcher`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dispatcher
-- ----------------------------
INSERT INTO `dispatcher` VALUES (1, 'd');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES (1, 'm');

-- ----------------------------
-- Table structure for owners
-- ----------------------------
DROP TABLE IF EXISTS `owners`;
CREATE TABLE `owners`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of owners
-- ----------------------------
INSERT INTO `owners` VALUES (1, 'o_1');
INSERT INTO `owners` VALUES (2, 'o_2');

-- ----------------------------
-- Table structure for repairtable
-- ----------------------------
DROP TABLE IF EXISTS `repairtable`;
CREATE TABLE `repairtable`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `owner_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `worker_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dispatcher_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `fault_type` int NULL DEFAULT NULL,
  `fault_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `launch_route` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `launch_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `working_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `repair_evaluation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of repairtable
-- ----------------------------
INSERT INTO `repairtable` VALUES (1, 'o_1', NULL, NULL, 0, '电梯故障', '微信', '2022-12-26T21:59', NULL, NULL, 0);
INSERT INTO `repairtable` VALUES (2, 'o_1', NULL, NULL, 0, '电梯故障', '微信', '2022-12-26T21:59', NULL, NULL, 0);
INSERT INTO `repairtable` VALUES (3, 'o_1', NULL, NULL, 0, '电梯故障', '微信', '2022-12-26T22:16', NULL, NULL, 0);
INSERT INTO `repairtable` VALUES (4, 'o_1', NULL, NULL, 0, '电梯故障', '微信', '2022-12-26T22:19', NULL, NULL, 0);
INSERT INTO `repairtable` VALUES (5, 'o_1', NULL, NULL, 0, '电梯故障', '微信', '2022-12-26T22:19', NULL, NULL, 0);
INSERT INTO `repairtable` VALUES (6, 'o_1', NULL, NULL, 0, '电梯故障', '微信', '2022-12-26T22:26', NULL, NULL, 0);
INSERT INTO `repairtable` VALUES (7, 'o_1', NULL, NULL, 0, '电梯故障', '微信', '2022-12-26T22:30', NULL, NULL, 0);
INSERT INTO `repairtable` VALUES (8, 'o_1', NULL, NULL, 0, '电梯故障', '微信', '2022-12-26T22:37', NULL, NULL, 0);
INSERT INTO `repairtable` VALUES (9, 'o_1', NULL, NULL, 0, '电梯故障', '微信', '2022-12-26T22:38', NULL, NULL, 0);
INSERT INTO `repairtable` VALUES (10, 'o_1', NULL, NULL, 0, '电梯故障', '微信', '2022-12-26T22:51', NULL, NULL, 0);

-- ----------------------------
-- Table structure for repairtablerecord
-- ----------------------------
DROP TABLE IF EXISTS `repairtablerecord`;
CREATE TABLE `repairtablerecord`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `repairTableId` int NULL DEFAULT NULL,
  `worker_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `start_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `end_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of repairtablerecord
-- ----------------------------

-- ----------------------------
-- Table structure for workers
-- ----------------------------
DROP TABLE IF EXISTS `workers`;
CREATE TABLE `workers`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `type` int NOT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of workers
-- ----------------------------
INSERT INTO `workers` VALUES (1, 'w_1', 1, 0);
INSERT INTO `workers` VALUES (2, 'w_2', 2, 0);

SET FOREIGN_KEY_CHECKS = 1;
