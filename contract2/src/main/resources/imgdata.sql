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

/*Table structure for table `t_img` */

DROP TABLE IF EXISTS `t_img`;

CREATE TABLE `t_img` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bill_detail_id` bigint(20) DEFAULT NULL,
  `img_url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_img` */

insert  into `t_img`(`id`,`bill_detail_id`,`img_url`) values (1,1,'imgupload/ssss.jpg'),(2,1,'imgupload/aaaa.gif'),(3,1,'imgupload/bbbb.png');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
