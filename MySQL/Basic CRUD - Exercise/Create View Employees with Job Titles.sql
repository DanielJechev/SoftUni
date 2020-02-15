CREATE VIEW `v_employees_job_titles` AS
SELECT CONCAT(`first_name`, ' ', if(middle_name is null, '', middle_name), ' ', `last_name`) AS `full_name`,
       `job_title`
FROM `employees`;