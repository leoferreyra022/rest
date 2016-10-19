CREATE DATABASE `weather` /*!40100 DEFAULT CHARACTER SET utf8 */;
CREATE TABLE `atmosphere` (
  `idatmosphere` INT(11) NOT NULL AUTO_INCREMENT,
  `humidity`     INT(11)          DEFAULT NULL,
  `pressure`     DOUBLE           DEFAULT NULL,
  `visibility`   DOUBLE           DEFAULT NULL,
  `rising`       DOUBLE           DEFAULT NULL,
  PRIMARY KEY (`idatmosphere`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
CREATE TABLE `city` (
  `idcity` INT(11) NOT NULL AUTO_INCREMENT,
  `city`   VARCHAR(45)      DEFAULT NULL,
  PRIMARY KEY (`idcity`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
CREATE TABLE `country` (
  `idcountry` INT(11) NOT NULL AUTO_INCREMENT,
  `country`   VARCHAR(45)      DEFAULT NULL,
  PRIMARY KEY (`idcountry`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
CREATE TABLE `day` (
  `idday` INT(11) NOT NULL AUTO_INCREMENT,
  `day`   DATETIME         DEFAULT NULL,
  PRIMARY KEY (`idday`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
CREATE TABLE `extendedforecast` (
  `idextendedforecast` INT(11) NOT NULL AUTO_INCREMENT,
  `idday`              INT(11)          DEFAULT NULL,
  PRIMARY KEY (`idextendedforecast`),
  KEY `idday_idx` (`idday`),
  CONSTRAINT `idday` FOREIGN KEY (`idday`) REFERENCES `day` (`idday`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
CREATE TABLE `forecast` (
  `idforecast`     INT(11) NOT NULL AUTO_INCREMENT,
  `id_wind`        INT(11)          DEFAULT NULL,
  `id_atmos`       INT(11)          DEFAULT NULL,
  `id_location`    INT(11)          DEFAULT NULL,
  `id_extforecast` INT(11)          DEFAULT NULL,
  `id_day`         INT(11)          DEFAULT NULL,
  `idWind`         INT(11)          DEFAULT NULL,
  `idAtmos`        INT(11)          DEFAULT NULL,
  `idLocation`     INT(11)          DEFAULT NULL,
  `idExtforecast`  INT(11)          DEFAULT NULL,
  `idDay`          INT(11)          DEFAULT NULL,
  PRIMARY KEY (`idforecast`),
  KEY `idWind_idx` (`idWind`),
  KEY `idDay_idx` (`idDay`),
  KEY `idAtmos_idx` (`idAtmos`),
  KEY `idLocation_idx` (`idLocation`),
  KEY `idExtforecast_idx` (`idExtforecast`),
  KEY `id_wind_idx` (`id_wind`),
  KEY `id_atmos_idx` (`id_atmos`),
  KEY `id_location_idx` (`id_location`),
  KEY `id_extforecast_idx` (`id_extforecast`),
  KEY `id_day_idx` (`id_day`),
  CONSTRAINT `id_atmos` FOREIGN KEY (`id_atmos`) REFERENCES `atmosphere` (`idatmosphere`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_day` FOREIGN KEY (`id_day`) REFERENCES `day` (`idday`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_extforecast` FOREIGN KEY (`id_extforecast`) REFERENCES `extendedforecast` (`idextendedforecast`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_location` FOREIGN KEY (`id_location`) REFERENCES `location` (`idlocation`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_wind` FOREIGN KEY (`id_wind`) REFERENCES `wind` (`idwind`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
CREATE TABLE `location` (
  `idlocation` INT(11) NOT NULL AUTO_INCREMENT,
  `idcountry`  INT(11)          DEFAULT NULL,
  `idregion`   INT(11)          DEFAULT NULL,
  `idcity`     INT(11)          DEFAULT NULL,
  PRIMARY KEY (`idlocation`),
  KEY `idcountry_idx` (`idcountry`),
  KEY `idregion_idx` (`idregion`),
  KEY `idcity_idx` (`idcity`),
  CONSTRAINT `idcity` FOREIGN KEY (`idcity`) REFERENCES `city` (`idcity`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idcountry` FOREIGN KEY (`idcountry`) REFERENCES `country` (`idcountry`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idregion` FOREIGN KEY (`idregion`) REFERENCES `region` (`idregion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
CREATE TABLE `region` (
  `idregion` INT(11) NOT NULL AUTO_INCREMENT,
  `region`   VARCHAR(45)      DEFAULT NULL,
  PRIMARY KEY (`idregion`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
CREATE TABLE `wind` (
  `idwind`    INT(11) NOT NULL AUTO_INCREMENT,
  `velocity`  INT(11)          DEFAULT NULL,
  `direction` CHAR(1)          DEFAULT NULL,
  PRIMARY KEY (`idwind`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
