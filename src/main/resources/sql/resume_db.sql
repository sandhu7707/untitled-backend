CREATE DATABASE IF NOT EXISTS RESUME;
USE RESUME;

CREATE TABLE `EDUCATION` (
  `id` int NOT NULL AUTO_INCREMENT,
  `college` varchar(100) DEFAULT NULL,
  `degree` varchar(100) DEFAULT NULL,
  `date_from` date DEFAULT NULL,
  `date_to` date DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `EDUCATION_PROJECT` (
  `project_id` int DEFAULT NULL,
  `education_id` int DEFAULT NULL,
  KEY `education_id` (`education_id`),
  KEY `project_id` (`project_id`),
  CONSTRAINT `EDUCATION_PROJECT_ibfk_1` FOREIGN KEY (`education_id`) REFERENCES `EDUCATION` (`id`),
  CONSTRAINT `EDUCATION_PROJECT_ibfk_2` FOREIGN KEY (`project_id`) REFERENCES `PROJECT` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `EXPERIENCE` (
  `id` int NOT NULL AUTO_INCREMENT,
  `company` varchar(100) DEFAULT NULL,
  `job_title` varchar(40) DEFAULT NULL,
  `date_from` date DEFAULT NULL,
  `date_to` date DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1014 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `EXPERIENCE_PROJECT` (
  `project_id` int DEFAULT NULL,
  `experience_id` int DEFAULT NULL,
  KEY `experience_id` (`experience_id`),
  KEY `project_id` (`project_id`),
  CONSTRAINT `EXPERIENCE_PROJECT_ibfk_1` FOREIGN KEY (`experience_id`) REFERENCES `EXPERIENCE` (`id`),
  CONSTRAINT `EXPERIENCE_PROJECT_ibfk_2` FOREIGN KEY (`project_id`) REFERENCES `PROJECT` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `PROJECT` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `date_from` date DEFAULT NULL,
  `date_to` date DEFAULT NULL,
  `description` text,
  `project_type` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `PROJECT_chk_1` CHECK (((`project_type` = (_utf8mb4'E' | `project_type`)) = _utf8mb4'W'))
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `SKILL` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  `rating` int DEFAULT NULL,
  `years_of_experience` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `SKILL_chk_1` CHECK (((4 < `rating`) < 10))
) ENGINE=InnoDB AUTO_INCREMENT=1021 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `SKILL_EXPERIENCE` (
  `skill_id` int DEFAULT NULL,
  `experience_id` int DEFAULT NULL,
  KEY `skill_id` (`skill_id`),
  KEY `experience_id` (`experience_id`),
  CONSTRAINT `SKILL_EXPERIENCE_ibfk_1` FOREIGN KEY (`skill_id`) REFERENCES `SKILL` (`id`),
  CONSTRAINT `SKILL_EXPERIENCE_ibfk_2` FOREIGN KEY (`experience_id`) REFERENCES `EXPERIENCE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE USER IF NOT EXISTS 'legends' IDENTIFIED BY 'resume';
GRANT ALL ON RESUME.* TO 'legends';
