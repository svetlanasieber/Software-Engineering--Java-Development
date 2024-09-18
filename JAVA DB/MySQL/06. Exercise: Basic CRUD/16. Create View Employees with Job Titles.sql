CREATE VIEW `v_employees_job_titles` AS
SELECT CONCAT(
 `first_name`,' ',
 IF(`middle_name` is not null, concat(`middle_name`,' '), ''), `last_name`) AS `full_name`, `job_title` FROM `employees`;
 
 SELECT * from `v_employees_job_titles`;
