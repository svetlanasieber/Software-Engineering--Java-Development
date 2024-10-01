CREATE PROCEDURE usp_raise_salary_by_id(id INT)
BEGIN

    DECLARE count_employees INT;
    SET count_employees := (
            SELECT COUNT(*) FROM employees
        );

    UPDATE employees AS e
    SET e.`salary` = IF(id > 0 AND id <= count_employees, e.salary * 1.05, e.salary);
end
