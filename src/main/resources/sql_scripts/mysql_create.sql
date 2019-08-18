/*MySQL*/
CREATE SCHEMA IF NOT EXISTS internet_shop;

/*Roles table*/
CREATE TABLE IF NOT EXISTS internet_shop.roles
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `name_UNIQUE` (`name` ASC)
);

/*Main roles*/
INSERT INTO internet_shop.roles (name)
VALUES ('ROLE_ADMIN'),
       ('ROLE_CUSTOMER');

/*AddressEntity table*/
CREATE TABLE IF NOT EXISTS internet_shop.address
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `country` VARCHAR(50) NULL,
    `city` VARCHAR(50) NULL,
    `postal_code` VARCHAR(50) NULL,
    `street` VARCHAR(50) NULL,
    `house_number` INT NULL,
    `flat_number` INT NULL,
    PRIMARY KEY (`id`)
);

/*UserEntity table*/
CREATE TABLE IF NOT EXISTS internet_shop.user
(
  `id` INT NOT NULL AUTO_INCREMENT,
  `last_name` VARCHAR(50) NOT NULL,
  `first_name` VARCHAR(50) NOT NULL,
  `birthday` DATE NOT NULL,
  `mail_address` VARCHAR(50) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `role_id` INT NOT NULL,
  `address_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `mail_address_UNIQUE` (`mail_address` ASC),
  INDEX `role_fk_idx` (`role_id` ASC),
  INDEX `fk_user_address_id_idx` (`address_id` ASC),
  CONSTRAINT `fk_user_role_id`
      FOREIGN KEY (`role_id`)
      REFERENCES `internet_shop`.`roles` (`id`)
      ON DELETE RESTRICT
      ON UPDATE CASCADE,
  CONSTRAINT `fk_user_address_id`
      FOREIGN KEY (`address_id`)
      REFERENCES `internet_shop`.`address` (`id`)
      ON DELETE RESTRICT
      ON UPDATE CASCADE
);

/*CategoryEntity table*/
CREATE TABLE IF NOT EXISTS internet_shop.category
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `name_UNIQUE` (`name` ASC)
);

/*Categories*/
INSERT INTO internet_shop.category (name)
VALUES ('winter tires'),
       ('summer tires'),
       ('all-season tires');

/*ParametersEntity table*/
CREATE TABLE IF NOT EXISTS internet_shop.parameters
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `brand` VARCHAR(50) NOT NULL,
    `width` INT NOT NULL DEFAULT 1 CHECK ( width > 0 ),
    `height` INT NOT NULL DEFAULT 1 CHECK ( height > 0 ),
    `radius` INT NOT NULL DEFAULT 1 CHECK ( radius > 0 ),
    PRIMARY KEY (`id`)
);

/*ProductEntity table*/
CREATE TABLE IF NOT EXISTS internet_shop.product (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `price` DECIMAL(8, 2) NOT NULL DEFAULT 1 CHECK ( price > 0 ),
    `category_id` INT NOT NULL,
    `parameter_id` INT NOT NULL,
    `weight` DECIMAL(8, 2) NOT NULL DEFAULT 1 CHECK ( weight > 0 ),
    `volume` DECIMAL(8, 2) NOT NULL DEFAULT 1 CHECK ( volume > 0 ),
    `quantity_in_stock` INT NOT NULL DEFAULT 0 CHECK ( quantity_in_stock >= 0 ),
    PRIMARY KEY (`id`),
    INDEX `fk_product_category_id_idx` (`category_id` ASC),
    INDEX `fk_product_parameters_id_idx` (`parameter_id` ASC),
    CONSTRAINT `fk_product_category_id`
       FOREIGN KEY (`category_id`)
         REFERENCES `internet_shop`.`category` (`id`)
         ON DELETE RESTRICT
         ON UPDATE CASCADE,
    CONSTRAINT `fk_product_parameters_id`
       FOREIGN KEY (`parameter_id`)
         REFERENCES `internet_shop`.`parameters` (`id`)
         ON DELETE SET NULL
         ON UPDATE CASCADE
);

/*PaymentEntity table*/
CREATE TABLE IF NOT EXISTS internet_shop.payment
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `method` VARCHAR(50) NOT NULL,
    `payment_status` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`)
);

/*DeliveryEntity table*/
CREATE TABLE IF NOT EXISTS internet_shop.delivery
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `method` VARCHAR(50) NOT NULL,
    `delivery_status` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`)
);

/*OrderEntity table*/
CREATE TABLE IF NOT EXISTS internet_shop.order
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `payment_id` INT NOT NULL,
    `delivery_id` INT NOT NULL,
    `date` DATE NOT NULL,
    `order_price` DECIMAL(12,2) NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_order_payment_id_idx` (`payment_id` ASC),
    INDEX `fk_order_delivery_id_idx` (`delivery_id` ASC),
    INDEX `fk_order_user_id_idx` (`user_id` ASC),
    CONSTRAINT `fk_order_payment_id`
    FOREIGN KEY (`payment_id`)
    REFERENCES `internet_shop`.`payment` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
    CONSTRAINT `fk_order_delivery_id`
    FOREIGN KEY (`delivery_id`)
    REFERENCES `internet_shop`.`delivery` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
    CONSTRAINT `fk_order_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `internet_shop`.`user` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);

/*The table provides connection between tables Order and Product*/
CREATE TABLE IF NOT EXISTS internet_shop.order_product
(
  `order_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `quantity_of_product` INT NOT NULL,
  PRIMARY KEY (`order_id`, `product_id`),
  INDEX `fk_order_product_id_idx` (`product_id` ASC),
  CONSTRAINT `fk_product_order_id`
    FOREIGN KEY (`order_id`)
      REFERENCES `internet_shop`.`order` (`id`)
      ON DELETE RESTRICT
      ON UPDATE CASCADE,
  CONSTRAINT `fk_order_product_id`
    FOREIGN KEY (`product_id`)
      REFERENCES `internet_shop`.`product` (`id`)
      ON DELETE RESTRICT
      ON UPDATE CASCADE
);
