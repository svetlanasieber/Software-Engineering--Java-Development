SELECT COUNT(sc.`student_id`) AS `students_count`,
       u.`name`               AS `university_name`
FROM `students_courses` AS sc
         JOIN `courses` c ON c.`id` = sc.`course_id`
         JOIN `universities` u ON u.`id` = c.`university_id`
GROUP BY `university_name`
HAVING `students_count` >= 8
ORDER BY `students_count` DESC,
         `university_name` DESC;