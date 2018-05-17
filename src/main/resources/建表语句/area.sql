CREATE TABLE `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `area_name` varchar(255) NOT NULL COMMENT '地区名称',
  `resolution` int(10) NOT NULL COMMENT '空间分辨率(m)',
  `img_name` varchar(255) NOT NULL COMMENT '图片名称',
  `coastline_length` int(11) NOT NULL DEFAULT '0' COMMENT '海岸线长度',
  `coastline_type` int(2) NOT NULL COMMENT '海岸线类型',
  `delete_mark` int(2) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `img_time` datetime NOT NULL COMMENT '成像时间',
  PRIMARY KEY (`id`),
  KEY `I_img_name` (`img_name`) USING BTREE,
  KEY `I_img_time` (`img_time`),
  KEY `I_area_name` (`area_name`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4;