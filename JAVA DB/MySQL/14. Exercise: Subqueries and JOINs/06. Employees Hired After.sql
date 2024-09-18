SELECT `first_name`, `last_name`, `hire_date`, d.`name` AS dept_name FROM employees AS e
JOIN departments d on e.department_id = d.department_id
WHERE e.hire_date > '1999-01-01' AND d.name IN ('Sales', 'Finance')
ORDER BY e.hire_date;
