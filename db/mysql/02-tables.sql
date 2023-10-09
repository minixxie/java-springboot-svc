use java-springboot-svc;
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `isbn` VARCHAR(255) NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
