ALTER TABLE `anonbook`.`comment`
CHANGE COLUMN `comment_id` `comment_id` INT NOT NULL AUTO_INCREMENT ,
CHANGE COLUMN `comment_name` `comment_name` VARCHAR(100) NOT NULL ,
CHANGE COLUMN `comment_text` `comment_text` VARCHAR(256) NOT NULL ;
