SELECT `title` AS "title" FROM `books`
WHERE SUBSTRING(`title`, 1, 5) = "Harry"
ORDER BY `id`;
