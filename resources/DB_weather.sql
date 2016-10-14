CREATE DATABASE `weather` /*!40100 DEFAULT CHARACTER SET utf8 */;
CREATE TABLE `atmosphere` (
  `idatmosphere` int(11) NOT NULL AUTO_INCREMENT,
  `humidity` int(11) DEFAULT NULL,
  `pressure` double DEFAULT NULL,
  `visibility` double DEFAULT NULL,
  `rising` double DEFAULT NULL,
  PRIMARY KEY (`idatmosphere`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `city` (
  `idcity` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcity`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `country` (
  `idcountry` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcountry`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `day` (
  `idday` int(11) NOT NULL AUTO_INCREMENT,
  `day` datetime DEFAULT NULL,
  PRIMARY KEY (`idday`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `extendedforecast` (
  `idextendedforecast` int(11) NOT NULL AUTO_INCREMENT,
  `idday` int(11) DEFAULT NULL,
  PRIMARY KEY (`idextendedforecast`),
  KEY `idday_idx` (`idday`),
  CONSTRAINT `idday` FOREIGN KEY (`idday`) REFERENCES `day` (`idday`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `forecast` (
  `idforecast` int(11) NOT NULL AUTO_INCREMENT,
  `id_wind` int(11) DEFAULT NULL,
  `id_atmos` int(11) DEFAULT NULL,
  `id_location` int(11) DEFAULT NULL,
  `id_extforecast` int(11) DEFAULT NULL,
  `id_day` int(11) DEFAULT NULL,
  `idWind` int(11) DEFAULT NULL,
  `idAtmos` int(11) DEFAULT NULL,
  `idLocation` int(11) DEFAULT NULL,
  `idExtforecast` int(11) DEFAULT NULL,
  `idDay` int(11) DEFAULT NULL,
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
  CONSTRAINT `id_atmos` FOREIGN KEY (`id_atmos`) REFERENCES `atmosphere` (`idatmosphere`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_day` FOREIGN KEY (`id_day`) REFERENCES `day` (`idday`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_extforecast` FOREIGN KEY (`id_extforecast`) REFERENCES `extendedforecast` (`idextendedforecast`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_location` FOREIGN KEY (`id_location`) REFERENCES `location` (`idlocation`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_wind` FOREIGN KEY (`id_wind`) REFERENCES `wind` (`idwind`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `location` (
  `idlocation` int(11) NOT NULL AUTO_INCREMENT,
  `idcountry` int(11) DEFAULT NULL,
  `idregion` int(11) DEFAULT NULL,
  `idcity` int(11) DEFAULT NULL,
  PRIMARY KEY (`idlocation`),
  KEY `idcountry_idx` (`idcountry`),
  KEY `idregion_idx` (`idregion`),
  KEY `idcity_idx` (`idcity`),
  CONSTRAINT `idcity` FOREIGN KEY (`idcity`) REFERENCES `city` (`idcity`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idcountry` FOREIGN KEY (`idcountry`) REFERENCES `country` (`idcountry`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idregion` FOREIGN KEY (`idregion`) REFERENCES `region` (`idregion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `region` (
  `idregion` int(11) NOT NULL AUTO_INCREMENT,
  `region` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idregion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `wind` (
  `idwind` int(11) NOT NULL AUTO_INCREMENT,
  `velocity` int(11) DEFAULT NULL,
  `direction` char(1) DEFAULT NULL,
  PRIMARY KEY (`idwind`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
