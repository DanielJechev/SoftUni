SELECT `department_id`, MAX(salary) AS `max_salary`
FROM employees
GROUP BY `department_id`
HAVING MAX(salary) < 30000
    OR MAX(salary) > 70000;