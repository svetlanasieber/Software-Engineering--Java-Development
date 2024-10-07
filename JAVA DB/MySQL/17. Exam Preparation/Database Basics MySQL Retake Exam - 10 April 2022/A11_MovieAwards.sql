DELIMITER $$

CREATE PROCEDURE udp_award_movie(`movie_title` VARCHAR(50))

BEGIN

    UPDATE `actors`
        JOIN `movies_actors` AS ma ON actors.`id` = ma.`actor_id`
        JOIN `movies` AS m ON m.`id` = ma.`movie_id`
    SET `awards` = `awards` + 1
    WHERE m.`title` = `movie_title`;

END $$
