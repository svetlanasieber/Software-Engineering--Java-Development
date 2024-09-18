SELECT `country_name`, `river_name`
FROM countries AS c
         LEFT JOIN countries_rivers cr on c.country_code = cr.country_code
         LEFT JOIN rivers r on cr.river_id = r.id
WHERE c.continent_code = 'AF'
ORDER BY c.country_name
LIMIT 5;
