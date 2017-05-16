-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 16, 2017 at 07:02 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jewellery_ecommerce`
--

-- --------------------------------------------------------

--
-- Table structure for table `gold rate`
--

CREATE TABLE `gold rate` (
  `gold_matid` int(11) NOT NULL,
  `gold_mattype` varchar(100) NOT NULL,
  `gold_rate_pergm` decimal(65,0) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='Update Gold Rate';

--
-- Dumping data for table `gold rate`
--

INSERT INTO `gold rate` (`gold_matid`, `gold_mattype`, `gold_rate_pergm`) VALUES
(1001, 'Platinum', '3350'),
(1002, 'Silver', '40'),
(1003, 'Silver Bar', '42'),
(1004, 'Gold 24C 999', '2900'),
(1005, 'Gold 24C 995', '2850'),
(1006, 'Gold 23C', '2805'),
(1007, 'Gold 22C', '2750'),
(1008, 'Gold 18C', '2720');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `email` varchar(250) DEFAULT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(150) NOT NULL,
  `fname` varchar(150) NOT NULL,
  `lname` varchar(100) NOT NULL,
  `verification_code` varchar(50) NOT NULL,
  `mobilenumber` varchar(11) NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `login_attempts` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`email`, `username`, `password`, `fname`, `lname`, `verification_code`, `mobilenumber`, `last_login`, `login_attempts`) VALUES
('admin@gmail.com', 'admin', 'admin', 'ADMIN', 'ADMIN', '74458', '', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `menu_details`
--

CREATE TABLE `menu_details` (
  `id` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `type` varchar(100) NOT NULL,
  `displayname` varchar(100) NOT NULL,
  `submenulist` int(11) NOT NULL,
  `linkurl` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `menu_details`
--

INSERT INTO `menu_details` (`id`, `name`, `type`, `displayname`, `submenulist`, `linkurl`) VALUES
(1, 'collection', 'mainmenu', 'COLLECTION', 1, ''),
(2, 'contact', 'mainmenu', 'CONTACT', 0, ''),
(0, 'home', 'mainmenu', 'HOME', 0, ''),
(3, 'aboutus', 'mainmenu', 'ABOUT US', 0, ''),
(4, 'Sub Menu', 'mainmenu', 'SUB MENU', 1, 'SubMenu.html');

-- --------------------------------------------------------

--
-- Table structure for table `popular collections`
--

CREATE TABLE `popular collections` (
  `id` int(100) NOT NULL,
  `collection_name` varchar(200) NOT NULL,
  `collection_image` varchar(200) NOT NULL,
  `collection_link` varchar(200) NOT NULL,
  `collection_type` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='popular collections';

--
-- Dumping data for table `popular collections`
--

INSERT INTO `popular collections` (`id`, `collection_name`, `collection_image`, `collection_link`, `collection_type`) VALUES
(1, 'BRACELETS', 'assets/images/3_largef441.png', 'products/donec-aliquam-ante-non.html', 'Gold'),
(2, 'EARRINGS', 'assets/images/2_largea971.png', 'products/donec-aliquam-ante-non.html', 'Gold'),
(3, 'NACKLACES', 'assets/images/Necklaces.png', 'products/donec-justo-condimentum.html', 'Gold'),
(4, 'RINGS', 'assets/images/4_large6125.png', 'products/gravida-est-quis-euismod.html', 'Gold');

-- --------------------------------------------------------

--
-- Table structure for table `sub_menu_details`
--

CREATE TABLE `sub_menu_details` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `displayname` varchar(45) DEFAULT NULL,
  `menu_id` int(11) NOT NULL,
  `menu_name` varchar(45) DEFAULT NULL,
  `sub_menu_header_id` int(11) NOT NULL,
  `linkurl` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sub_menu_details`
--

INSERT INTO `sub_menu_details` (`id`, `name`, `displayname`, `menu_id`, `menu_name`, `sub_menu_header_id`, `linkurl`) VALUES
(0, 'bracelets', 'BRACELETS', 1, 'collection', 0, 'products/curabitur-cursus-dignis.html'),
(1, 'earrings', 'EARRINGS', 1, 'collection', 0, 'products/donec-aliquam-ante-non.html'),
(2, 'necklaces', 'NECKLACES', 1, 'collection', 0, 'products/donec-justo-condimentum.html'),
(3, 'rings', 'RINGS', 1, 'collection', 0, 'products/gravida-est-quis-euismod.html'),
(4, 'mangalsutra', 'MANGAL SUTRA', 1, 'collection', 0, 'products/curabitur-cursus-dignis.html'),
(5, 'bracelets', 'BRACELETS', 1, 'collection', 1, 'products/donec-aliquam-ante-non.html'),
(6, 'earrings', 'EARRINGS', 1, 'collection', 1, 'products/donec-justo-condimentum.html'),
(7, 'necklaces', 'NECKLACES', 1, 'collection', 1, 'products/gravida-est-quis-euismod.html'),
(8, 'S Menu', 'S MENU', 4, 'Sub Menu', 3, 'products/SMenu.html'),
(9, 'Test Menu1', 'TEST MENU1', 1, '', 4, 'products/TestMenu1.html');

-- --------------------------------------------------------

--
-- Table structure for table `sub_menu_header`
--

CREATE TABLE `sub_menu_header` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `displayname` varchar(45) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `menu_name` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sub_menu_header`
--

INSERT INTO `sub_menu_header` (`id`, `name`, `displayname`, `menu_id`, `menu_name`) VALUES
(0, 'gold', 'GOLD', 1, 'collection'),
(1, 'silver', 'SILVER', 1, 'collection'),
(2, 'diamond', 'DIAMOND', 1, 'collection'),
(3, 'S Menu Header ', 'S MENU HEADER ', 4, 'Sub Menu'),
(4, 'Test', 'TEST', 1, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `gold rate`
--
ALTER TABLE `gold rate`
  ADD PRIMARY KEY (`gold_matid`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`username`),
  ADD UNIQUE KEY `mobilenumber` (`mobilenumber`);

--
-- Indexes for table `menu_details`
--
ALTER TABLE `menu_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `menu_ref` (`displayname`);

--
-- Indexes for table `popular collections`
--
ALTER TABLE `popular collections`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sub_menu_details`
--
ALTER TABLE `sub_menu_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sub_menu_header`
--
ALTER TABLE `sub_menu_header`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `popular collections`
--
ALTER TABLE `popular collections`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
