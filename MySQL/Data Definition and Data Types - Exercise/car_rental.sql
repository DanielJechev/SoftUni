CREATE DATABASE car_rental;

USE car_rental;


CREATE TABLE categories
(
    id INT(11) AUTO_INCREMENT primary key,
    category VARCHAR(50) NOT NULL,
    daily_rate INT(3),
    weekly_rate INT(3),
    monthly_rate INT(3),
    weekend_rate INT(3)
);
CREATE TABLE cars
(
    id INT AUTO_INCREMENT primary key,
    plate_number VARCHAR(50) NOT NULL,
    make VARCHAR(50),
        model VARCHAR(50),
    car_year INT(4),
    category_id INT(11),
    doors INT(2),
    picture BLOB,
    car_condition VARCHAR(50),
    available BOOLEAN
);
CREATE TABLE employees
(
    id INT AUTO_INCREMENT primary key,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    title VARCHAR(50),
    notes TEXT
);
CREATE TABLE customers
(
    id INT AUTO_INCREMENT primary key,
    driver_licence_number INT(11) NOT NULL,
    full_name VARCHAR(50),
    address VARCHAR(50),
    city VARCHAR(50),
    zip_code INT(5),
    notes TEXT
);
 
CREATE TABLE rental_orders
(
    id INT AUTO_INCREMENT primary key,
    employee_id INT(11) NOT NULL,
    customer_id INT(11),
    car_id INT(11) NOT NULL,
    car_condition VARCHAR(50),
    tank_level INT(11),
    kilometrage_start INT(11),
    kilometrage_end INT(11),
    total_kilometrage INT(11),
    start_date date,
    end_date date,
    total_days INT(11),
    rate_applied INT(3),
    tax_rate INT(11),
    order_status VARCHAR(50),
    notes TEXT
);
INSERT INTO cars(plate_number)
VALUES ('123'),('1234'),('12345');

INSERT INTO categories(category)
VALUES ('Classic'),('Hatchback'),('Sport');

INSERT INTO customers(driver_licence_number)
VALUES ('2232'),('232323'),('111');

INSERT INTO employees(first_name,last_name)
VALUES ('Ivan', 'Ivanov'),('Ivan1', 'Ivanov1'), ('Ivan2', 'Ivanov2');

INSERT INTO rental_orders(employee_id,car_id)
VALUES (1, 1),(1, 2), (2, 3);