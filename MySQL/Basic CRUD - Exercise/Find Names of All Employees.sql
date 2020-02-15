CREATE VIEW `Full Name` AS
SELECT CONCAT(`first_name`, ' ', middle_name, ' ', last_name)
FROM employees
WHERE `salary` = 25000.00
   OR `salary` = 14000.00
   OR `salary` = 12500.00
   OR `salary` = 23600.00;

SELECT * FROM `Full Name`;