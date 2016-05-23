# --------------------------------------------------------
# Host:                         127.0.0.1
# Server version:               5.7.11
# Server OS:                    Win64
# HeidiSQL version:             6.0.0.3603
# Date/time:                    2016-05-23 20:32:28
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

# Dumping structure for table krs.t_pano_config
CREATE TABLE IF NOT EXISTS `t_pano_config` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL DEFAULT '0',
  `pano_id` int(10) unsigned NOT NULL DEFAULT '0',
  `config` text,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='全景漫游客户编辑配置信息';

# Dumping data for table krs.t_pano_config: ~0 rows (approximately)
/*!40000 ALTER TABLE `t_pano_config` DISABLE KEYS */;
INSERT INTO `t_pano_config` (`id`, `user_id`, `pano_id`, `config`, `create_time`, `update_time`) VALUES
	(1, 1, 1, 'scene_image1|hotname_1|0|0==scene_image1|hotname_2|-55.40465773047922|-1.9979614076181815==scene_image1|hotname_3|6.949371344932923|31.989674387580042==scene_image1|hotname_4|-69.00949069585437|32.9859539930855==scene_image1|hotname_5|-31.62973623536384|24.632649132377246==scene_image1|hotname_6|58.6402716114418|4.624548629182121==', '2016-05-21 10:33:29', '2016-05-21 17:55:55');
/*!40000 ALTER TABLE `t_pano_config` ENABLE KEYS */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
