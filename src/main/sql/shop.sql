-- 数据库初始化脚本
create database shop default charset=utf8;
use shop;

CREATE TABLE user(
	`user_id` bigint(20) NOT NULL AUTO_INCREMENT comment '用户id',
  	`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  	`number` varchar(30) NOT NULL unique comment '用户账号',
  	`password` varchar(30) NOT NULL comment '用户密码',
  	`nickname` varchar(255) NOT NULL comment '用户昵称',
  	`sex` varchar(8) NOT NULL comment '性别',
  	PRIMARY KEY (`user_id`)
) ENGINE=InnoDB auto_increment=10000 default charset=utf8;

CREATE TABLE category (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT comment '分类id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  `name` varchar(255) NOT NULL unique comment '分类名',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB auto_increment=10000 DEFAULT CHARSET=utf8;

CREATE TABLE product (
  	`product_id` bigint(20) NOT NULL AUTO_INCREMENT comment '产品id',
  	`name` varchar(255) NOT NULL unique comment '产品名称',
  	`create_time` timestamp NOT null ON UPDATE CURRENT_TIMESTAMP comment '创建时间',
  	`category_id` bigint(20) NOT NULL comment '分类id',
  	`attributes` varchar(255) DEFAULT NULL comment '属性，如：颜色,内存',
  	PRIMARY KEY (`product_id`),
  	constraint fk_product_category foreign key(category_id) references category(category_id)
) ENGINE=InnoDB auto_increment=10000 DEFAULT CHARSET=utf8;

CREATE TABLE property (
  	`property_id` bigint(20) NOT NULL AUTO_INCREMENT comment '属性id',
 	`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  	`name` varchar(255) NOT NULL comment '属性名',
  	`product_id` bigint(20) NOT NULL comment '产品id',
  	PRIMARY KEY (`property_id`),
  	constraint fk_product_property foreign key(product_id) references product(product_id)
) ENGINE=InnoDB auto_increment=10000 DEFAULT CHARSET=utf8;

CREATE TABLE property_value (
  `property_value_id` bigint(20) NOT NULL AUTO_INCREMENT comment '属性值id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  `property_id` bigint(20) NOT NULL comment '属性id',
  `value` varchar(255) DEFAULT NULL comment '属性值',
  PRIMARY KEY (`property_value_id`),
  constraint fk_property_property_value foreign key(property_id) references property(property_id)
) ENGINE=InnoDB auto_increment=10000 DEFAULT CHARSET=utf8;

CREATE TABLE goods (
  `goods_id` bigint(20) NOT NULL AUTO_INCREMENT comment '商品id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  `attributes` varchar(255) DEFAULT NULL comment '属性，如：白,32G',
  `product_id` bigint(20) NOT NULL comment '产品id',
  `original_price` double NOT NULL comment '原价',
  `sell_price` double NOT NULL comment '售价',
  PRIMARY KEY (`goods_id`),
  constraint fk_product_goods foreign key(product_id) references product(product_id)
) ENGINE=InnoDB auto_increment=10000 DEFAULT CHARSET=utf8;

CREATE TABLE inventory (
  `inventory_id` bigint(20) NOT NULL AUTO_INCREMENT comment '库存id',
  `goods_id` bigint(20) NOT NULL comment '商品id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  `inventory_number` bigint(20) NOT NULL comment '库存量',
  `sell_number` bigint(20) comment '销量',
  PRIMARY KEY (`inventory_id`),
  key index_sell_number(sell_number),
  constraint fk_goods_inventory foreign key(goods_id) references goods(goods_id)
) ENGINE=InnoDB auto_increment=10000 DEFAULT CHARSET=utf8;

CREATE TABLE shop_cart (
  `shop_cart_id` bigint(20) NOT NULL AUTO_INCREMENT comment '购物车id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  `goods_id` bigint(20) NOT NULL comment '商品id',
  `goods_number` bigint(20) NOT NULL comment '商品数量',
  `user_id` bigint(20) NOT NULL comment '用户id',
  PRIMARY KEY (`shop_cart_id`),
  constraint fk_goods_shop_cart foreign key(goods_id) references goods(goods_id),
  constraint fk_user_shop_cart foreign key(user_id) references user(user_id)
) ENGINE=InnoDB auto_increment=10000 DEFAULT CHARSET=utf8;

CREATE TABLE orders (
  `orders_id` bigint(20) NOT NULL AUTO_INCREMENT comment '订单id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  `harvest_address` varchar(500) NOT NULL comment '收货地址',
  `status` int(11) NOT NULL comment '订单状态码',
  `user_id` bigint(20) NOT NULL comment '用户id',
  `total_price` double NOT NULL comment '总价格',
  PRIMARY KEY (`orders_id`),
  constraint fk_user_order foreign key(user_id) references user(user_id)
) ENGINE=InnoDB auto_increment=10000 DEFAULT CHARSET=utf8;

CREATE TABLE order_item (
  `order_item_id` bigint(20) NOT NULL AUTO_INCREMENT comment '订单项id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  `goods_id` bigint(20) NOT NULL comment '商品id',
  `orders_id` bigint(20) NOT NULL comment '订单id',
  `goods_number` bigint(20) NOT NULL comment '商品数量',
  PRIMARY KEY (`order_item_id`),
  constraint fk_order_order_item foreign key(orders_id) references orders(orders_id),
  constraint fk_good_order_item foreign key(goods_id) references goods(goods_id)
) ENGINE=InnoDB auto_increment=10000 DEFAULT CHARSET=utf8;



