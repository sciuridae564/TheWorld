/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 8.0.12 : Database - boki
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`boki` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE `boki`;

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `city_name` VARCHAR(8) DEFAULT NULL COMMENT '名称',
  `city_time` DATETIME NOT NULL COMMENT '创建时间',
  `city_count` INT(10) UNSIGNED DEFAULT NULL COMMENT '就业人数',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `city` */

INSERT  INTO `city`(`id`,`city_name`,`city_time`,`city_count`) VALUES (1,'红魔馆','2020-06-06 00:00:00',2),(2,'破败的 神社','2020-06-06 00:00:00',1),(3,'白玉楼','2020-06-06 00:00:00',1),(4,'大自然','2020-06-06 00:00:00',3),(5,'向日葵田','2020-06-06 00:00:00',1),(6,'GO','2020-06-06 00:00:00',2);

/*Table structure for table `class` */

DROP TABLE IF EXISTS `class`;

CREATE TABLE `class` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `class_id` BIGINT(20) UNSIGNED DEFAULT NULL COMMENT '班级编号',
  `class_name` VARCHAR(16) NOT NULL COMMENT '班级名称',
  `class_leader_id` INT(10) UNSIGNED DEFAULT NULL COMMENT '班长id,不是学号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `class_id` (`class_id`)
) ENGINE=INNODB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `class` */

INSERT  INTO `class`(`id`,`class_id`,`class_name`,`class_leader_id`) VALUES (1,114514,'理科教室',2),(2,114515,'文科教室',8);

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `account_name` VARCHAR(20) NOT NULL COMMENT '用户名',
  `account_password` CHAR(60) DEFAULT NULL COMMENT '密码密文',
  `regtime` DATETIME DEFAULT NULL COMMENT '注册时间',
  `role` TINYINT(1) DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `login` */

INSERT  INTO `login`(`id`,`account_name`,`account_password`,`regtime`,`role`) VALUES (1,'baka','$2a$10$HZ1hIeqbyaDKDL6K/dmFzepXpjW/XNDngPgDCHxZfes7dno.SFns6','2020-06-06 00:00:00',0),(2,'heitai','$2a$10$h8lpFUFHGLa2Mo6ZHU5jjuWRWCpcCJm6Utm3Ljh1UC0khz1PScIkW','2020-06-06 00:00:00',1),(3,'baka','$2a$10$LEYypMuxfIV5aRolEqWBRON7r4F0CqVi2djh6c4NygLCDpAWz8L22','2020-06-06 00:00:00',1),(4,'baka','$2a$10$PYYFPK0FTPMmsjfBBg5IJek1ltFo06wevTldMr0ea76jCOHdjSctq','2020-06-06 00:00:00',0);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `student_id` BIGINT(20) UNSIGNED DEFAULT NULL COMMENT '学生学号',
  `student_name` VARCHAR(16) NOT NULL COMMENT '学生姓名',
  `student_sex` TINYINT(1) DEFAULT NULL COMMENT '学生性别',
  `student_bir` DATETIME DEFAULT NULL COMMENT '学生生日',
  `student_class_id` INT(10) UNSIGNED DEFAULT NULL COMMENT '学生班级id',
  `student_team_id` INT(10) UNSIGNED DEFAULT NULL COMMENT '学生组别id',
  `qq_number` BIGINT(20) UNSIGNED DEFAULT NULL COMMENT '学生qq号',
  `work_city` INT(10) UNSIGNED DEFAULT NULL COMMENT '学生就业城市',
  PRIMARY KEY (`id`),
  UNIQUE KEY `student_id` (`student_id`)
) ENGINE=INNODB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

INSERT  INTO `student`(`id`,`student_id`,`student_name`,`student_sex`,`student_bir`,`student_class_id`,`student_team_id`,`qq_number`,`work_city`) VALUES (1,5412541254,'风见幽香',0,'2016-04-28 00:00:00',1,1,2254155421,5),(2,8527835834,'八云紫',0,'2016-06-12 00:00:00',1,1,5235325743,6),(3,8534758345,'博丽灵梦',0,'2016-01-30 00:00:00',1,2,453452378,2),(4,9345334354,'蕾米莉亚',0,'1998-07-22 00:00:00',1,3,5435345354,1),(5,8725233534,'十六夜咲夜',0,'1986-05-16 00:00:00',2,4,534534538,1),(6,5435387553,'帕秋莉',0,'2000-11-15 00:00:00',2,4,46363874,6),(7,5438453453,'幽幽子',0,'2001-07-04 00:00:00',2,5,8378553345,3),(8,4538753245,'琪露诺',0,'2002-06-06 00:00:00',2,5,753878335,4);

/*Table structure for table `tags` */

DROP TABLE IF EXISTS `tags`;

CREATE TABLE `tags` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `tags_name` VARCHAR(20) DEFAULT NULL COMMENT '标签名称',
  `tags_type` TINYINT(1) DEFAULT NULL COMMENT '标签种类',
  `tags_createtime` DATETIME DEFAULT NULL COMMENT '标签创建时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `tags` */

INSERT  INTO `tags`(`id`,`tags_name`,`tags_type`,`tags_createtime`) VALUES (1,'笨蛋',1,'2020-06-06 00:00:00'),(2,'贤者',1,'2020-06-06 00:00:00'),(3,'筋肉脑袋',1,'2020-06-06 00:00:00'),(4,'威严',1,'2020-06-06 00:00:00'),(5,'博爱',1,'2020-06-06 00:00:00'),(6,'怕生',1,'2020-06-06 00:00:00'),(7,'智慧',1,'2020-06-06 00:00:00'),(8,'友爱',0,'2020-06-06 00:00:00'),(9,'富强',0,'2020-06-06 00:00:00');

/*Table structure for table `tags_to_class` */

DROP TABLE IF EXISTS `tags_to_class`;

CREATE TABLE `tags_to_class` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `tags_class_id` INT(10) UNSIGNED DEFAULT NULL COMMENT '班级id',
  `tags_tags_id` INT(10) UNSIGNED DEFAULT NULL COMMENT '标签id',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tags_to_class` */

INSERT  INTO `tags_to_class`(`id`,`tags_class_id`,`tags_tags_id`) VALUES (1,0,7),(2,1,8);

/*Table structure for table `tags_to_student` */

DROP TABLE IF EXISTS `tags_to_student`;

CREATE TABLE `tags_to_student` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `tags_student_id` INT(10) UNSIGNED DEFAULT NULL COMMENT '学生id',
  `tags_tags_id` INT(10) UNSIGNED DEFAULT NULL COMMENT '标签id',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `tags_to_student` */

INSERT  INTO `tags_to_student`(`id`,`tags_student_id`,`tags_tags_id`) VALUES (1,0,4),(2,1,1),(3,1,1),(4,8,0),(5,8,6),(6,5,2),(7,3,6),(8,4,2),(9,3,3),(10,7,5);

/*Table structure for table `team` */

DROP TABLE IF EXISTS `team`;

CREATE TABLE `team` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `team_id` BIGINT(20) UNSIGNED DEFAULT NULL COMMENT '小组编号',
  `team_name` VARCHAR(16) NOT NULL COMMENT '小组名称',
  `team_class_id` INT(10) UNSIGNED DEFAULT NULL COMMENT '小组对应的班级id',
  `team_nick` VARCHAR(16) DEFAULT NULL COMMENT '小组昵称',
  `team_slo` VARCHAR(100) DEFAULT NULL COMMENT '小组标语',
  `team_leader_id` INT(10) UNSIGNED DEFAULT NULL COMMENT '组长id,不是学号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `team_id` (`team_id`)
) ENGINE=INNODB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `team` */

INSERT  INTO `team`(`id`,`team_id`,`team_name`,`team_class_id`,`team_nick`,`team_slo`,`team_leader_id`) VALUES (1,5432453,'大姐姐',1,'无','无',1),(2,45387354,'天下难逢一敌手',1,'独钓寒江雪','高处不胜寒',3),(3,378453245,'红色的',1,'暖暖的','无',5),(4,87394534,'gogogo',2,'go','go',6),(5,45345345,'蓝色的(?)',2,'想不出来！','没有！',8);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
