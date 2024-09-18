CREATE TABLE `students` (
		`student_id` INT AUTO_INCREMENT PRIMARY KEY,
        `name` VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE `exams` (
		`exam_id` INT AUTO_INCREMENT PRIMARY KEY,
        `name` VARCHAR(50) UNIQUE NOT NULL
) AUTO_INCREMENT = 101;

CREATE TABLE `students_exams` (
		`student_id` INT,
        `exam_id` INT,
        CONSTRAINT pk_students_exams
        PRIMARY KEY (`student_id`, `exam_id`),
        CONSTRAINT fk_studentsexams_exam
        FOREIGN KEY (exam_id)
        REFERENCES exams(`exam_id`),
        CONSTRAINT fk_studentexams_students
        FOREIGN KEY (student_id)
        REFERENCES students(`student_id`)
);

INSERT INTO students (`name`)
VALUES ('Mila'),
		('Toni'),
        ('Ron');
        
INSERT INTO exams (`name`)
VALUES ('Spring MVC'),
		('Neo4j'),
        ('Oracle 11g');
        
INSERT INTO students_exams (`student_id`, `exam_id`)
VALUES  (1, 101),
		(1, 102),
		(2, 101),
		(3, 103),
		(2, 102),
		(2, 103);
