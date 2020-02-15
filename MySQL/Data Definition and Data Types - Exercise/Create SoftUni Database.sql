CREATE DATABASE soft_uni;

USE soft_uni;

CREATE TABLE `towns`(
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL
);

CREATE TABLE `addresses`(
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `address_text` VARCHAR(50) NOT NULL ,
    `town_id` INT,
    CONSTRAINT fk_id foreign key (town_id) REFERENCES towns(id)
);

CREATE TABLE `departments`(
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50)
);

CREATE TABLE `employees`(
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(50) NOT NULL ,
    `middle_name` VARCHAR(50) NOT NULL ,
    `last_name` VARCHAR(50) NOT NULL ,
    `job_title` VARCHAR(50) NOT NULL ,

    `department_id` INT, CONSTRAINT fk_dp FOREIGN KEY (department_id) REFERENCES departments(id),
    `hire_date` DATE NOT NULL ,
    `salary` DECIMAL NOT NULL ,
    `address_id` INT, CONSTRAINT fk_address FOREIGN KEY (address_id) REFERENCES addresses(id)

);