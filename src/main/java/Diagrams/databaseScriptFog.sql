-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema fog
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fog
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fog` DEFAULT CHARACTER SET utf8 ;
USE `fog` ;

-- -----------------------------------------------------
-- Table `fog`.`Postnumre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`Postnumre` (
  `postnummer` INT NOT NULL,
  `bynavn` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`postnummer`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fog`.`Kunde`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`Kunde` (
  `email` VARCHAR(45) NOT NULL,
  `navn` VARCHAR(45) NOT NULL,
  `efternavn` VARCHAR(45) NOT NULL,
  `telefonNummer` INT NOT NULL,
  `adresse` VARCHAR(45) NOT NULL,
  `postnummer` INT NOT NULL,
  PRIMARY KEY (`email`),
  INDEX `postnummer_idx` (`postnummer` ASC),
  CONSTRAINT `postnummer`
    FOREIGN KEY (`postnummer`)
    REFERENCES `fog`.`Postnumre` (`postnummer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fog`.`Ansat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`Ansat` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `navn` VARCHAR(30) NOT NULL,
  `efternavn` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fog`.`Forespørgsel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`Forespørgsel` (
  `id` INT NOT NULL,
  `carportHøjde` INT NOT NULL,
  `carportLængde` INT NOT NULL,
  `carportBredde` INT NOT NULL,
  `redskabsRumBredde` INT NULL,
  `redskabsRumLængde` INT NULL,
  `tagType` ENUM('fladt', 'rejsning') NOT NULL,
  `hældning` ENUM('15', '20', '25', '30', '35', '40', '45') NULL,
  `kommentarKunde` VARCHAR(2000) NULL,
  `kommentarAnsat` VARCHAR(2000) NULL,
  `tidsHorisont` DATE NULL,
  `status` ENUM('ny', 'behandles', 'behandlet') NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `id_ansat` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `email_idx` (`email` ASC),
  INDEX `id_ansat_idx` (`id_ansat` ASC),
  CONSTRAINT `email`
    FOREIGN KEY (`email`)
    REFERENCES `fog`.`Kunde` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_ansat`
    FOREIGN KEY (`id_ansat`)
    REFERENCES `fog`.`Ansat` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fog`.`Vare`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`Vare` (
  `varenummer` INT NOT NULL AUTO_INCREMENT,
  `navn` VARCHAR(45) NOT NULL,
  `kategori` ENUM('bræt', 'rem', 'spær', 'værktøj', 'stolpe', 'skrue', 'søm') NOT NULL,
  `pris` INT NOT NULL,
  `længde` INT NULL,
  `bredde` INT NULL,
  `højde` INT NULL,
  PRIMARY KEY (`varenummer`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
