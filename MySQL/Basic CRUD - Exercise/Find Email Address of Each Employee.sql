CREATE VIEW `full_email_address` AS
    SELECT CONCAT(`first_name`,'.',`last_name`,'@softuni.bg') FROM employees;