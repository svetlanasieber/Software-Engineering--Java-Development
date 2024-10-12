CREATE FUNCTION udf_total_medals_count_by_country(country_name VARCHAR(40))
RETURNS INT
BEGIN
    DECLARE total_medals INT;
    SELECT COUNT(medal_id) INTO total_medals
    FROM disciplines_athletes_medals dam
    JOIN athletes a ON dam.athlete_id = a.id
    JOIN countries c ON a.country_id = c.id
    WHERE c.name = country_name;
    RETURN total_medals;
END;
