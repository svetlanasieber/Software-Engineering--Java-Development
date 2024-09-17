SELECT * FROM `towns`
WHERE `name` NOT LIKE ('r%') AND `name` NOT LIKE ('b%') AND `name` NOT LIKE ('d%')
ORDER BY `name`;
