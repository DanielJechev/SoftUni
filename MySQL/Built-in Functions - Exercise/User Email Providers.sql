SELECT `user_name`, SUBSTRING_INDEX(email, '@', -1) AS `Email Provider`
FROM users
ORDER BY SUBSTRING_INDEX(`Email Provider`, '@', -1), `user_name`;