-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 08, 2015 at 10:41 AM

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `alchemytectest`
--
CREATE DATABASE `alchemytectest` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `alchemytectest`;

-- --------------------------------------------------------

--
-- Table structure for table `Expense`
--

CREATE TABLE IF NOT EXISTS `Expense` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `amount` float NOT NULL,
  `vat` float NOT NULL,
  `reason` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=32 ;

--
-- Dumping data for table `Expense`
--

INSERT INTO `Expense` (`id`, `date`, `amount`, `vat`, `reason`) VALUES
(1, '2015-03-01', 12, 0, 'dan test'),
(2, '2015-04-20', 33, 0, 'book java stuff'),
(3, '2015-04-07', 14, 0, 'das a'),
(4, '2015-04-07', 43, 0, 'ajd as'),
(5, '2015-04-14', 14, 0, 'now'),
(6, '2015-04-14', 1, 0, 'noww'),
(7, '2015-04-01', 1, 0, '111'),
(8, '2015-04-21', 1333, 0, 'now all good!'),
(9, '2015-04-01', 11, 0, 'nowww'),
(10, '2015-04-21', 12, 0, 'nw'),
(11, '2015-04-05', 5, 0, '5'),
(12, '2015-04-22', 6, 0, '5'),
(13, '2015-04-27', 33, 0, '11'),
(14, '2015-04-06', 6, 0, 'vat'),
(15, '2015-04-08', 88, 0, 'de'),
(16, '2015-04-06', 88, 14.6667, 'de'),
(17, '2015-04-10', 10, 1.66667, 's'),
(18, '2015-04-08', 10, 1.66667, 'sss'),
(19, '2015-04-12', 20, 3.33333, 'book'),
(20, '2015-04-12', 20, 3.33333, 'book'),
(21, '2015-04-12', 200, 33.3333, 'book'),
(22, '2015-04-07', 10, 1.66667, 'mo'),
(23, '2015-04-07', 10, 1.66667, 'mo'),
(24, '2015-04-08', 122, 20.3333, 'nowc'),
(25, '2015-04-01', 12, 2, 'f'),
(26, '2015-04-13', 13, 2.16667, 'w'),
(27, '2015-04-23', 123, 20.5, 'sd'),
(28, '2015-04-18', 1111, 185.167, 'w'),
(29, '2015-04-22', 1, 0.166667, 'f'),
(30, '2015-04-18', 1111, 185.167, 'w'),
(31, '2015-04-08', 122, 20.3333, 'nowc');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
