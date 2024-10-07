SELECT `first_name`,
       `last_name`,
       `age`,
       `phone`,
       `email`
FROM `students`
WHERE `age` >= 21
ORDER BY `first_name` DESC,
         `email`,
         `id`
LIMIT 10;