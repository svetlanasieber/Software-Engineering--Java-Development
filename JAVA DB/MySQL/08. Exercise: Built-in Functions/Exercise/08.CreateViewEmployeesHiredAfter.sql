CREATE VIEW v_employees_hired_after_2000 as 
SELECT `first_name`, `last_name` FROM `employees`
WHERE  year(hire_date) > 2000;
SELECT * FROM v_employees_hired_after_2000;
