SELECT `department_id`, COUNT(`department_id`) AS `Number of employees`
FROM employees
GROUP BY `department_id`
ORDER BY `department_id`, COUNT(department_id);