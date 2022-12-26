# db 생성

create database dbo2;

CREATE TABLE `db02`.`user` (
`userNo` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NULL,
`id` VARCHAR(45) NULL,
`pw` VARCHAR(45) NULL,
PRIMARY KEY (`userNo`),
UNIQUE INDEX (id));
  
CREATE TABLE `db02`.`board` (
`boardNo` INT NOT NULL AUTO_INCREMENT,
`userNo` VARCHAR(45) NOT NULL,
`title` VARCHAR(45) NULL,
`contents` VARCHAR(255) NULL,
`date` DATETIME NULL ,
PRIMARY KEY (`boardNo`));
