CREATE PROCEDURE usp_get_employees_by_salary_level(`level_of_salary` VARCHAR(10))
BEGIN
    SELECT `first_name`,
           `last_name`
    FROM `employees`
    WHERE (CASE
               WHEN `level_of_salary` = 'low' THEN `salary` < 30000
               WHEN `level_of_salary` = 'average' THEN `salary` BETWEEN 30000 AND 50000
               WHEN `level_of_salary` = 'high' THEN `salary` > 50000
        END)
    ORDER BY `first_name` DESC, last_name DESC;
END
