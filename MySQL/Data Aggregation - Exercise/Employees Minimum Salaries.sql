SELECT `department_id`, MIN(salary) AS `minimum_salary`
FROM employees
WHERE `hire_date` > '2000-01-01' AND
      `department_id` = 2
   OR `department_id` = 5
   OR `department_id` = 7
GROUP BY `department_id`
ORDER BY `department_id`;