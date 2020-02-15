USE `soft_uni`;

UPDATE `employees`
SET `salary` = salary + salary * 0.1;
SELECT `salary` FROM employees;