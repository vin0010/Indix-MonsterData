-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema indix
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema indix
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `indix` DEFAULT CHARACTER SET latin1 ;
USE `indix` ;

-- -----------------------------------------------------
-- Table `indix`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `indix`.`product` (
  `pid` VARCHAR(50) NOT NULL,
  `title` VARCHAR(450) NULL DEFAULT NULL,
  `upcs` VARCHAR(45) NOT NULL,
  `categoryld` INT(11) NOT NULL,
  `storeId` INT(11) NULL,
  `seller` VARCHAR(50) NULL DEFAULT '',
  `timestamp` DATETIME NULL DEFAULT NULL,
  `price` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`pid`),
  INDEX `index2` (),
  INDEX `index3` (`upcs` ASC, `categoryld` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

