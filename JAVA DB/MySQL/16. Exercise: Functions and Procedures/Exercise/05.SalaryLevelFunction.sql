CREATE FUNCTION ufn_get_salary_level(salary DECIMAL(19, 4))
    RETURNS VARCHAR(50)
    NOT DETERMINISTIC
    READS SQL DATA
    BEGIN
        DECLARE salary_Level VARCHAR(50);
    SET salary_level := (
        CASE
            WHEN `salary` < 30000 THEN 'Low'
            WHEN `salary` BETWEEN 30000 AND 50000 THEN 'Average'
            ELSE 'High'
            END
        );
        RETURN salary_Level;
    END
