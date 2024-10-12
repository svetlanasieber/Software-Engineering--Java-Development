UPDATE disciplines
SET name = REPLACE(name, 'weight', '')
WHERE name LIKE '%weight%';
