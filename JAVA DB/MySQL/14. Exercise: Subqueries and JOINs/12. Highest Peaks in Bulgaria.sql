SELECT c.country_code, m.mountain_range, p.peak_name, p.elevation
FROM countries AS c
         JOIN mountains_countries mc on c.country_code = mc.country_code
         JOIN mountains m on mc.mountain_id = m.id
         JOIN peaks p on m.id = p.mountain_id
WHERE c.country_code = 'BG'
  AND p.elevation > 2835
ORDER BY p.elevation DESC;
