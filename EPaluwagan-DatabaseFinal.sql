-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 06, 2018 at 05:42 PM
-- Server version: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `epaluwagan`
--

-- --------------------------------------------------------

--
-- Table structure for table `epaluwagangroup`
--

DROP TABLE IF EXISTS `epaluwagangroup`;
CREATE TABLE IF NOT EXISTS `epaluwagangroup` (
  `groupId` int(20) NOT NULL,
  `groupName` varchar(70) NOT NULL,
  `groupDateStart` varchar(70) NOT NULL,
  `groupDateEnd` varchar(70) NOT NULL,
  PRIMARY KEY (`groupId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `epaluwagangroup`
--

INSERT INTO `epaluwagangroup` (`groupId`, `groupName`, `groupDateStart`, `groupDateEnd`) VALUES
(1, 'Blackpink', '05/05/2018', '06/05/2018'),
(2, 'Twice', '05/05/2018', '06/05/2018');

-- --------------------------------------------------------

--
-- Table structure for table `epgadmin`
--

DROP TABLE IF EXISTS `epgadmin`;
CREATE TABLE IF NOT EXISTS `epgadmin` (
  `adminId` int(11) NOT NULL,
  `adminEmail` varchar(70) NOT NULL,
  `adminName` varchar(70) NOT NULL,
  `adminContactNumber` varchar(70) NOT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `epgadmin`
--

INSERT INTO `epgadmin` (`adminId`, `adminEmail`, `adminName`, `adminContactNumber`) VALUES
(5, 'admin1@gmail.com', 'Ace Loo', '09275081430'),
(6, 'admin2@gmail.com', 'Jennie Gamad', '09261329485');

-- --------------------------------------------------------

--
-- Table structure for table `groupmanager`
--

DROP TABLE IF EXISTS `groupmanager`;
CREATE TABLE IF NOT EXISTS `groupmanager` (
  `gmpId` int(20) NOT NULL,
  `grpReport` varchar(90) NOT NULL,
  `groupId` int(20) NOT NULL,
  `studId` int(20) NOT NULL,
  PRIMARY KEY (`gmpId`),
  KEY `groupIdd_idx` (`groupId`),
  KEY `stttudId_idx` (`studId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `groupmanager`
--

INSERT INTO `groupmanager` (`gmpId`, `grpReport`, `groupId`, `studId`) VALUES
(1, 'Fully paid', 1, 2155454),
(2, 'Fully paid', 2, 2161432);

-- --------------------------------------------------------

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
CREATE TABLE IF NOT EXISTS `log` (
  `logId` int(20) NOT NULL,
  `date` varchar(70) NOT NULL,
  `studId` int(20) NOT NULL,
  `groupId` int(20) NOT NULL,
  `gmpId` int(20) NOT NULL,
  PRIMARY KEY (`logId`,`gmpId`,`groupId`,`studId`),
  KEY `studddId_idx` (`studId`),
  KEY `grouppId_idx` (`groupId`),
  KEY `gmpIdd_idx` (`gmpId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `log`
--

INSERT INTO `log` (`logId`, `date`, `studId`, `groupId`, `gmpId`) VALUES
(1, '05/06/2018', 2155454, 1, 1),
(2, '05/06/2018', 2161432, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
CREATE TABLE IF NOT EXISTS `payment` (
  `paymentId` int(20) NOT NULL,
  `payDate` varchar(70) NOT NULL,
  `amount` varchar(70) NOT NULL,
  PRIMARY KEY (`paymentId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`paymentId`, `payDate`, `amount`) VALUES
(1, '05/06/2018', '50'),
(2, '05/06/2018', '50'),
(3, '05/06/2018', '50'),
(4, '05/06/2018', '50'),
(5, '05/06/2018', '50'),
(6, '05/06/2018', '100'),
(7, '05/06/2018', '100'),
(8, '05/06/2018', '100'),
(9, '05/06/2018', '100'),
(10, '05/06/2018', '100');

-- --------------------------------------------------------

--
-- Table structure for table `paymentdetails`
--

DROP TABLE IF EXISTS `paymentdetails`;
CREATE TABLE IF NOT EXISTS `paymentdetails` (
  `status` varchar(70) DEFAULT NULL,
  `studId` varchar(70) NOT NULL,
  `paymentId` int(20) NOT NULL,
  PRIMARY KEY (`paymentId`),
  KEY `studId_idx` (`studId`),
  KEY `paymentId_idx` (`paymentId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paymentdetails`
--

INSERT INTO `paymentdetails` (`status`, `studId`, `paymentId`) VALUES
('paid', '2155454', 1),
('paid', '2155554', 2),
('paid', '2157254', 3),
('paid', '2157681', 4),
('paid', '2160121', 5),
('paid', '2161432', 6),
('paid', '2162532', 7),
('paid', '2192222', 8),
('paid', '2196969', 9),
('paid', '2198168', 10);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `StudId` int(20) NOT NULL,
  `StudName` varchar(70) NOT NULL,
  `StudAddress` varchar(70) NOT NULL,
  `StudContactNumber` varchar(70) NOT NULL,
  `StudEmail` varchar(70) NOT NULL,
  `StudBirthday` varchar(70) NOT NULL,
  `GCashAccount` varchar(70) NOT NULL,
  PRIMARY KEY (`StudId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`StudId`, `StudName`, `StudAddress`, `StudContactNumber`, `StudEmail`, `StudBirthday`, `GCashAccount`) VALUES
(2155454, 'Angel Lopez', 'Bakakeng Baguio City', '09169692609', '2156342@slu.edu.ph', '04/5/1998', '09169692609'),
(2155554, 'Vincent Tolentino', 'Aurora Hill Baguio City', '09277465845', '2156382@slu.edu.ph', '03/25/1996', '09277465845'),
(2157254, 'Kelly Sibug', 'Aurora Hill Baguio City', '09347837185', '2157254@slu.edu.ph', '09/25/2000', '09347837185'),
(2157681, 'Donald Trump', 'Bakakeng Baguio City', '09248738190', '2157681@slu.edu.ph', '08/24/1998', '09248738190'),
(2160121, 'Junjun salasar', 'Leonila Hill Baguio City', '09128372899', '2160121@slu.edu.ph', '04/2/1997', '09128372899'),
(2161432, 'Ron Nore', 'Leonila Hill Baguio City', '09191729812', '2161432@slu.edu.ph', '01/26/1996', '09191729812'),
(2162532, 'Jargon Taas', 'Leonila Hill Baguio City', '09872378121', '2162532@slu.edu.ph', '07/5/2000', '09872378121'),
(2192222, 'Adam Sobre', 'Aurora Hill Baguio City', '09971263817', '2192222@slu.edu.ph', '03/25/2000', '09971263817'),
(2196969, 'Vince Florentino', 'Leonila Hill Baguio City', '09128746181', '2196969@slu.edu.ph', '05/5/1996', '09128746181'),
(2198168, 'Marrione Bulanadi', 'Aurora Hill Baguio City', '09427861811', '2198168@slu.edu.ph', '06/21/2000', '09427861811');

-- --------------------------------------------------------

--
-- Table structure for table `studgrp`
--

DROP TABLE IF EXISTS `studgrp`;
CREATE TABLE IF NOT EXISTS `studgrp` (
  `allocatedContrib` varchar(70) NOT NULL,
  `studId` varchar(70) NOT NULL,
  `groupId` varchar(70) NOT NULL,
  PRIMARY KEY (`groupId`,`studId`),
  KEY `stuudId_idx` (`studId`),
  KEY `grouupId_idx` (`groupId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studgrp`
--

INSERT INTO `studgrp` (`allocatedContrib`, `studId`, `groupId`) VALUES
('50', '2155454', '1'),
('50', '2155554', '1'),
('50', '2157254', '1'),
('50', '2157681', '1'),
('50', '2160121', '1'),
('100', '2161432', '2'),
('100', '2162532', '2'),
('100', '2192222', '2'),
('100', '2196969', '2'),
('100', '2198168', '2');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `groupmanager`
--
ALTER TABLE `groupmanager`
  ADD CONSTRAINT `groupIdd` FOREIGN KEY (`groupId`) REFERENCES `epaluwagangroup` (`groupId`) ON UPDATE CASCADE,
  ADD CONSTRAINT `stttudId` FOREIGN KEY (`studId`) REFERENCES `student` (`StudId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `log`
--
ALTER TABLE `log`
  ADD CONSTRAINT `gmpIdd` FOREIGN KEY (`gmpId`) REFERENCES `groupmanager` (`gmpId`),
  ADD CONSTRAINT `grouppId` FOREIGN KEY (`groupId`) REFERENCES `epaluwagangroup` (`groupId`),
  ADD CONSTRAINT `studddId` FOREIGN KEY (`studId`) REFERENCES `student` (`StudId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
