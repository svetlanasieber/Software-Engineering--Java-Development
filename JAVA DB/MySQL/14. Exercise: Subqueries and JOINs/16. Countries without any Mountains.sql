SELECT COUNT(c.country_code) AS `country_count` FROM countries AS c
LEFT JOIN mountains_countries mc on c.country_code = mc.country_code
WHERE mc.mountain_id IS NULL
GROUP BY mc.mountain_id;
