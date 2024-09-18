SELECT AVG(`salary`) as min_average_salary
FROM employees
GROUP BY `department_id`
ORDER BY min_average_salary
LIMIT 1;
