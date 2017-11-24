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
  `name` VARCHAR(200) NOT NULL,
  `category` ENUM('bræt', 'rem', 'spær', 'værktøj', 'stolpe', 'skrue', 'søm', 'lægte', 'tagpap', 'stern', 'vindskede','beklædning','tagsten','tagplade') NOT NULL,
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
-- CATEGORIES =  'bræt', 'rem', 'spær', 'værktøj', 'stolpe', 'skrue', 'søm', 'lægte', 'tagpap', 'stern', 'vindskede','beklædning','tagsten','tagplade'
-- --------------------------------------------------------------------------
INSERT INTO
Product (name,category,price,length,width,height)
VALUES
-- bræt
('25X200 MM VTA TRYKIMPR. NTR/AB 600 CM','bræt',29970,6000,200,25),
('25X175 MM VTA TRYKIMPR. NTR/AB 600 CM','bræt',26370,6000,175,25),
('25X150 MM VTA TRYKIMPR. NTR/AB 600 CM','bræt',22770,6000,150,25),

-- rem - hardcoded i java
('45x195mm.	spærtræ	ubh.','rem',59000,7200,45,295),


-- spær
('STORT SPÆR','spær',300000,0,0,0),
('MELLEM SPÆR','spær',200000,0,0,0),
('LILLE SPÆR','spær',100000,0,0,0),

-- værktøj
('SKRUEMASKINE','værktøj',99990,0,0,0),
('HÅNDSAV','værktøj',15900,0,0,0),
('VATERPAS','værktøj',51900,0,0,0),

-- stolpe, hardcoded i java
('97x97mm.	trykimp. Stolpe','stolpe',13420,4800,97,97),


-- skrue
('NKT SPUN+ SKRUE UHJ 3X25MM TORX ELFORZINKET','skrue',360,0,0,0),
('NKT FRANSK SKRUE 8X120MM VFZ 50 STK/PK','skrue',2990,0,0,0),
('NKT SPUN+ SKRUE UHJ 3,5X30MM TORX ELFORZINKET','skrue',3600,0,0,0),

-- søm
('NKT FIRKANT SØM 1,2X20MM BLANKE','søm',2700,0,0,0),
('NKT FIRKANT SØM 1,6X25MM BLANKE','søm',2700,0,0,0),
('NKT FIRKANT SØM 1,6X25MM VARMFORZINKET','søm',3600,0,0,0),

-- lægte
('38x73mm.	Lægte	ubh.', 'lægte', 69930, 5400, 38, 73),

-- tagpap
('ICOPAL BASE 411 P 1X8M', 'tagpap', 84900, 8000, 1000, 0),
('ICOPAL TOP 310 G SORT 0,6X7,5M SKURPAP', 'tagpap', 29900, 7500, 600, 0),
('ICOPAL TOP 500P SORT 1X5M', 'tagpap', 59900, 5000, 1000, 0),

-- stern
('25X125 MM STERN OVERBRÆDT TRYKIMP. FYR NTR/AB - 540 CM', 'stern', 12930, 5400, 125, 25),
('25X125 MM STERN MELLEMBRÆDT TRYKIMPR. FYR NTR/AB - 540 CM', 'stern', 12930, 5400, 125, 25),
('25X125 MM STERN UNDERBRÆDT TRYKIMPR. FYR NTR/AB - 540 CM', 'stern', 12930, 5400, 125, 25),

-- vindskede
('22X195 VINDSKEDE M/RU FREMSIDE GRAN US/VTA NTR-GRAN IMPR. - 540 CM','vindskede', 23193, 5400, 195, 22),
('22X195 VINDSKEDE M/RU FREMSIDE GRAN US/VTA NTR-GRAN IMPR. - 480 CM','vindskede', 20616, 4800, 195, 22),
('22X195 VINDSKEDE M/RU FREMSIDE GRAN US/VTA NTR-GRAN IMPR. - 420 CM','vindskede', 18039, 4200, 195, 22),

-- beklædning
('19X100 MM VTA TRYKIMPR. NTR/AB 480 CM','beklædning', 8136, 4800, 100, 19),
('19X100 MM VTA TRYKIMPR. NTR/AB 420 CM','beklædning', 7119, 4200, 100, 19),
('19X100 MM VTA TRYKIMPR. NTR/AB 360 CM','beklædning', 6103, 3600, 100, 19),

-- tagsten
('RØDE VINGETAGSTEN GL. DANSK FORBRUG: 14,6 STK/M2','tagsten', 1495, 404, 236, 0),
('RØDE RYGSTEN MODEL VOLSTRUP DANSKTAG- FORBRUG: 3,5 STK/LBM','tagsten', 8995, 0, 0, 0),  -- ingen mål defineret

-- tagplade
('CEMBRIT OVENLYSPLADE B7 PVC GLASKLAR 1100X610X1MM','tagplade', 24900, 1100, 610, 1),
('FASTLOCK UNI KLAR 6,0M','tagplade', 233970, 60000, 300, 1),  -- ingen width mål defineret
('CEMBRIT B6S FK GRÅ BØLGEPLADE 1090X1180MM - (MODEL 2013)','tagplade', 25900, 1090, 1180, 1);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;