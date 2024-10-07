DELIMITER $$

CREATE PROCEDURE udp_happy_hour(`product_type` VARCHAR(50))

BEGIN

    UPDATE `products` AS p
    SET p.`price` = p.`price` * 0.8
    WHERE p.`type` = `product_type`
      AND `price` >= 10;

END $$
