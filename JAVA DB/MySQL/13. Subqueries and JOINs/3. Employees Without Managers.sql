SELECT `employee_id`, `first_name`, `last_name`, `department_id`, `salary` FROM employees AS e
WHERE e.manager_id IS NULL;
