SELECT `employee_id`, `first_name`, `salary`, d.`name` FROM employees AS e
JOIN departments d on e.department_id = d.department_id
WHERE `salary` > 15000
ORDER BY d.department_id DESC
LIMIT 5;
