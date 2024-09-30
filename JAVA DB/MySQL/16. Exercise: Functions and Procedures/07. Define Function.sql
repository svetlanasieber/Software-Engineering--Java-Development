CREATE FUNCTION ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))

    RETURNS INT
    NOT DETERMINISTIC
    READS SQL DATA

BEGIN

    DECLARE `result` INT;

    SET `result` :=
            (SELECT `word` REGEXP (CONCAT('^[', set_of_letters, ']+$')));

    RETURN `result`;
END 
