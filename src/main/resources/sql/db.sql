-- CREATE DATABASE `test_db2`;
-- USE `test_db2`;

-- DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(32) NOT NULL COMMENT '用户名称',
  `birthday` DATE DEFAULT NULL COMMENT '生日',
  `gender` CHAR(1) DEFAULT NULL COMMENT '性别',
  `address` VARCHAR(256) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- DROP TABLE IF EXISTS `order_item`;
CREATE TABLE IF NOT EXISTS `order_item` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(32) NOT NULL COMMENT '商品名称',
  `price` FLOAT(10,1) NOT NULL COMMENT '商品定价',
  `detail` TEXT COMMENT '商品描述',
  `pic` VARCHAR(64) DEFAULT NULL COMMENT '商品图片URL',
  `create_time` DATETIME NOT NULL COMMENT '生产日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL COMMENT '下单用户id',
  `number` VARCHAR(32) NOT NULL COMMENT '订单号',
  `create_time` DATETIME NOT NULL COMMENT '创建订单时间',
  `note` VARCHAR(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_orders#user_id_ref_user#id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE IF NOT EXISTS `order_detail` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `order_id` INT(11) NOT NULL COMMENT '订单id',
  `item_id` INT(11) NOT NULL COMMENT '商品id',
  `item_num` INT(11) DEFAULT NULL COMMENT '商品购买数量',
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_order_detail#orders_id_ref_orders#id` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`),
  CONSTRAINT `FK_order_detail#items_id_ref_items#id` FOREIGN KEY (`item_id`) REFERENCES `order_item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

INSERT INTO `user`(`id`, `username`, `birthday`, `gender`, `address`) VALUES
  (10, '张三', NULL, '2', NULL),
  (11, '王五', '1999-9-9', '1', '北京'),
  (16, '李四', NULL, '1', '上海'),
  (22, 'HAHA', NULL, '1', '东京'),
  (24, 'HEHE', NULL, '1', '南京'),
  (25, 'Tom', NULL, '1', '好像没有西京'),
  (26, 'JJ', NULL, NULL, NULL);

INSERT INTO `order_item` (`id`, `name`, `price`, `detail`, `pic`, `create_time`) VALUES
  (1, 'iPhone', 6000.0, '?????????', NULL, NOW()),
  (2, 'Abidiaosi', 60.0, 'xxxxxxx', NULL, NOW()),
  (3, 'NiKie', 200.0, '。。。。。。。', NULL, NOW());

INSERT INTO `order`(`id`, `user_id`, `number`, `create_time`, `note`) VALUES
  (3, 10, '1000010', NOW(), NULL),
  (4, 11, '1000011', NOW(), NULL),
  (5, 22, '1000012', NOW(), NULL);

INSERT INTO `order_detail`(`id`, `order_id`, `item_id`, `item_num`) VALUES (1, 3, 1, 1), (2, 3, 2, 3), (3, 4, 3, 4), (4, 4, 2, 3);

SELECT o.*, u.username, u.address, u.gender FROM `order` o JOIN `user` u ON o.user_id = u.id;
