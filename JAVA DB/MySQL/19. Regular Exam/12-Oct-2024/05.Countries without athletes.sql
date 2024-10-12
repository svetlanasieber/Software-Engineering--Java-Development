SELECT c.id, c.name
FROM countries c
LEFT JOIN athletes a ON c.id = a.country_id
WHERE a.id IS NULL
ORDER BY c.name DESC
LIMIT 15;
