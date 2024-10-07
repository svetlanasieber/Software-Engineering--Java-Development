INSERT INTO courses (`name`, `duration_hours`, `start_date`, `teacher_name`, `description`, `university_id`)
SELECT CONCAT(`teacher_name`, ' course')                       AS `name`,
       (CHAR_LENGTH(`name`)) / 10                              AS `duration_hours`,
       DATE_ADD(`start_date`, INTERVAL 5 DAY)                  AS start_date,
       REVERSE(`teacher_name`)                                 AS teacher_name,
       CONCAT('Course ', `teacher_name`, REVERSE(description)) AS description,
       DAY(`start_date`)                                       AS university_id
FROM courses
WHERE `id` <= 5;