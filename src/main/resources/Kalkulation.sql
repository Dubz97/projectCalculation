CREATE DATABASE projektkalkulation /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `projektkalkulation`;
CREATE TABLE `users` (
                         `userId` int NOT NULL AUTO_INCREMENT,
                         `username` varchar(45) DEFAULT NULL,
                         `password` varchar(45) DEFAULT NULL,
                         `mail` varchar(45) DEFAULT NULL,
                         `firstName` varchar(45) DEFAULT NULL,
                         `lastName` varchar(45) DEFAULT NULL,
                         PRIMARY KEY (`userId`),
                         UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `project` (
                           `projectId` int NOT NULL AUTO_INCREMENT,
                           `name` varchar(45) DEFAULT NULL,
                           `caseId` int NOT NULL,
                           `timeFrame` double NOT NULL,
                           `timeUsed` double NOT NULL,
                           `timeLeft` double NOT NULL,
                           PRIMARY KEY (`projectId`),
                           FOREIGN KEY (caseId) REFERENCES users (userId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `employeesTasks` (
                                `employee` varchar(255) default null,
                                `tasks` varchar(255) default null,
                                `startDate` double NOT NULL,
                                `endDate` double NOT NULL,
                                `timeUsed` double NOT NULL,
                                `timeLeft` double NOT NULL,
                                `taskId` int NOT NULL AUTO_INCREMENT,
                                `projectId` int NOT NULL,
                                PRIMARY KEY (`taskId`),
                                FOREIGN KEY (projectId) references project (caseId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
