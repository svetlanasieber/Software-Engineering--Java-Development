DELIMITER $$

CREATE FUNCTION udf_actor_history_movies_count(full_name VARCHAR(50))
    RETURNS INT
    DETERMINISTIC
    READS SQL DATA

BEGIN

    DECLARE `count` INT;

    SET `count` := (SELECT COUNT(gm.`movie_id`)
                    FROM genres_movies AS gm
                             JOIN `movies_actors` AS ma ON gm.`movie_id` = ma.`movie_id`
                             JOIN `actors` AS a ON a.`id` = ma.`actor_id`
                    WHERE CONCAT_WS(' ', a.`first_name`, a.`last_name`) = `full_name`
                      AND gm.`genre_id` = 12);

    RETURN `count`;

END $$
