CREATE TABLE `item_types` (
		`item_type_id` INT AUTO_INCREMENT PRIMARY KEY,
        `name` VARCHAR(50)
);

CREATE TABLE `items` (
		`item_id` INT AUTO_INCREMENT PRIMARY KEY,
        `name` VARCHAR(50),
        `item_type_id` INT,
        CONSTRAINT fk_items_itemtypes
        FOREIGN KEY (item_type_id)
        REFERENCES `item_types`(`item_type_id`)
);

CREATE TABLE `cities` (
		`city_id` INT AUTO_INCREMENT PRIMARY KEY,
        `name` VARCHAR(50)
);

CREATE TABLE `customers` (
		`customer_id` INT AUTO_INCREMENT PRIMARY KEY,
        `name` VARCHAR(50),
        `birthday` DATE,
        `city_id` INT,
        CONSTRAINT fk_customers_cities
        FOREIGN KEY (city_id)
        REFERENCES `cities`(city_id)
);

CREATE TABLE `orders` (
		`order_id` INT AUTO_INCREMENT PRIMARY KEY,
        `customer_id` INT,
        CONSTRAINT fk_orders_customers
        FOREIGN KEY (customer_id)
        REFERENCES `customers`(customer_id)
);

CREATE TABLE `order_items` (
		`order_id` INT,
        `item_id` INT
);

ALTER TABLE `order_items` 
ADD CONSTRAINT pk_orderitems_orders_items
PRIMARY KEY (`order_id`, `item_id`),
ADD CONSTRAINT fk_orderitems_orders
FOREIGN KEY (order_id)
REFERENCES `orders`(order_id),
ADD CONSTRAINT fk_orderitems_items
FOREIGN KEY (item_id)
REFERENCES `items`(item_id);
