-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 03, 2024 at 11:07 PM
-- Server version: 5.7.36
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lingogo`
--

-- --------------------------------------------------------

--
-- Table structure for table `fillintheblanks`
--

DROP TABLE IF EXISTS `fillintheblanks`;
CREATE TABLE IF NOT EXISTS `fillintheblanks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `question` text COLLATE utf8mb4_bin NOT NULL,
  `response` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `fillintheblanks`
--

INSERT INTO `fillintheblanks` (`id`, `title`, `question`, `response`) VALUES
(1, 'Fill In The Blanks', 'Conjugate the verbs in parentheses in the correct tense', 'had');

-- --------------------------------------------------------

--
-- Table structure for table `langue`
--

DROP TABLE IF EXISTS `langue`;
CREATE TABLE IF NOT EXISTS `langue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `langue` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `langue`
--

INSERT INTO `langue` (`id`, `langue`) VALUES
(1, 'Arabe'),
(2, 'Anglais');

-- --------------------------------------------------------

--
-- Table structure for table `languechoosen`
--

DROP TABLE IF EXISTS `languechoosen`;
CREATE TABLE IF NOT EXISTS `languechoosen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `langueNative` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  `langueselected` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `languechoosen`
--

INSERT INTO `languechoosen` (`id`, `langueNative`, `langueselected`) VALUES
(1, 'Arabe', 'Anglais'),
(2, 'Arabe', 'Anglais'),
(3, 'Arabe', 'Anglais'),
(4, 'Arabe', 'Anglais'),
(5, 'Arabe', 'Anglais'),
(6, 'Arabe', 'Anglais');

-- --------------------------------------------------------

--
-- Table structure for table `lesson`
--

DROP TABLE IF EXISTS `lesson`;
CREATE TABLE IF NOT EXISTS `lesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `description` text COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `lesson`
--

INSERT INTO `lesson` (`id`, `title`, `description`) VALUES
(1, 'Lesson 1 : Basic Words', ''),
(2, 'Lesson 2 :Basic Phrases', ''),
(3, 'Lesson 3 : Basic present tense conjugation', ''),
(4, 'Lesson 4 : Basic present tense conjugation 2', ''),
(5, 'Lesson 5 : Advanced Verb Conjugation', ''),
(6, 'Lesson 6 : Intermediate Vocabulary Building', '');

-- --------------------------------------------------------

--
-- Table structure for table `lessonsgrammar`
--

DROP TABLE IF EXISTS `lessonsgrammar`;
CREATE TABLE IF NOT EXISTS `lessonsgrammar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  `description` mediumtext COLLATE utf8mb4_bin NOT NULL,
  `verb` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  `example` mediumtext COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `lessonsgrammar`
--

INSERT INTO `lessonsgrammar` (`id`, `nom`, `description`, `verb`, `example`) VALUES
(1, 'Present', 'In this lesson, you’ll learn basic present tense conjugation of travel-related verbs.', 'To Travel', 'I will travel by plane every summer'),
(2, 'Present', 'In this lesson, you’ll learn basic presenttense conjugation of travel-related verbs.', 'To swim', 'We swim in the pool every morning during the holidays'),
(3, 'Past', 'In this lesson, you’ll learn basic past tense conjugation of travel-related verbs', 'To book', 'I booked a flight last summer');

-- --------------------------------------------------------

--
-- Table structure for table `multichoice`
--

DROP TABLE IF EXISTS `multichoice`;
CREATE TABLE IF NOT EXISTS `multichoice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `question` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `choices` text COLLATE utf8mb4_bin NOT NULL,
  `response` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `multichoice`
--

INSERT INTO `multichoice` (`id`, `title`, `question`, `choices`, `response`) VALUES
(1, 'Exercice : Multi choices', 'What is the best answer for this sentence', 'a) packed,b) pack,c) am packing,d) will pack', 'packed'),
(2, 'Exercice : Multi choices', 'What is the best answer for this sentence', 'are going,were going,going,will be go', 'are going');

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
CREATE TABLE IF NOT EXISTS `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` text COLLATE utf8mb4_bin NOT NULL,
  `options` text COLLATE utf8mb4_bin NOT NULL,
  `correctAnswer` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `test`
--

INSERT INTO `test` (`id`, `question`, `options`, `correctAnswer`) VALUES
(1, 'Question 1 : What is the word for a place where airplanes take off and land?', 'Airport,Train,Station\n', 'Airport'),
(2, 'Question 2 : What do you call a document that allows you to enter a foreign country?', 'Ticket,Passport,Visa\n', 'Passport'),
(3, 'Question 3: Which of the following is a type of accommodation?', 'Subway,Backpack,Hostel', 'Hostel'),
(4, 'Question 4 :  Choose the correct sentence:', 'I will going to visit Paris next month.,I am going to visit Paris next month.,I visit Paris next month.', 'I am going to visit Paris next month.');

-- --------------------------------------------------------

--
-- Table structure for table `theme`
--

DROP TABLE IF EXISTS `theme`;
CREATE TABLE IF NOT EXISTS `theme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `theme`
--

INSERT INTO `theme` (`id`, `nom`) VALUES
(1, 'TRAVEL'),
(2, 'TECHNOLOGY'),
(3, 'FOOD'),
(4, 'CULTURE'),
(5, 'WEATHER');

-- --------------------------------------------------------

--
-- Table structure for table `translationexercice`
--

DROP TABLE IF EXISTS `translationexercice`;
CREATE TABLE IF NOT EXISTS `translationexercice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wordToTranslate` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `translatedWord` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `translationexercice`
--

INSERT INTO `translationexercice` (`id`, `wordToTranslate`, `translatedWord`) VALUES
(1, 'Excursion', 'نزهة');

-- --------------------------------------------------------

--
-- Table structure for table `vocabularylesson`
--

DROP TABLE IF EXISTS `vocabularylesson`;
CREATE TABLE IF NOT EXISTS `vocabularylesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `description` mediumtext COLLATE utf8mb4_bin NOT NULL,
  `words` mediumtext COLLATE utf8mb4_bin NOT NULL,
  `example` mediumtext COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `vocabularylesson`
--

INSERT INTO `vocabularylesson` (`id`, `nom`, `description`, `words`, `example`) VALUES
(1, 'Vocabulary Travel I', 'In this lesson, you will learn basic English words and phrases for traveling', 'Airport,Passport\r\n\r\n', 'Before heading to the airport, make sure you have your passport ready for check-in.'),
(2, 'Vocabulary Travel II', 'In this lesson, you will learn basic English words and phrases for traveling', 'Hotel,Ticket,Map', 'After arriving at the airport, we went to the hotel, checked our ticket details, and used the map to explore the city'),
(3, 'Vocabulary Travel III', 'In this lesson, you will learn basic English words and phrases for traveling', 'Ticket,Visa', 'Before boarding the flight, I showed my ticket and visa to the immigration officer.');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
