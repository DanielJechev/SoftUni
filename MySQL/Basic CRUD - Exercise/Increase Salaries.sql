UPDATE `employees`
SET `salary` = `salary` * 1.12
WHERE `department_id` = 1
   OR `department_id` = 2
   OR `department_id` = 4
   OR `department_id` = 11;

SELECT `salary` FROM employees;