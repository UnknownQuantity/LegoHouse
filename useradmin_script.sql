CREATE DATABASE  IF NOT EXISTS `useradmin`;


USE `useradmin`;

set foreign_key_checks = 0;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `preOrders`;
DROP TABLE IF EXISTS `brickinfo`;

CREATE TABLE `users` (
`id` int AUTO_INCREMENT primary key,
`email` varchar(90) NOT NULL,
`password` varchar(45) NOT NULL,
`role` varchar(20) NOT NULL DEFAULT 'customer',
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

create table `preOrders` (
`id` int auto_increment primary key,
userID int not null,
`length` int not null, -- length of the house
`width` int not null, -- width of the house
`height` int not null, -- height of the house
`orderConfirmed` boolean default false, 
FOREIGN KEY (userID) REFERENCES users(`id`),
`dates` datetime default current_timestamp
);

-- the lenght is the amount of the dots on the brick
create table `brickinfo` (
`id` int AUTO_INCREMENT primary key,
`type` varchar(45) not null,
`length` int not null,
`width` int not null,
`height` int not null
);


LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES (1,'jacob@live.dk','test','employee');
UNLOCK TABLES;
insert into `brickinfo` (`type`, `length`, `width`, `height`) values ('small', 1, 2, 1), ('medium', 2, 2, 1), ('big', 4, 2, 1);

set foreign_key_checks = 1;