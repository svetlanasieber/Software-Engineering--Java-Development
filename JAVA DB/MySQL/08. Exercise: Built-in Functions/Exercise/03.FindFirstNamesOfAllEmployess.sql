SELECT `first_name` from `employees`
WHERE `department_id` IN (3,10)
AND 
year(`hire_date`) BETWEEN 1995 and 2005
ORDER BY `employee_id`;
