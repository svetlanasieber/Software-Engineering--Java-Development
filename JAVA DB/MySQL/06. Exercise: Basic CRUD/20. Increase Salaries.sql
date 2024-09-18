UPDATE `employees` as e
SET e.`salary` = 1.12 * e.`salary`
WHERE `department_id` IN(1,2,4,11);

SELECT salary FROM employees;
