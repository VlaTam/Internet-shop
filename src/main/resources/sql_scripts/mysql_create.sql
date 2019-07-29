/*MySQL*/
CREATE SCHEMA IF NOT EXISTS internet_shop;

/*Roles table*/
CREATE TABLE IF NOT EXISTS `internet_shop`.`roles`
(
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC)
);

/*UserEntity table*/
CREATE TABLE IF NOT EXISTS `internet_shop`.`userEntity`
(
  `id` INT NOT NULL AUTO_INCREMENT,
  `last_name` VARCHAR(50) NOT NULL,
  `first_name` VARCHAR(50) NOT NULL,
  `birthday` DATE NOT NULL,
  `mail_address` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `role` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `mail_address_UNIQUE` (`mail_address` ASC),
  INDEX `role_fk_idx` (`role` ASC) VISIBLE,
  CONSTRAINT `fk_user_role_id`
  FOREIGN KEY (`role`)
  REFERENCES `internet_shop`.`roles` (`id`)
  ON DELETE RESTRICT
  ON UPDATE CASCADE
);

/*CategoryEntity table*/
CREATE TABLE IF NOT EXISTS `internet_shop`.`category`
(
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC)
);

/*ParametersEntity table*/
CREATE TABLE IF NOT EXISTS `internet_shop`.`parameters`
(
  `id` INT NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(50) NOT NULL,
  `width` INT NOT NULL DEFAULT 1 CHECK ( width > 0 ),
  `height` INT NOT NULL DEFAULT 1 CHECK ( height > 0 ),
  `radius` INT NOT NULL DEFAULT 1 CHECK ( radius > 0 ),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `brand_UNIQUE` (`brand` ASC)
);

/*ProductEntity table*/
CREATE TABLE IF NOT EXISTS `internet_shop`.`productEntity` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `price` INT NOT NULL DEFAULT 1 CHECK ( price > 0 ),
  `category_id` INT NOT NULL,
  `parameter_id` INT NOT NULL,
  `weight` INT NOT NULL DEFAULT 1 CHECK ( weight > 0 ),
  `volume` INT NOT NULL DEFAULT 1 CHECK ( volume > 0 ),
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
       ON DELETE RESTRICT
       ON UPDATE CASCADE
);
