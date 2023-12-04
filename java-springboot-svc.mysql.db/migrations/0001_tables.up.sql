CREATE TABLE `book` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `isbn` VARCHAR(255) NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO book VALUES (null, '978-1400079988', 'War and Peace');
INSERT INTO book VALUES (null, '978-0671722852', 'Romeo and Juliet');
INSERT INTO book VALUES (null, '978-1851525768', 'How to Win Friends and Influence People & How to stop worrying and start living');
