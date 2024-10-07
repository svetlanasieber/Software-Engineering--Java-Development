DELETE
FROM countries
WHERE `id` NOT IN (SELECT `country_id`
                   FROM `movies`);