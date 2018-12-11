-- MySQL Workbench Forward Engineering
-- drop schema DSS;

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DSS` DEFAULT CHARACTER SET utf8 ;
USE `DSS` ;

-- -----------------------------------------------------
-- Table `mydb`.`Actor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DSS`.`Actor` (
  `moradaCasa` VARCHAR(64) NULL,
  `telemovel` INT NULL,
  `email` VARCHAR(32) NOT NULL,
  `nome` VARCHAR(32) NOT NULL,
  `cargo` VARCHAR(32) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Despesa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DSS`.`Despesa` (
  `idDespesa` INT NOT NULL,
  `montante` FLOAT NOT NULL,
  `descricao` VARCHAR(64) NULL,
  `tipo` VARCHAR(32) NULL,
  `pago` FLOAT NOT NULL,
  `Ator` VARCHAR(32) NOT NULL,
  `DataDeEmissao` DATE NOT NULL,
  `DataDeVencimento` DATE NOT NULL,
  PRIMARY KEY (`idDespesa`),
  INDEX `fk_Actor_idx` (`Ator` ASC),
  INDEX `Despesa` (`DataDeEmissao` ASC, `DataDeVencimento` ASC),
  CONSTRAINT `fk_Actor`
    FOREIGN KEY (`Ator`)
    REFERENCES `DSS`.`Actor` (`email`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DSS`.`Pagamento` (
  `Montante` FLOAT NOT NULL,
  `idDespesa` INT NOT NULL,
  `Ator` VARCHAR(32) NOT NULL,
  INDEX `fk_ator_idx` (`Ator` ASC),
  CONSTRAINT `fk_despesa`
    FOREIGN KEY (`idDespesa`)
    REFERENCES `DSS`.`Despesa` (`idDespesa`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_ator`
    FOREIGN KEY (`Ator`)
    REFERENCES `DSS`.`Actor` (`email`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `DSS`.`DadosGerais` (
  `idDespesa` INT NOT NULL DEFAULT 0,
  `registo` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`idDespesa`, `registo`))
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
INSERT INTO ACTOR (moradaCasa, telemovel, email, nome, cargo, password) VALUES ("apartamento", 919191919, "senhorio", "Sr.Senhorio", "Senhorio", "senhorio");