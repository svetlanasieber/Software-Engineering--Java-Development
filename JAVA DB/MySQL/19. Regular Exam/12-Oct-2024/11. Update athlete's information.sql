CREATE PROCEDURE udp_first_name_to_upper_case(IN letter CHAR(1))
BEGIN
    UPDATE athletes
    SET first_name = UPPER(first_name)
    WHERE first_name LIKE CONCAT('%', letter);
END
