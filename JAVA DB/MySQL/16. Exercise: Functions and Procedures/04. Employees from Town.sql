CREATE PROCEDURE  usp_get_employees_from_town(town_name VARCHAR(50))
BEGIN
    SELECT `first_name`, `last_name` FROM employees AS e
    JOIN addresses a on e.address_id = a.address_id
    JOIN towns t on a.town_id = t.town_id
    WHERE t.name = town_name
    ORDER BY e.first_name, e.last_name, e.employee_id;
end
