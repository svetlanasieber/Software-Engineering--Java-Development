SELECT m.`id`,
       m.`title`,
       mai.`runtime`,
       mai.`budget`,
       mai.`release_date`
FROM `movies_additional_info` AS mai
         JOIN `movies` AS m ON mai.`id` = m.`movie_info_id`
WHERE YEAR(`release_date`) BETWEEN 1996 AND 1999
ORDER BY `runtime`, id
LIMIT 20;