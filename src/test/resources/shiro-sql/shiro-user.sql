CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cnname` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `mobilePhone` varchar(255) DEFAULT NULL,
  `wechatId` varchar(255) DEFAULT NULL,
  `skill` varchar(255) DEFAULT NULL,
  `departmentId` int DEFAULT NULL,
  `loginCount` int DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;