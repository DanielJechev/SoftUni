CREATE DATABASE `movies`;

USE `movies`;

CREATE TABLE `directors` (

    `id` INT (11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `director_name` VARCHAR (50) NOT NULL ,
    `notes` TEXT
);

CREATE TABLE `genres`(

    `id` INT (11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `genre_name` VARCHAR(50) NOT NULL ,
    `notes` TEXT

);

CREATE TABLE `categories`(

    `id` INT (11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `category_name` VARCHAR(50) NOT NULL ,
    `notes` TEXT

);

CREATE TABLE `movies`(

    `id` INT (11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `title` TEXT NOT NULL ,
    `director_id` INT (11) NOT NULL,
    `copyright_year` YEAR(4) NOT NULL ,
    `length` TIME NOT NULL ,
    `genre_id` INT (11) NOT NULL ,
    `category_id` INT (11) NOT NULL ,
    `rating` DOUBLE NOT NULL ,
    `notes` TEXT

);

INSERT INTO `directors` (director_name, notes) VALUES
('First Director',NULL),
('Second Director',NULL),
('Third Director',NULL),
('Fourth Director',NULL),
('Fifth Director',NULL);

INSERT INTO `genres` (genre_name, notes) VALUES
('Comedy',NULL),
('Crime','The best genres!'),
('Drama',NULL),
('Mystery',NULL),
('Philosophical','Philosophical fiction is fiction in which a significant proportion of the work is devoted to a discussion of the sort of questions normally addressed in discursive philosophy. ');

INSERT INTO `categories` (category_name, notes) VALUES
('Comedy',NULL),
('Crime','The best genres!'),
('Drama',NULL),
('Mystery',NULL),
('Horror',NULL);

INSERT INTO `movies` (title, director_id, copyright_year, length, genre_id, category_id, rating, notes) VALUES
('Harold and Kumar Go to White Castle',1,'2004','60:00:00',1,1,8.00,NULL),
('The Irishman',2,'2019','120:00:00',2,2,9.00,NULL),
('Lady Bird',3,'2017','80:00:00',3,3,6.00,NULL),
('asdasdasd',4,'2020','90:00:00',4,4,9.00,NULL),
('Test123',5,'2016','70:00:00',5,5,10,NULL),
('Test456',2,'2016','70:00:00',5,5,9.99,NULL);