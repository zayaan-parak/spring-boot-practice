CREATE DATABASE IF NOT EXISTS `school_directory`;
USE `school_directory`;

--
-- Structure for table `people` AND `members` AND `roles`
--

DROP TABLE IF EXISTS `students`;
DROP TABLE IF EXISTS `people`;
DROP TABLE IF EXISTS `members`;
DROP TABLE IF EXISTS `roles`;

CREATE TABLE `people` (
	`id` int NOT NULL AUTO_INCREMENT,
	`first_name` VARCHAR(45) DEFAULT NULL,
	`last_name` VARCHAR(45) DEFAULT NULL,
	`email` VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `members` (
	`user_id` VARCHAR(50) NOT NULL,
    `pw` CHAR(68) NOT NULL,
    `active` tinyint NOT NULL,
    PRIMARY KEY (`user_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `roles` (
  `user_id` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  UNIQUE KEY `authorities5_idx_1` (`user_id`,`role`),
  CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Data for table `people` AND `members` AND `roles`
--

INSERT INTO `people` VALUES
	(1, 'Zayaan', 'Parak', 'zayaan@zyp.com'),
    (2, 'Zahra', 'Chothia', 'zahra@zyp.com'),
    (3, 'Ahmed', 'Akoojee', 'ahmed@zyp.com'),
    (4, 'Moe', 'Akoojee', 'moe@zyp.com'),
    (5, 'Tasneem', 'Bharoochi', 'tas@zyp.com');
    
INSERT INTO `members` VALUES
('zayaan', '{bcrypt}$2a$12$hPpP.vCW1D8t6mZNmRZL6OngTj./S9Nz0yWd4KP6dLEx6XnulAZ4S', 1),
('zahra', '{bcrypt}$2a$12$/m1cnZcb6ztOkejHYbyX3uMdKXAeQzisU4XEdSjtcecqEF3fkurFK', 1),
('ahmed', '{bcrypt}$2a$12$vfb9ISonD86sG.PUuEvXm.RJrJrxlOBjCGEXJnGLUD7EryvlT/4ES', 1),
('moe', '{bcrypt}$2a$12$ben579bDH9gZDzofRWXiNesum4ff2Al27oaQ74OTAnyu2c.Ledehm', 1),
('tasneem', '{bcrypt}$2a$12$IknvrTPKv4jj8DUP3oWKneeuH50AMMYgMYkBbM1dCZ.Om9y5Trepa', 1);

INSERT INTO `roles` VALUES
('zayaan', 'ROLE_PERSON'),
('zayaan', 'ROLE_TEACHER'),
('zayaan', 'ROLE_ADMIN'),
('zahra', 'ROLE_PERSON'),
('zahra', 'ROLE_TEACHER'),
('ahmed', 'ROLE_PERSON'),
('moe', 'ROLE_PERSON'),
('tasneem', 'ROLE_PERSON');