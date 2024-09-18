SELECT employee_id, first_name, manager_id, (
    SELECT `first_name` FROM employees AS e
     WHERE e2.manager_id = e.employee_id
     LIMIT 1
    ) AS `manager_name` FROM employees AS e2
WHERE manager_id IN (3, 7)
ORDER BY first_name;
