SET FOREIGN_KEY_CHECKS  = 0;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `user_roles`;
DROP TABLE IF EXISTS `chores`;
DROP TABLE IF EXISTS `houses`;
SET FOREIGN_KEY_CHECKS  = 0;

CREATE TABLE `users` (
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `user_password` varchar(30) DEFAULT NULL,
  `user_email` varchar(30) DEFAULT NULL,
  `user_phone` varchar(30) DEFAULT NULL,
  `user_name` varchar(30) NOT NULL,
  PRIMARY KEY (`user_name`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES ('Joe','Coyne','password','email@email.com','123-456-7890','JCoyne'),('Fred','Hensen','password','email@hotmail.com','111-111-1111','FHensen'),('Barney','Curry','password','email@gmail.com','222-222-2222','BCurry'),('Karen','Mack','password','fake@yahoo.com','333-333-3333','KMack'),('Dianne','Klein','password','this@mailapp.com','444-444-4444','DKlein'),('Dawn','Tillman','password','sample@email.com','555-555-5555','DTillman'),('admin','admin','password','admin@admin.admin','0987-654-321','admin');
UNLOCK TABLES;

CREATE TABLE `user_roles` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) DEFAULT NULL,
  `role_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `user_name` (`user_name`),
  CONSTRAINT `fkRoleUser` FOREIGN KEY (`user_name`) REFERENCES `users` (`user_name`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

LOCK TABLES `user_roles` WRITE;
INSERT INTO `user_roles` VALUES (1,'admin','administrator');
INSERT INTO `user_roles` VALUES (2,'DTillman','registered-user');
INSERT INTO `user_roles` VALUES (3,'KMack','registered-user');
INSERT INTO `user_roles` VALUES (4,'JCoyne','registered-user');
INSERT INTO `user_roles` VALUES (5,'FHensen','registered-user');
INSERT INTO `user_roles` VALUES (6,'BCurry','registered-user');
UNLOCK TABLES;

CREATE TABLE `chores` (
  `choreId` int(11) NOT NULL AUTO_INCREMENT,
  `chore_name` varchar(30) NOT NULL,
  `chore_start_date` date DEFAULT NULL,
  `chore_time_interval` varchar(30) DEFAULT NULL,
  `assigned_to_user` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`choreId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

LOCK TABLES `chores` WRITE;
INSERT INTO `chores` VALUES (1,'mow the lawn','2017-10-17','',''),(2,'add salt to water softener','2017-10-18','',''),(3,'go grocery shopping','2017-10-19','',''),(4,'pick up the CSA','2017-10-20','',''),(5,'fix leaky garage door','2017-10-21','','');
UNLOCK TABLES;

CREATE TABLE `houses` (
  `houseId` int(11) NOT NULL AUTO_INCREMENT,
  `house_name` varchar(30) DEFAULT NULL,
  `user_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`houseId`),
  UNIQUE KEY `user_name` (`user_name`),
  CONSTRAINT `fkHouseUser` FOREIGN KEY (`user_name`) REFERENCES `users` (`user_name`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

LOCK TABLES `houses` WRITE;
INSERT INTO `houses` VALUES (1,'Soper House', 'DTillman'),(2,'Pelton House', 'KMack'),(3,'Animal House', 'JCoyne'),(4,'House of Cards', 'BCurry'),(5,'House of the Rising Sun','FHensen'),(6,'Road House','DKlein'),(7,'Admin House','admin');
UNLOCK TABLES;