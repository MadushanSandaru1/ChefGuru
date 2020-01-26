-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 26, 2020 at 05:59 AM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chefguru`
--

DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `adminDetails`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `adminDetails` (IN `username` CHAR(6))  NO SQL
select * from `admin` where `id`=username AND `is_deleted` = 0 LIMIT 1$$

DROP PROCEDURE IF EXISTS `cashierDetails`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `cashierDetails` (IN `username` CHAR(6))  NO SQL
select * from `cashier` where `id`=username AND `is_deleted` = 0 LIMIT 1$$

DROP PROCEDURE IF EXISTS `changePassword`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `changePassword` (IN `username` CHAR(6), IN `password` VARCHAR(255))  NO SQL
UPDATE `user` SET `password`= password WHERE `id` = username$$

DROP PROCEDURE IF EXISTS `createDiscountDetails`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `createDiscountDetails` (IN `dId` INT, IN `dType` VARCHAR(20), IN `dRate` INT(3))  NO SQL
INSERT INTO `discount`(`id`, `type`, `rate`, `is_deleted`) VALUES (dId, dType, dRate, 0)$$

DROP PROCEDURE IF EXISTS `createRoomDetails`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `createRoomDetails` (IN `rId` INT, IN `rType` CHAR(3), IN `rRate` INT, IN `rOccupancy` INT)  NO SQL
INSERT INTO `room`(`id`, `type`, `rate`, `noOfOccupancy`, `status`, `is_deleted`) VALUES (rId, rType, rRate, rOccupancy, 0, 0)$$

DROP PROCEDURE IF EXISTS `createUserDetails`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `createUserDetails` (IN `username` CHAR(6), IN `fName` VARCHAR(20), IN `lName` VARCHAR(20), IN `email` VARCHAR(100), IN `phone` CHAR(10), IN `password` VARCHAR(255))  NO SQL
BEGIN
	INSERT INTO `cashier`(`id`, `firstName`, `lastName`, `email`, `mobile`, `is_deleted`) VALUES (username, fName, lName, email, phone, 0);
    INSERT INTO `user`(`id`, `password`, `role`, `is_deleted`) VALUES (username, password, 'cashier', 0);
END$$

DROP PROCEDURE IF EXISTS `deleteDiscountDetails`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteDiscountDetails` (IN `dId` INT)  NO SQL
UPDATE `discount` SET `is_deleted`= 1 WHERE `id` = dId$$

DROP PROCEDURE IF EXISTS `deleteRoomDetails`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteRoomDetails` (IN `rId` INT)  NO SQL
UPDATE `room` SET `is_deleted`= 1 WHERE `id` = rId$$

DROP PROCEDURE IF EXISTS `deleteUserDetails`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteUserDetails` (IN `username` CHAR(6))  BEGIN
	UPDATE `user` SET `is_deleted` = 1 WHERE `id` = username;
	UPDATE `admin` SET `is_deleted` = 1 WHERE `id` = username;
	UPDATE `cashier` SET `is_deleted` = 1 WHERE `id` = username;
END$$

DROP PROCEDURE IF EXISTS `getRoomTypeId`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getRoomTypeId` (IN `rType` VARCHAR(20))  NO SQL
SELECT * FROM `room_type` WHERE `type` = rType AND `is_deleted` = 0$$

DROP PROCEDURE IF EXISTS `lastDiscountId`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `lastDiscountId` ()  NO SQL
SELECT * FROM `discount` ORDER BY `id` DESC LIMIT 1$$

DROP PROCEDURE IF EXISTS `lastId`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `lastId` ()  NO SQL
SELECT * FROM `cashier` ORDER BY `id` DESC LIMIT 1$$

DROP PROCEDURE IF EXISTS `lastRoomId`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `lastRoomId` ()  NO SQL
SELECT * FROM `room` ORDER BY `id` DESC LIMIT 1$$

DROP PROCEDURE IF EXISTS `login`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `login` (IN `username` CHAR(6))  NO SQL
select * from `user` where `id`=username AND `is_deleted` = 0 LIMIT 1$$

DROP PROCEDURE IF EXISTS `roomTypeDetails`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `roomTypeDetails` ()  NO SQL
SELECT * FROM `room_type` WHERE `is_deleted` = 0$$

DROP PROCEDURE IF EXISTS `updateDiscountDetails`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateDiscountDetails` (IN `dId` INT, IN `dType` VARCHAR(20), IN `dRate` INT(3))  NO SQL
BEGIN
    UPDATE `discount` SET `type`= dType,`rate`= dRate WHERE `id` = dId;
END$$

DROP PROCEDURE IF EXISTS `updateRoomDetails`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateRoomDetails` (IN `rId` INT, IN `rType` CHAR(3), IN `rRate` INT, IN `rOccupancy` INT)  NO SQL
UPDATE `room` SET `type`= rType,`rate`= rRate,`noOfOccupancy`= rOccupancy WHERE `id`= rId$$

DROP PROCEDURE IF EXISTS `updateUserDetails`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUserDetails` (IN `username` CHAR(6), IN `fName` VARCHAR(20), IN `lName` VARCHAR(20), IN `email` VARCHAR(100), IN `phone` CHAR(10))  NO SQL
BEGIN
	UPDATE `cashier` SET `firstName`=fName,`lastName`=lName,`email`=email,`mobile`=phone WHERE `id` = username;
    UPDATE `admin` SET `firstName`=fName,`lastName`=lName,`email`=email,`mobile`=phone WHERE `id` = username;
END$$

DROP PROCEDURE IF EXISTS `viewDiscountDetails`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `viewDiscountDetails` ()  NO SQL
SELECT `id` AS 'ID', `type` AS 'Discount Type', `rate` AS 'Discount Rate (%)' FROM `discount` WHERE `is_deleted` = 0$$

DROP PROCEDURE IF EXISTS `viewRoomDetails`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `viewRoomDetails` ()  NO SQL
SELECT r.`id` AS 'ID', t.`type` AS 'Room Type', r.`rate` AS 'Room Rate', r.`noOfOccupancy` AS 'No of Occupancy', IF(r.`status`=0, 'Available', 'Not Available') AS 'Room Status' FROM `room` r, `room_type` t WHERE r.`type` = t.`id` AND r.`is_deleted` = 0$$

DROP PROCEDURE IF EXISTS `viewSelfDetails`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `viewSelfDetails` (IN `username` CHAR(6))  NO SQL
SELECT `id` AS 'ID', `firstName` AS 'First Name', `lastName` AS 'Last Name', `email` AS 'Email', `mobile` AS 'Phone No' FROM `admin` WHERE `is_deleted` = 0 AND `id` = username
UNION
SELECT `id` AS 'ID', `firstName` AS 'First Name', `lastName` AS 'Last Name', `email` AS 'Email', `mobile` AS 'Phone No' FROM `cashier` WHERE `is_deleted` = 0 AND `id` = username$$

DROP PROCEDURE IF EXISTS `viewUserDetails`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `viewUserDetails` ()  NO SQL
SELECT `id` AS 'ID', `firstName` AS 'First Name', `lastName` AS 'Last Name', `email` AS 'Email', `mobile` AS 'Phone No' FROM `admin` WHERE `is_deleted` = 0
UNION
SELECT `id` AS 'ID', `firstName` AS 'First Name', `lastName` AS 'Last Name', `email` AS 'Email', `mobile` AS 'Phone No' FROM `cashier` WHERE `is_deleted` = 0$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `id` char(6) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mobile` char(10) NOT NULL,
  `is_deleted` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `firstName`, `lastName`, `email`, `mobile`, `is_deleted`) VALUES
('ADM001', 'Team', 'Mart', 'tg2017233@gmail.com', '0771637551', 0),
('ADM002', 'Chef', 'Guru', 'chefguru@gmail.com', '0771637551', 0);

-- --------------------------------------------------------

--
-- Table structure for table `cashier`
--

DROP TABLE IF EXISTS `cashier`;
CREATE TABLE IF NOT EXISTS `cashier` (
  `id` char(6) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mobile` char(10) NOT NULL,
  `is_deleted` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cashier`
--

INSERT INTO `cashier` (`id`, `firstName`, `lastName`, `email`, `mobile`, `is_deleted`) VALUES
('CSR001', 'Madushan', 'Sandaruwan', 'sandaru1wgm@gmail.com', '0718925949', 0);

-- --------------------------------------------------------

--
-- Table structure for table `discount`
--

DROP TABLE IF EXISTS `discount`;
CREATE TABLE IF NOT EXISTS `discount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) NOT NULL,
  `rate` int(3) NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `discount`
--

INSERT INTO `discount` (`id`, `type`, `rate`, `is_deleted`) VALUES
(1, 'holi', 1, 0),
(2, 'New Year - 2020', 3, 0),
(3, 'Christmas', 5, 0);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
CREATE TABLE IF NOT EXISTS `room` (
  `id` int(11) NOT NULL,
  `type` char(3) NOT NULL,
  `rate` int(11) NOT NULL,
  `noOfOccupancy` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 0,
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`id`, `type`, `rate`, `noOfOccupancy`, `status`, `is_deleted`) VALUES
(1, 'T01', 2000, 2, 0, 0),
(2, 'T02', 3500, 3, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `room_type`
--

DROP TABLE IF EXISTS `room_type`;
CREATE TABLE IF NOT EXISTS `room_type` (
  `id` char(3) NOT NULL,
  `type` varchar(20) NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_type`
--

INSERT INTO `room_type` (`id`, `type`, `is_deleted`) VALUES
('T01', 'Single', 0),
('T02', 'Double', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` char(6) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(7) NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `password`, `role`, `is_deleted`) VALUES
('ADM001', '123', 'admin', 0),
('ADM002', '123', 'admin', 0),
('CSR001', '123', 'cashier', 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
