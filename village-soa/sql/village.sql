CREATE DATABASE happy_village DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for villager
-- ----------------------------
-- DROP TABLE IF EXISTS `villager`;
CREATE TABLE `villager` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `username` VARCHAR(32) COMMENT '用户名',
  `phone` VARCHAR(11) NOT NULL COMMENT '手机号',
  `password` VARCHAR(32) COMMENT '密码',
  `nick_name` VARCHAR(32) COMMENT '昵称',
  `head_image` VARCHAR(64) COMMENT '头像',
  `sex` INT(11) COMMENT '性别 1:男 2:女',
  `village_people` INT(11) COMMENT '是否欢乐村民 1:不是 2:是',
  `village_head` INT(11) COMMENT '是否欢乐村长 1:不是 2:是',
  `village_merchant` INT(11) COMMENT '是否欢乐商户 1:不是 2:是',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
  `status` INT(11) DEFAULT '1' COMMENT '可用性 0:不可用 1:可用',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;