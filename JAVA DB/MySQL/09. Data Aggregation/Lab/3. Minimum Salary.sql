SELECT `department_id`, ROUND(MIN(`salary`), 2) AS `Min Salary` FROM `employees`
WHERE `salary`
GROUP BY `department_id`
HAVING MIN(`salary`) > 800;
