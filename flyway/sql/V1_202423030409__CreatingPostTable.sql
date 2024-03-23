CREATE TABLE `post` (
  `post_id` int NOT NULL,
  `post_name` varchar(45) NOT NULL,
  `post_text` varchar(45) NOT NULL,
  `post_image` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`post_id`)
)