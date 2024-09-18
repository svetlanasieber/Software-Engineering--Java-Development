SELECT `category_id`, 
ROUND(AVG(`price`), 2) AS `Average Price`,
MIN(ROUND(`price`, 2)) AS `Cheapest Product`,
MAX(ROUND(`price`, 2)) AS `Most Expensive Product`
FROM `products`
GROUP BY `category_id`;
