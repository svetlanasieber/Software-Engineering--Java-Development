SELECT c.`country_code`, COUNT(mc.mountain_id) AS `mountain_range`
FROM countries AS c
         JOIN mountains_countries mc on c.country_code = mc.country_code
GROUP BY c.`country_code`
HAVING c.country_code IN ('BG', 'RU', 'US')
ORDER BY mountain_range DESC;
