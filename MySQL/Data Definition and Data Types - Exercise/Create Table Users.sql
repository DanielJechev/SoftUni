use test_db;

CREATE TABLE Users(
    `id` INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(30) NOT NULL ,
    `password` VARCHAR(26) NOT NULL ,
    `profile_picture` BLOB(900),
    `last_login_time` DATETIME,
    `is_deleted` BIT
);

INSERT INTO Users (id, username, password, profile_picture, last_login_time, is_deleted)VALUES
(1,'test1','123',NULL,'1999-02-12',1),
(2,'test2','123',NULL,'1999-02-12',1),
(3,'test3','123',NULL,'1999-02-12',0),
(4,'test4','123',NULL,'1999-02-12',1),
(5,'test5','123',NULL,'1999-02-12',0);
