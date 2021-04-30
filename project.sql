-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hrsystem
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hrsystem
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hrsystem` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `hrsystem` ;

-- -----------------------------------------------------
-- Table `hrsystem`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hrsystem`.`admin` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hrsystem`.`hotel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hrsystem`.`hotel` (
  `hotelid` INT NOT NULL AUTO_INCREMENT,
  `hotel_name` VARCHAR(45) NULL DEFAULT NULL,
  `hotel_rating` DOUBLE NULL DEFAULT NULL,
  `hotel_availability` TINYINT NULL DEFAULT NULL,
  `expected_price` DOUBLE NULL DEFAULT NULL,
  `image` VARCHAR(5000) NULL DEFAULT NULL,
  `hotel_gallary` VARCHAR(5000) NULL DEFAULT NULL,
  `hotel_Location` VARCHAR(500) NULL DEFAULT NULL,
  `hotel_details` VARCHAR(5000) NULL DEFAULT NULL,
  `check_in` DATE NULL DEFAULT NULL,
  `check_out` DATE NULL DEFAULT NULL,
  `max_allowance` INT NULL DEFAULT NULL,
  `hotel_location_url` VARCHAR(800) NULL DEFAULT NULL,
  PRIMARY KEY (`hotelid`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hrsystem`.`room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hrsystem`.`room` (
  `room_id` INT NOT NULL AUTO_INCREMENT,
  `room_category` VARCHAR(45) NULL DEFAULT NULL,
  `is_available` TINYINT NULL DEFAULT NULL,
  `max_allowance` INT NULL DEFAULT NULL,
  `price_per_night` DOUBLE NULL DEFAULT NULL,
  `image` VARCHAR(1000) NULL DEFAULT NULL,
  `room_description` VARCHAR(5000) NULL DEFAULT NULL,
  `room_details` VARCHAR(5000) NULL DEFAULT NULL,
  `hotel_hotelid` INT NOT NULL,
  PRIMARY KEY (`room_id`),
  INDEX `fk_room_hotel1_idx` (`hotel_hotelid` ASC) VISIBLE,
  CONSTRAINT `fk_room_hotel1`
    FOREIGN KEY (`hotel_hotelid`)
    REFERENCES `hrsystem`.`hotel` (`hotelid`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hrsystem`.`booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hrsystem`.`booking` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `check_in` DATE NULL DEFAULT NULL,
  `check_out` DATE NULL DEFAULT NULL,
  `nights` INT NULL DEFAULT NULL,
  `ppn` DOUBLE NULL DEFAULT NULL,
  `tax` DOUBLE NULL DEFAULT NULL,
  `total` DOUBLE NULL DEFAULT NULL,
  `is_valid` TINYINT NULL DEFAULT NULL,
  `room_room_id` INT NULL DEFAULT NULL,
  `room_number` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `room_room_id_idx` (`room_room_id` ASC) VISIBLE,
  CONSTRAINT `room_room_id1`
    FOREIGN KEY (`room_room_id`)
    REFERENCES `hrsystem`.`room` (`room_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hrsystem`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hrsystem`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL DEFAULT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  `postal_code` VARCHAR(45) NULL DEFAULT NULL,
  `country` VARCHAR(45) NULL DEFAULT NULL,
  `phone` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hrsystem`.`rate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hrsystem`.`rate` (
  `idRate` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL DEFAULT NULL,
  `rate` INT NULL DEFAULT NULL,
  `user_review` VARCHAR(1000) NULL DEFAULT NULL,
  `hotel_name` VARCHAR(100) NULL DEFAULT NULL,
  `user_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idRate`),
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `hrsystem`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hrsystem`.`reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hrsystem`.`reservation` (
  `idreservation` INT NOT NULL AUTO_INCREMENT,
  `user_first_name` VARCHAR(45) NULL DEFAULT NULL,
  `user_last_name` VARCHAR(45) NULL DEFAULT NULL,
  `user_email` VARCHAR(45) NULL DEFAULT NULL,
  `user_address` VARCHAR(45) NULL DEFAULT NULL,
  `user_phone` INT NULL DEFAULT NULL,
  `user_city` VARCHAR(45) NULL DEFAULT NULL,
  `user_country` VARCHAR(45) NULL DEFAULT NULL,
  `postel_code` VARCHAR(45) NULL DEFAULT NULL,
  `hotel_hotelid` INT NULL DEFAULT NULL,
  `room_room_id` INT NULL DEFAULT NULL,
  `res_checkIn` DATE NULL DEFAULT NULL,
  `res_checkout` DATE NULL DEFAULT NULL,
  `res_nights` INT NULL DEFAULT NULL,
  `res_ppn` DOUBLE NULL DEFAULT NULL,
  `res_tax` DOUBLE NULL DEFAULT NULL,
  `res_total` DOUBLE NULL DEFAULT NULL,
  `cancel_res` INT NULL DEFAULT NULL,
  `user_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idreservation`),
  INDEX `hotel_hotelid_idx` (`hotel_hotelid` ASC) VISIBLE,
  INDEX `room_room_id_idx` (`room_room_id` ASC) VISIBLE,
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `hotel_hotelid`
    FOREIGN KEY (`hotel_hotelid`)
    REFERENCES `hrsystem`.`hotel` (`hotelid`),
  CONSTRAINT `room_room_id`
    FOREIGN KEY (`room_room_id`)
    REFERENCES `hrsystem`.`room` (`room_id`),
  CONSTRAINT `userid`
    FOREIGN KEY (`user_id`)
    REFERENCES `hrsystem`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 24
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
