SELECT a.id, a.first_name, a.last_name
FROM athletes a
LEFT JOIN disciplines_athletes_medals dam ON a.id = dam.athlete_id
WHERE dam.athlete_id IS NULL
ORDER BY a.id ASC;
