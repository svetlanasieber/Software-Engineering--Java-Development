CREATE TABLE `salary_more_than_30000` AS
SELECT * FROM `employees`
WHERE `salary` > 30000;

DELETE FROM `salary_more_than_30000`
WHERE `manager_id` = 42;

UPDATE `salary_more_than_30000`
SET `salary` = `salary` + 5000
WHERE `department_id` = 1;

SELECT `department_id`, AVG(`salary`) FROM `salary_more_than_30000`
GROUP BY `department_id`
ORDER BY `department_id`;
