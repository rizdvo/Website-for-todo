CREATE DATABASE IF NOT EXISTS `todo` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `todo`;
DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client = @character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task`
(
    `id`          int(11)      NOT NULL AUTO_INCREMENT,
    `description` varchar(100) NOT NULL,
    `status`      tinyint      NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 16
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task`
    DISABLE KEYS */;
INSERT IGNORE INTO `task`
VALUES (1, 'Виконати завдання - A;', 1),
       (2, 'Виконати завдання - B;', 2),
       (3, 'Виконати завдання - C;', 0),
       (4, 'Виконати завдання - D;', 1),
       (5, 'Виконати завдання - E;', 2),
       (6, 'Виконати завдання - F;', 0),
       (7, 'Виконати завдання - G;', 1),
       (8, 'Виконати завдання - H;', 2),
       (9, 'Виконати завдання - J;', 0),
       (10, 'Виконати завдання - K;', 1),
       (11, 'Виконати завдання - L;', 2),
       (12, 'Виконати завдання - M;', 0),
       (13, 'Виконати завдання - N;', 1),
       (14, 'Виконати завдання - O;', 2),
       (15, 'Виконати завдання - P;', 0);
/*!40000 ALTER TABLE `task`
    ENABLE KEYS */;
UNLOCK TABLES;