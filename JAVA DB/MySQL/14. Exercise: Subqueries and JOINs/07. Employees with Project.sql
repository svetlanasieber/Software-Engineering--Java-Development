SELECT e.`employee_id`, e.`first_name`, p.`name` AS `project_name` FROM employees AS e
JOIN employees_projects AS ep on ep.employee_id = e.employee_id
JOIN projects AS p on p.project_id = ep.project_id
WHERE DATE(p.start_date) > '2002-08-13'
AND p.end_date IS NULL
ORDER BY e.first_name, p.name
LIMIT 5;
