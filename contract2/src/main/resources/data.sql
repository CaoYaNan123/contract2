/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.32 : Database - service
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`service` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `service`;

/*Table structure for table `t_bill` */

DROP TABLE IF EXISTS `t_bill`;

CREATE TABLE `t_bill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bill_no` bigint(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `cus_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_u_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

/*Data for the table `t_bill` */

insert  into `t_bill`(`id`,`bill_no`,`status`,`cus_id`,`create_time`,`update_time`,`update_u_id`) values (1,201706200001,0,10,'2017-06-20 14:08:21','2017-06-22 23:13:39',1),(2,201706200002,1,2,'2017-06-20 14:08:59','2017-06-22 23:13:49',1),(3,201706200003,0,2,'2017-06-20 14:09:05','2017-06-22 23:13:51',1),(4,201706200004,2,2,'2017-06-20 14:09:08','2017-06-22 23:13:53',1),(5,201706200005,3,2,'2017-06-20 14:09:10','2017-06-22 23:13:56',1),(6,201706200006,0,3,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(7,201706200007,0,3,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(8,201706200008,0,2,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(9,201706200009,0,1,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(10,201706200010,0,3,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(11,201706200011,0,3,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(12,201706200012,0,3,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(13,201706200013,0,2,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(14,201706200014,0,3,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(15,201706200015,0,3,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(16,201706200016,0,2,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(17,201706200017,0,1,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(18,201706200018,0,2,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(19,201706200018,1,2,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(20,201706200018,2,3,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(21,201706200018,1,2,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(22,201706200018,2,1,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(23,201706200018,3,1,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(24,201706200018,1,2,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(25,201706200018,3,3,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(26,201706200018,2,2,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(27,201706200018,1,3,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(28,201706200018,4,3,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(29,201706200018,4,2,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(30,201706200018,4,2,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(31,201706200018,4,2,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(32,201706200018,2,3,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(33,201706200018,1,2,'2017-06-23 09:02:05','2017-06-23 09:02:05',1),(34,201706200018,1,1,'2017-06-23 09:02:05','2017-06-23 09:02:05',1);

/*Table structure for table `t_bill_detail` */

DROP TABLE IF EXISTS `t_bill_detail`;

CREATE TABLE `t_bill_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bill_id` bigint(20) DEFAULT NULL,
  `device_id` bigint(20) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `c_desc` varchar(200) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_u_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `t_bill_detail` */

insert  into `t_bill_detail`(`id`,`bill_id`,`device_id`,`num`,`c_desc`,`create_time`,`create_u_id`) values (1,1,1,1,'电视损坏','2017-06-20 14:09:50',NULL),(2,1,2,1,'电脑显示器损坏','2017-06-20 14:10:02',NULL),(3,2,1,1,'电视损坏','2017-06-20 14:10:44',NULL),(4,2,2,1,'电脑显示器损坏','2017-06-20 14:10:46',NULL),(5,2,3,1,'沙发损坏','2017-06-20 14:10:49',NULL),(6,3,1,1,'电视损坏','2017-06-20 14:11:39',NULL),(7,4,2,1,'电脑显示器损坏','2017-06-20 14:11:50',NULL),(8,5,2,1,'电脑显示器损坏','2017-06-20 14:12:14',NULL),(9,5,3,1,'沙发损坏','2017-06-20 14:12:17',NULL);

/*Table structure for table `t_cate_param_name` */

DROP TABLE IF EXISTS `t_cate_param_name`;

CREATE TABLE `t_cate_param_name` (
  `param_name_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `param_name` varchar(100) DEFAULT NULL,
  `param_desc` varchar(200) DEFAULT NULL,
  `param_data_type` varchar(20) DEFAULT NULL,
  `cate_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`param_name_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_cate_param_name` */

insert  into `t_cate_param_name`(`param_name_id`,`param_name`,`param_desc`,`param_data_type`,`cate_id`,`create_time`) values (1,'尺寸',NULL,'int',4,'2017-06-20 14:18:08'),(2,'颜色',NULL,'string',4,'2017-06-20 14:18:20'),(3,'品牌',NULL,'string',4,'2017-06-20 14:18:24'),(4,'重量',NULL,'int',4,'2017-06-20 14:18:26'),(5,'屏幕类型',NULL,'string',4,'2017-06-20 14:18:28');

/*Table structure for table `t_category` */

DROP TABLE IF EXISTS `t_category`;

CREATE TABLE `t_category` (
  `cat_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(50) DEFAULT NULL,
  `cat_desc` varchar(100) DEFAULT NULL,
  `parent_cat_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `cat_level` int(11) DEFAULT NULL,
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `t_category` */

insert  into `t_category`(`cat_id`,`cat_name`,`cat_desc`,`parent_cat_id`,`create_time`,`cat_level`) values (1,'总类别','总类别',0,'2017-06-20 13:49:22',1),(2,'电器','电器',1,'2017-06-20 13:49:53',2),(3,'家具','家具',1,'2017-06-20 13:49:56',2),(4,'电视','电视',2,'2017-06-20 13:50:24',3),(5,'电脑','电脑',2,'2017-06-20 13:50:43',3),(6,'办公家具','办公家具',3,'2017-06-20 13:51:12',3);

/*Table structure for table `t_contract` */

DROP TABLE IF EXISTS `t_contract`;

CREATE TABLE `t_contract` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `concat_person` varchar(50) DEFAULT NULL,
  `concat_phone` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_u_id` bigint(11) DEFAULT NULL,
  `concat_no` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_contract` */

insert  into `t_contract`(`id`,`concat_person`,`concat_phone`,`create_time`,`create_u_id`,`concat_no`) values (1,'张三','13917378077','2017-06-20 13:41:35',1,'2017062000001'),(2,'张四','13917378077','2017-06-20 13:41:43',1,'2017062000002'),(3,'张五','13317378088','2017-06-20 13:41:56',1,'2017062000003');

/*Table structure for table `t_contract_wx` */

DROP TABLE IF EXISTS `t_contract_wx`;

CREATE TABLE `t_contract_wx` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `weixin_no` varchar(50) DEFAULT NULL,
  `contract_id` bigint(20) DEFAULT NULL,
  `create_u_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_contract_wx` */

/*Table structure for table `t_device` */

DROP TABLE IF EXISTS `t_device`;

CREATE TABLE `t_device` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `device_name` varchar(200) DEFAULT NULL,
  `d_cat_id` bigint(20) DEFAULT NULL,
  `con_id` bigint(20) DEFAULT NULL,
  `start_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_u_id` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_u_id` bigint(20) DEFAULT NULL,
  `d_desc` varchar(200) DEFAULT NULL,
  `d_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_device` */

insert  into `t_device`(`id`,`device_name`,`d_cat_id`,`con_id`,`start_time`,`end_time`,`create_time`,`create_u_id`,`update_time`,`update_u_id`,`d_desc`,`d_status`) values (1,'电视机',4,1,'2017-06-01','2017-06-20','2017-06-20 00:00:00',1,'2017-06-20 00:00:00',1,NULL,0),(2,'电脑',5,1,'2017-06-01','2017-06-20','2017-06-20 13:56:06',1,'2017-06-20 13:56:11',1,NULL,0),(3,'沙发',6,1,'2017-06-01','2017-06-20','2017-06-20 13:57:31',1,'2017-06-20 13:57:35',1,NULL,0);

/*Table structure for table `t_device_pram` */

DROP TABLE IF EXISTS `t_device_pram`;

CREATE TABLE `t_device_pram` (
  `d_param_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `device_id` bigint(20) DEFAULT NULL,
  `d_param_name_id` bigint(20) DEFAULT NULL,
  `d_param_value` varchar(200) DEFAULT NULL,
  `d_other_value` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`d_param_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_device_pram` */

insert  into `t_device_pram`(`d_param_id`,`device_id`,`d_param_name_id`,`d_param_value`,`d_other_value`) values (1,4,1,'52英寸',NULL),(2,4,2,'黑色',NULL),(3,4,3,'夏普',NULL),(4,4,4,'15KG',NULL),(5,4,5,'4K高清',NULL);

/*Table structure for table `t_menu` */

DROP TABLE IF EXISTS `t_menu`;

CREATE TABLE `t_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `m_name` varchar(50) DEFAULT NULL,
  `m_url` varchar(50) DEFAULT NULL,
  `is_display` int(11) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_u_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_menu` */

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(30) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_u_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_role` */

/*Table structure for table `t_role_menu` */

DROP TABLE IF EXISTS `t_role_menu`;

CREATE TABLE `t_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `menu_id` bigint(20) DEFAULT NULL,
  `create_u_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_role_menu` */

/*Table structure for table `t_service_log` */

DROP TABLE IF EXISTS `t_service_log`;

CREATE TABLE `t_service_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `service_id` bigint(20) DEFAULT NULL,
  `deal_u_id` bigint(20) DEFAULT NULL,
  `oprerate_u_id` bigint(20) DEFAULT NULL,
  `oprerate_time` datetime DEFAULT NULL,
  `opreate_event` varchar(100) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_u_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_service_log` */

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(20) DEFAULT NULL,
  `u_cname` varchar(20) DEFAULT NULL,
  `u_password` varchar(20) DEFAULT NULL,
  `u_gender` int(11) DEFAULT NULL,
  `u_role_id` bigint(20) DEFAULT NULL,
  `u_phone` varchar(20) DEFAULT NULL,
  `u_address` varchar(200) DEFAULT NULL,
  `u_status` int(11) DEFAULT NULL,
  `ceate_time` datetime DEFAULT NULL,
  `u_weixin` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`u_name`,`u_cname`,`u_password`,`u_gender`,`u_role_id`,`u_phone`,`u_address`,`u_status`,`ceate_time`,`u_weixin`) values (1,'lisan','李三','fhkjjjimdphmoecm',0,1,'15678787888','长沙市岳麓区金鑫大厦2楼',0,'2017-06-20 13:45:50','808888888'),(2,'lisi','李四','fhkjjjimdphmoecm',1,1,'13878787999','长沙市岳麓区金鑫大厦2楼',0,'2017-06-20 13:46:38','909999999'),(3,'liwu','李五','fhkjjjimdphmoecm',0,1,'13678787666','长沙市岳麓区金鑫大厦2楼',0,'2017-06-20 13:47:19','707777777'),(4,'admin','admin','jlehfdffcfmohiag',0,1,'13678787666','长沙市岳麓区金鑫大厦2楼',0,'2017-06-20 13:47:19','909999999');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;



