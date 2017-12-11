/*
Navicat MySQL Data Transfer

Source Server         : 101.132.140.132
Source Server Version : 50719
Source Host           : 101.132.140.132:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-12-11 12:19:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) NOT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT '849723885@qq.com',
  `admin_group` int(2) NOT NULL DEFAULT '0',
  `avatar_image` varchar(255) DEFAULT NULL COMMENT '头像图片',
  `status` int(3) DEFAULT '0' COMMENT '0为启用，1为禁用，2为异常',
  `ip` varchar(15) DEFAULT NULL,
  `ip_address` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for admin_group
-- ----------------------------
DROP TABLE IF EXISTS `admin_group`;
CREATE TABLE `admin_group` (
  `admin_group_id` int(40) NOT NULL AUTO_INCREMENT,
  `admin_group_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_group
-- ----------------------------
INSERT INTO `admin_group` VALUES ('1', '管理员');
INSERT INTO `admin_group` VALUES ('2', '普通用户');

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_title` varchar(255) NOT NULL,
  `article_content` text NOT NULL,
  `article_admin` varchar(255) NOT NULL,
  `article_image` varchar(255) DEFAULT 'article.png',
  `article_tag` int(2) DEFAULT '1',
  `article_click` int(11) unsigned DEFAULT '0' COMMENT '点击量',
  `article_like` int(11) unsigned DEFAULT '0' COMMENT '点赞数',
  `article_dislike` int(11) DEFAULT NULL COMMENT '差赞数',
  `comment_count` int(11) DEFAULT NULL COMMENT '评论数量',
  `article_class` int(11) DEFAULT '1' COMMENT '文章类别',
  `article_commend` int(2) DEFAULT '0' COMMENT '是否推荐：0.不推荐，1.推荐到首页',
  `article_status` int(3) NOT NULL DEFAULT '0' COMMENT '状态，0为显示，1为隐藏，3为删除',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '大是打算', '3213321萨是顶', '倒萨', 'article.png', '1', '0', '0', null, null, '0', '0', '0', '2017-12-09 15:15:01', '2017-12-09 15:17:55');
INSERT INTO `article` VALUES ('2', '3123', '123', '12', 'article.png', '1', '0', '0', null, null, null, '0', '0', '2017-12-09 15:15:09', '2017-12-09 15:17:56');

-- ----------------------------
-- Table structure for article_article_tag
-- ----------------------------
DROP TABLE IF EXISTS `article_article_tag`;
CREATE TABLE `article_article_tag` (
  `id` int(11) NOT NULL,
  `article_id` int(11) DEFAULT NULL,
  `tag_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='article和tag的关系表';

-- ----------------------------
-- Records of article_article_tag
-- ----------------------------

-- ----------------------------
-- Table structure for article_class
-- ----------------------------
DROP TABLE IF EXISTS `article_class`;
CREATE TABLE `article_class` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章类别id',
  `class_name` varchar(255) DEFAULT NULL COMMENT '文章类别名',
  `class_status` int(1) DEFAULT '0' COMMENT '状态0为启用，1为禁用',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_class
-- ----------------------------
INSERT INTO `article_class` VALUES ('1', '代码', '0', null, null);
INSERT INTO `article_class` VALUES ('2', '生活', '0', null, null);
INSERT INTO `article_class` VALUES ('3', '读书笔记', '0', null, null);

-- ----------------------------
-- Table structure for article_comment
-- ----------------------------
DROP TABLE IF EXISTS `article_comment`;
CREATE TABLE `article_comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_name` varchar(255) DEFAULT '匿名' COMMENT '评论者姓名',
  `comment_content` text,
  `comment_ip` varchar(15) DEFAULT NULL COMMENT 'ip',
  `comment_status` int(2) DEFAULT '0' COMMENT '0为启用，1为删除',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_comment
-- ----------------------------

-- ----------------------------
-- Table structure for article_tag
-- ----------------------------
DROP TABLE IF EXISTS `article_tag`;
CREATE TABLE `article_tag` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(255) DEFAULT NULL,
  `tag_status` int(1) DEFAULT '0' COMMENT '状态0为启用，1为禁用',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_tag
-- ----------------------------
INSERT INTO `article_tag` VALUES ('1', 'jquery', null, null, null);
INSERT INTO `article_tag` VALUES ('2', 'html5程序', null, null, null);
INSERT INTO `article_tag` VALUES ('3', '1q84', null, null, null);

-- ----------------------------
-- Table structure for carsouel
-- ----------------------------
DROP TABLE IF EXISTS `carsouel`;
CREATE TABLE `carsouel` (
  `carousel_id` int(11) NOT NULL AUTO_INCREMENT,
  `carousel_title` varchar(255) DEFAULT '轮播图标题',
  `carousel_image` varchar(255) DEFAULT 'carousel.jpg',
  `carousel_url` varchar(255) DEFAULT 'index.html',
  `carousel_sort` int(3) DEFAULT NULL COMMENT '轮播图排序',
  PRIMARY KEY (`carousel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carsouel
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) NOT NULL,
  `sort` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for friend_link
-- ----------------------------
DROP TABLE IF EXISTS `friend_link`;
CREATE TABLE `friend_link` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `link_location` varchar(255) NOT NULL,
  `link_name` varchar(255) NOT NULL,
  `link_url` varchar(255) NOT NULL,
  `create_admin` varchar(255) NOT NULL,
  `link_status` int(2) DEFAULT NULL COMMENT '状态，0为启用，1为禁用',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friend_link
-- ----------------------------

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `message_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `message_name` varchar(255) DEFAULT '匿名',
  `message_value` varchar(255) DEFAULT NULL,
  `message_uid` int(11) DEFAULT NULL COMMENT '回复留言id',
  `message_replaynum` int(11) DEFAULT '0' COMMENT '回复量',
  `message_ip` varchar(15) DEFAULT NULL COMMENT 'ip',
  `message_address` varchar(255) DEFAULT NULL COMMENT 'ip地址',
  `message_contact` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123456', 'yjyjyjy', '849723885@qq.com', '2017-11-10 15:13:49', '2017-12-13 15:13:58');
