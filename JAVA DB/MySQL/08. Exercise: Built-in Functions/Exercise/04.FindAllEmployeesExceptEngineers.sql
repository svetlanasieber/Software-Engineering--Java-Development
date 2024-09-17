SELECT `first_name`, `last_name` from `employees`
WHERE `job_title` NOT LIKE '%engineer%'
ORDER BY `employee_id`;
