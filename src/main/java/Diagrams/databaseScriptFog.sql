-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema fog
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `fog` ;

-- -----------------------------------------------------
-- Schema fog
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fog` DEFAULT CHARACTER SET utf8 ;
USE `fog` ;

-- -----------------------------------------------------
-- Table `fog`.`Zipcode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`Zipcode` (
  `zipcode` INT NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`zipcode`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fog`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`Customer` (
  `email` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `phonenumber` INT NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `zipcode` INT NOT NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`email`),
  INDEX `postnummer_idx` (`zipcode` ASC),
  CONSTRAINT `zipcode`
    FOREIGN KEY (`zipcode`)
    REFERENCES `fog`.`Zipcode` (`zipcode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fog`.`Employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`Employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `surname` VARCHAR(30) NOT NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fog`.`Inquiry`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`Inquiry` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `carportHeight` INT NOT NULL,
  `carportLength` INT NOT NULL,
  `carportWidth` INT NOT NULL,
  `shackWidth` INT NULL,
  `shackLength` INT NULL,
  `roofType` ENUM('fladt', 'rejsning') NOT NULL,
  `angle` ENUM('15', '20', '25', '30', '35', '40', '45') NULL,
  `commentCustomer` VARCHAR(2000) NULL,
  `commentEmployee` VARCHAR(2000) NULL,
  `period` DATE NULL,
  `status` ENUM('ny', 'behandles', 'behandlet') NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `id_employee` INT NULL,
  `date` DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `email_idx` (`email` ASC),
  INDEX `id_ansat_idx` (`id_employee` ASC),
  CONSTRAINT `email`
    FOREIGN KEY (`email`)
    REFERENCES `fog`.`Customer` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_employee`
    FOREIGN KEY (`id_employee`)
    REFERENCES `fog`.`Employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fog`.`Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`Product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `category` ENUM('bræt', 'rem', 'spær', 'værktøj', 'stolpe', 'skrue', 'søm', 'lægte') NOT NULL,
  `price` LONG NOT NULL,
  `length` INT NULL,
  `width` INT NULL,
  `height` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- DUMMYDATA 
-- -----------------------------------------------------

INSERT INTO 
Zipcode (zipcode, city)
VALUES
(2750,'Ballerup'),
(2000,'Frederiksberg'),
(2800, 'Kongens Lyngby');

INSERT INTO 
Customer (email, name, surname, phonenumber, address, zipcode, password)
VALUES 
('test1@test.dk','Hans','Hansen',11223344,'Torskevej 1',2750, 'Hansen1'),
('test2@test.dk','Tom','Tomsen',44332211,'Sildevej 2',2000, 'Tomsen1'),
('test3@test.dk','Hanne','Hannesen',11112233,'Makrelvej 3',2800, 'Hannesen'),
('test4@test.dk','Pernille','Pernillesen',44443322,'Spættevej 4',2800, 'Pernillesen');

INSERT INTO
Employee (name, surname)
VALUES
('Martin', 'Fogmaster'),
('Johannes', 'Fog'),
('Frodo', 'Baggings');


INSERT INTO
Inquiry (carportHeight,carportLength,carportWidth,shackWidth,shackLength,roofType,angle,commentCustomer,commentEmployee,period, status, email)
VALUES
(320,420,320,320,120,'fladt',null,null,null,null,'ny','test1@test.dk'),
(320,470,360,360,220,'fladt' ,null,'Kan der vælges andre tag-materialer end det viste?',null,'2017-12-24','ny','test2@test.dk'),
(320,420,320,null,null,'rejsning','15',null,null,null,'behandlet','test3@test.dk'),
(320,570,410,null,null,'fladt',null,null,'Kontakt vedr. valg af trætype','2017-07-14','behandlet','test1@test.dk');

-- --------------------------------------------------------------------------
-- CATEGORIES = 'bræt', 'rem', 'spær', 'værktøj', 'stolpe', 'skrue', 'søm' 
-- --------------------------------------------------------------------------
INSERT INTO
Product (name,category,price,length,width,height)
VALUES
('97x97 TRYKIMPR.','stolpe',2995,1000,97,97),
('45x195 SPÆRTRÆ UBH.','rem',1995,1000,45,195),
('spær','spær',500,200,10,50),
('bræt','bræt',5,100,50,35),
('skrue','skrue',1.5,2,0.5,3),
('søm','søm',0.5,2,0.5,3),
('hammer','værktøj',240,20,5,7),
('38x73 taglægte T1', 'lægte', 50, 1000, 38, 73);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;