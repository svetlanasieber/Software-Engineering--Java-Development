DELIMITER $$

CREATE FUNCTION ufn_get_salary_level(emp_salary DECIMAL(19,4))
RETURNS VARCHAR(50)
DETERMINISTIC
BEGIN
    RETURN(CASE
    WHEN emp_salary < 30000 THEN "Low"
    WHEN emp_salary BETWEEN 30000 AND 50000 THEN "Average"
    ELSE "High"
    END);
END $$

DELIMITER ;
;