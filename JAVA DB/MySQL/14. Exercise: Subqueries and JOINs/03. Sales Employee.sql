SELECT employee_id, first_name, last_name, d.`name` FROM employees AS e
JOIN departments AS d ON e.department_id = d.department_id
WHERE d.name = 'Sales'
ORDER BY `employee_id` DESC;
