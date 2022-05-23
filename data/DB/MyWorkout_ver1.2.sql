-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema My_Workout
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema My_Workout
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `My_Workout`;
CREATE SCHEMA IF NOT EXISTS `My_Workout` DEFAULT CHARACTER SET utf8 ;
USE `My_Workout` ;

-- -----------------------------------------------------
-- Table `My_Workout`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `My_Workout`.`user` (
  `user_id` VARCHAR(20) NOT NULL,
  `password` VARCHAR(64) NOT NULL,
  `nickname` VARCHAR(8) NOT NULL,
  `height` INT NOT NULL,
  `weight` INT NOT NULL,
  `gender` INT NOT NULL,
  `photo` INT NOT NULL,
  `treasure` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `id_UNIQUE` (`user_id` ASC) VISIBLE,
  UNIQUE INDEX `nickname_UNIQUE` (`nickname` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `My_Workout`.`video`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `My_Workout`.`video` (
  `video_id` INT NOT NULL AUTO_INCREMENT,
  `url` VARCHAR(100) NOT NULL,
  `like_count` INT NOT NULL DEFAULT 0,
  `review_count` INT NOT NULL DEFAULT 0,
  `category` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`video_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `My_Workout`.`video_like`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `My_Workout`.`video_like` (
  `video_like_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(20) NOT NULL,
  `video_id` INT NOT NULL,
  PRIMARY KEY (`video_like_id`),
  INDEX `fk_video_like_user_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_video_like_video1_idx` (`video_id` ASC) VISIBLE,
  CONSTRAINT `fk_video_like_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `My_Workout`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_video_like_video1`
    FOREIGN KEY (`video_id`)
    REFERENCES `My_Workout`.`video` (`video_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `My_Workout`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `My_Workout`.`review` (
  `review_id` INT NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(100) NOT NULL,
  `time` TIMESTAMP NOT NULL DEFAULT now(),
  `changed` INT NOT NULL DEFAULT 0,
  `user_photo` INT NOT NULL,
  `user_id` VARCHAR(8) NOT NULL,
  `user_nickname` VARCHAR(20) NOT NULL,
  `video_id` INT NOT NULL,
  PRIMARY KEY (`review_id`),
  INDEX `fk_review_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_review_video1_idx` (`video_id` ASC) VISIBLE,
  CONSTRAINT `fk_review_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `My_Workout`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_review_video1`
    FOREIGN KEY (`video_id`)
    REFERENCES `My_Workout`.`video` (`video_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `My_Workout`.`friend`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `My_Workout`.`friend` (
  `friend_id` INT NOT NULL AUTO_INCREMENT,
  `target_id` VARCHAR(20) NOT NULL,
  `follower_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`friend_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `My_Workout`.`daily_workout`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `My_Workout`.`daily_workout` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(3) NOT NULL,
  `diary` VARCHAR(1000) NULL,
  `date` TIMESTAMP NOT NULL DEFAULT now(),
  `changed_weight` INT NOT NULL,
  `changed_height` INT NOT NULL,
  `user_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_daily_workout_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_daily_workout_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `My_Workout`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
