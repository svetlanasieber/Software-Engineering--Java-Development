SELECT e.`employee_id`, e.`job_title`, e.`address_id`, a.`address_text` FROM employees AS e join addresses a
    on a.address_id = e.address_id
ORDER BY `address_id`
LIMIT 5;
