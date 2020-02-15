use test_db;
CREATE TABLE `people`(
    `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL ,
    `name` VARCHAR (200) NOT NULL ,
    `picture` TINYBLOB,
    `height` DOUBLE(3,2),
    `weight` DOUBLE(5,2),
    `gender` ENUM('m','f') NOT NULL ,
    `birthdate` DATE NOT NULL ,
    `biography` TEXT

);

INSERT people (id, name, picture, height, weight, gender, birthdate, biography) VALUES
(1,'test',NULL,1.80,60,'m','1990-08-12','test'),
(2,'test1',NULL,1.80,60,'m','1990-08-12','test'),
(3,'test2',NULL,1.80,60,'m','1990-08-12','test'),
(4,'test3',NULL,1.80,60,'m','1990-08-12','test'),
(5,'test4',NULL,1.80,60,'m','1990-08-12','test');