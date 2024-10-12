SELECT a.id, a.first_name, a.last_name, COUNT(dam.medal_id) AS medals_count, s.name AS sport
FROM athletes a
JOIN disciplines_athletes_medals dam ON a.id = dam.athlete_id
JOIN disciplines d ON dam.discipline_id = d.id
JOIN sports s ON d.sport_id = s.id
GROUP BY a.id, s.name
ORDER BY medals_count DESC, a.first_name ASC
LIMIT 10;
