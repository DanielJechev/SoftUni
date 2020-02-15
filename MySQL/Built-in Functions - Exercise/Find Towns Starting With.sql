SELECT `town_id`,`name`
FROM `towns`
WHERE SUBSTRING(`name`,1,1) REGEXP '[MKBE]'
ORDER BY `name`;