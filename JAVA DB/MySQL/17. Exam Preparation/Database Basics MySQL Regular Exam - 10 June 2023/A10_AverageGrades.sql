DELIMITER $$

CREATE FUNCTION udf_average_alumni_grade_by_course_name(`course_name` VARCHAR(60))
    RETURNS DECIMAL(19, 2)
    DETERMINISTIC
    READS SQL DATA

BEGIN

    DECLARE `avg` DECIMAL(19, 2);

    SET `avg` := (SELECT AVG(sc.`grade`)
                  FROM `students_courses` AS sc
                           JOIN `students` AS s ON s.`id` = sc.`student_id`
                           JOIN `courses` AS c ON c.`id` = sc.`course_id`
                  WHERE c.`name` = `course_name`
                    AND s.`is_graduated` = 1);

    RETURN `avg`;

END $$
