DELETE
FROM `waiters`
WHERE `id` NOT IN (SELECT `waiter_id`
                   FROM orders);