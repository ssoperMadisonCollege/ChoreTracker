DROP TABLE IF EXISTS `chores`;
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

DROP TABLE IF EXISTS `houses`;
CREATE TABLE `houses` (
  `houseId` int(11) NOT NULL AUTO_INCREMENT,
  `house_name` varchar(30) NOT NULL,
  PRIMARY KEY (`houseId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

LOCK TABLES `houses` WRITE;
INSERT INTO `houses` VALUES (1,'Soper House'),(2,'Pelton House'),(3,'Animal House'),(4,'House of Cards');
UNLOCK TABLES;

DROP TABLE IF EXISTS `user_roles`;

CREATE TABLE `user_roles` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) NOT NULL,
  `role_name` varchar(30) NOT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

LOCK TABLES `user_roles` WRITE;
INSERT INTO `user_roles` VALUES (1,'admin','administrator');
UNLOCK TABLES;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `user_password` varchar(30) NOT NULL,
  `user_email` varchar(30) NOT NULL,
  `user_phone` varchar(30) NOT NULL,
  `user_name` varchar(30) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES (1,'Joe','Coyne','password','email@email.com','123-456-7890','JCoyne'),(2,'Fred','Hensen','password','email@hotmail.com','111-111-1111','FHensen'),(3,'Barney','Curry','password','email@gmail.com','222-222-2222','BCurry'),(4,'Karen','Mack','password','fake@yahoo.com','333-333-3333','KMack'),(5,'Dianne','Klein','password','this@mailapp.com','444-444-4444','DKlein'),(6,'Dawn','Tillman','password','sample@email.com','555-555-5555','DTillman'),(8,'admin','admin','password','admin@admin.admin','0987-654-321','admin');
UNLOCK TABLES;