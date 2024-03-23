CREATE TABLE `comment` (
  `comment_id` int NOT NULL,
  `comment_name` varchar(45) NOT NULL,
  `comment_text` varchar(45) NOT NULL,
  `post_id` int NOT NULL,
  PRIMARY KEY (`comment_id`)
)