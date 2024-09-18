SELECT a.`town_id`, t.`name`, a.`address_text` FROM addresses AS a
JOIN towns AS t
ON t.town_id = a.town_id
WHERE `name` IN ('San Francisco', 'Sofia', 'Carnation')
ORDER BY `town_id`,a.address_id;
