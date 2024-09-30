DELIMITER $$
CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(50))
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE counts INT;
    SET counts := (
        SELECT COUNT(*) FROM employees AS e
                      JOIN addresses a on e.address_id = a.address_id
                    JOIN towns t on a.town_id = t.town_id
                    WHERE t.`name` = town_name
        );
        RETURN counts;
end$$

DELIMITER ;
;
DROP FUNCTION ufn_count_employees_by_town;
SELECT ufn_count_employees_by_town('Sofia') AS count;