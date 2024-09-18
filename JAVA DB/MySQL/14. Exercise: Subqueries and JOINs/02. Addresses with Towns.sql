SELECT `first_name`, `last_name`, `name` AS 'town', `address_text` FROM employees
JOIN addresses a on employees.address_id = a.address_id
JOIN towns t on a.town_id = t.town_id
ORDER BY `first_name`,`last_name`
LIMIT 5;
