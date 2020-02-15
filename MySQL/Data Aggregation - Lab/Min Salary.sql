SELECT `department_id`, ROUND(MIN(`salary`), 2)
from employees
WHERE salary > 800
GROUP BY `department_id`
LIMIT 1;