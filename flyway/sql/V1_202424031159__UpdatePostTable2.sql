ALTER TABLE `anonbook`.`post`
CHANGE COLUMN `post_text` `post_text` VARCHAR(100) NOT NULL ,
CHANGE COLUMN `post_image` `post_image` VARCHAR(128) NULL DEFAULT NULL ;
