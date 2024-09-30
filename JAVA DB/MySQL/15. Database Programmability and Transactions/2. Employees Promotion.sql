CREATE PROCEDURE  usp_raise_salaries(department_name VARCHAR(50))
BEGIN
    UPDATE employees AS e
    JOIN departments d on e.department_id = d.department_id
    SET `salary` = `salary` * 1.05
    WHERE d.name = department_name;

END
