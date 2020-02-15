SELECT e.department_id, ROUND(AVG(`salary`),2) AS `Average Salary`
FROM employees AS `e`
GROUP BY `department_id`