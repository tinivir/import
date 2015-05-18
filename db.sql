-- MySQL Workbench Synchronization
-- Generated: 2015-05-18 17:26
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: tiniv_000

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `mydb1` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

CREATE TABLE IF NOT EXISTS `mydb1`.`tRegimes` (
  `rgCode` INT(11) NOT NULL,
  `rgDesc` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`rgCode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `mydb1`.`tCountries` (
  `crCode` INT(11) NOT NULL,
  `crName` VARCHAR(45) NULL DEFAULT NULL,
  `crFullName` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`crCode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `mydb1`.`tCommodities` (
  `cmdC` VARCHAR(45) NOT NULL,
  `cmdDescE` VARCHAR(2000) NULL DEFAULT NULL,
  `cmdLongDescE` VARCHAR(45) NULL DEFAULT NULL,
  `parent` VARCHAR(45) NULL DEFAULT NULL,
  `IsLeaf` TINYINT(1) NULL DEFAULT NULL,
  `Aggrlevel` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`cmdC`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `mydb1`.`tTradeData` (
  `ptCode` INT(11) NOT NULL,
  `period` DATE NULL DEFAULT NULL,
  `NetWeight` INT(11) NULL DEFAULT NULL,
  `rtCode` INT(11) NOT NULL,
  `rgCode` INT(11) NOT NULL,
  `qtCode` INT(11) NOT NULL,
  `estCode` INT(11) NOT NULL,
  `TradeValue` BIGINT(100) NULL DEFAULT NULL,
  `TradeQuantity` INT(11) NULL DEFAULT NULL,
  `cmdCode` VARCHAR(45) NOT NULL,
  `rowId` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ptCode`, `rtCode`, `rgCode`, `qtCode`, `estCode`, `cmdCode`, `rowId`),
  INDEX `fk_tTradeData_tCountries1_idx` (`rtCode` ASC),
  INDEX `fk_tTradeData_tCountries2_idx` (`ptCode` ASC),
  INDEX `fk_tTradeData_tRegimes1_idx` (`rgCode` ASC),
  INDEX `fk_tTradeData_tQuantityUnits1_idx` (`qtCode` ASC),
  INDEX `fk_tTradeData_tEstimationCodes1_idx` (`estCode` ASC),
  INDEX `fk_tTradeData_tCommodities1_idx` (`cmdCode` ASC),
  CONSTRAINT `fk_tTradeData_tCountries1`
    FOREIGN KEY (`rtCode`)
    REFERENCES `mydb1`.`tCountries` (`crCode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tTradeData_tCountries2`
    FOREIGN KEY (`ptCode`)
    REFERENCES `mydb1`.`tCountries` (`crCode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tTradeData_tRegimes1`
    FOREIGN KEY (`rgCode`)
    REFERENCES `mydb1`.`tRegimes` (`rgCode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tTradeData_tQuantityUnits1`
    FOREIGN KEY (`qtCode`)
    REFERENCES `mydb1`.`tQuantityUnits` (`qtCode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tTradeData_tEstimationCodes1`
    FOREIGN KEY (`estCode`)
    REFERENCES `mydb1`.`tEstimationCodes` (`estCode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tTradeData_tCommodities1`
    FOREIGN KEY (`cmdCode`)
    REFERENCES `mydb1`.`tCommodities` (`cmdC`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `mydb1`.`tQuantityUnits` (
  `qtCode` INT(11) NOT NULL,
  `qtDesc` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`qtCode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `mydb1`.`tEstimationCodes` (
  `estCode` INT(11) NOT NULL,
  `estDesc` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`estCode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
