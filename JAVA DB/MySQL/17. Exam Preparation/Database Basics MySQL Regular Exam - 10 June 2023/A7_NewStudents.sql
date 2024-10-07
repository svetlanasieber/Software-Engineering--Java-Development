SELECT CONCAT_WS(' ', `first_name`, `last_name`) AS `full_name`,
       SUBSTRING(`email`, 2, 10)                 AS `username`,
       REVERSE(`phone`)                          AS `password`
FROM students
WHERE `id` NOT IN (SELECT `student_id`
                   FROM students_courses)
ORDER BY password DESC;