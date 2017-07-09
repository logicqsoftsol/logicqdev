-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 29, 2017 at 05:09 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jewellery`
--

-- --------------------------------------------------------

--
-- Table structure for table `barcode`
--

CREATE TABLE `barcode` (
  `id` bigint(10) NOT NULL,
  `barcodeimage` varchar(45) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `catagory_details`
--

CREATE TABLE `catagory_details` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(200) NOT NULL,
  `DISPLAYNAME` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `catagory_details`
--

INSERT INTO `catagory_details` (`ID`, `NAME`, `DISPLAYNAME`) VALUES
(1, 'Gold', 'GOLD'),
(2, 'Silver', 'SILVER'),
(3, 'diamond', 'DIAMOND');

-- --------------------------------------------------------

--
-- Table structure for table `gold_rate`
--

CREATE TABLE `gold_rate` (
  `gold_matid` int(11) NOT NULL,
  `gold_mattype` varchar(100) NOT NULL,
  `gold_rate_pergm` decimal(65,0) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='Update Gold Rate';

--
-- Dumping data for table `gold_rate`
--

INSERT INTO `gold_rate` (`gold_matid`, `gold_mattype`, `gold_rate_pergm`) VALUES
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
(1, 'gold', 'mainmenu', 'GOLD', 1, ''),
(2, 'silver', 'mainmenu', 'SILVER', 1, ''),
(0, 'home', 'mainmenu', 'HOME', 0, ''),
(3, 'aboutus', 'mainmenu', 'ABOUT US', 0, ''),
(4, 'contact', 'mainmenu', 'CONTACT', 0, '');

-- --------------------------------------------------------

--
-- Table structure for table `popular_collections`
--

CREATE TABLE `popular_collections` (
  `id` int(100) NOT NULL,
  `collection_name` varchar(200) NOT NULL,
  `collection_image` varchar(200) NOT NULL,
  `collection_link` varchar(200) NOT NULL,
  `product_id` int(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='popular collections';

--
-- Dumping data for table `popular_collections`
--

INSERT INTO `popular_collections` (`id`, `collection_name`, `collection_image`, `collection_link`, `product_id`) VALUES
(1, 'BRACELETS', 'assets/images/3_largef441.png', 'collections/collections_with_filter.php', 1),
(2, 'EARRINGS', 'assets/images/2_largea971.png', 'collections/collections_with_filter.php', 1),
(3, 'NACKLACES', 'assets/images/Necklaces.png', 'collections/collections_with_filter.php', 1),
(4, 'RINGS', 'assets/images/4_large6125.png', 'collections/collections_with_filter.php', 1);

-- --------------------------------------------------------

--
-- Table structure for table `price_details`
--

CREATE TABLE `price_details` (
  `ID` bigint(20) NOT NULL,
  `PRODUCT_ID` bigint(20) NOT NULL,
  `SELL_PRICE` decimal(10,2) DEFAULT NULL,
  `VENDOR_PRICE` decimal(10,0) NOT NULL,
  `MRP_PRICE` decimal(10,2) DEFAULT NULL,
  `HM_TAG_PRICE` decimal(10,2) DEFAULT NULL,
  `MAKING_PRICE` decimal(10,2) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `product_details`
--

CREATE TABLE `product_details` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(200) NOT NULL,
  `CATAGORY_ID` bigint(20) NOT NULL,
  `SUB_CATAGORY_ID` bigint(20) NOT NULL,
  `BARCODE` bigint(20) NOT NULL,
  `VENDOR_ID` bigint(20) NOT NULL,
  `COLOR` varchar(200) DEFAULT NULL,
  `SIZE` varchar(200) DEFAULT NULL,
  `PRICE_ID` bigint(20) NOT NULL,
  `QUANTITY_ID` bigint(20) NOT NULL,
  `DOCUMENT_ID` bigint(20) NOT NULL,
  `DESCRIPTION_ID` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `prod_desc_details`
--

CREATE TABLE `prod_desc_details` (
  `ID` bigint(20) NOT NULL,
  `PRODUCT_ID` bigint(20) NOT NULL,
  `DESC_TEXT` varchar(200) DEFAULT NULL,
  `DEGN_STYLE` varchar(200) NOT NULL,
  `AVAL_COLOR` varchar(100) NOT NULL,
  `APPLICABLE_GENDER` varchar(200) NOT NULL,
  `DESIGN_DESC` varchar(200) DEFAULT NULL,
  `TECHNICAL_SPEC` varchar(200) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `prod_document_details`
--

CREATE TABLE `prod_document_details` (
  `ID` bigint(20) NOT NULL,
  `PRODUCT_ID` bigint(20) NOT NULL,
  `IMAGE` varchar(200) NOT NULL,
  `RIGHT_IMAGE` varchar(200) DEFAULT NULL,
  `FRONT_IMAGE` varchar(200) DEFAULT NULL,
  `BACK_IMAGE` varchar(200) DEFAULT NULL,
  `LEFT_IMAGE` varchar(200) DEFAULT NULL,
  `OTHER_IMAGE` varchar(200) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `quantity_details`
--

CREATE TABLE `quantity_details` (
  `ID` bigint(20) NOT NULL,
  `PRODUCT_ID` bigint(20) NOT NULL,
  `PRODUCT_QUANTITY_TYPE` varchar(10) DEFAULT NULL,
  `PRODUCT_UNIT_TYPE` varchar(10) DEFAULT NULL,
  `NET_WT` decimal(10,2) DEFAULT NULL,
  `GROSS_WT` decimal(10,2) DEFAULT NULL,
  `MEENA_WT` decimal(10,2) DEFAULT NULL,
  `WASTAGE` bigint(10) DEFAULT NULL,
  `PURE_WT` decimal(10,2) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `stone_details`
--

CREATE TABLE `stone_details` (
  `ID` bigint(20) NOT NULL,
  `QUANTITY_ID` bigint(20) NOT NULL,
  `STONE_WT` decimal(10,2) DEFAULT NULL,
  `STONE_COLOR` varchar(100) DEFAULT NULL,
  `STONE_PCS` bigint(20) DEFAULT NULL,
  `STONE_PRICE` decimal(10,2) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sub_catagory`
--

CREATE TABLE `sub_catagory` (
  `ID` bigint(20) NOT NULL,
  `CATAGORY_ID` bigint(20) NOT NULL,
  `NAME` varchar(200) NOT NULL,
  `DISPLAY_NAME` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sub_catagory`
--

INSERT INTO `sub_catagory` (`ID`, `CATAGORY_ID`, `NAME`, `DISPLAY_NAME`) VALUES
(1, 1, 'bracelets', 'BRACELETS'),
(2, 1, 'earrings', 'EARRINGS'),
(3, 1, 'necklaces', 'NECKLACES'),
(4, 1, 'rings', 'RINGS'),
(5, 1, 'mangalsutra', 'MANGAL SUTRA'),
(6, 2, 'bracelets', 'BRACELETS'),
(7, 2, 'earrings', 'EARRINGS'),
(8, 2, 'necklaces', 'NECKLACES'),
(9, 2, 'silverring', 'SILVER RINGs'),
(10, 2, 'silverplate', 'SILVER PLATE');

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
(0, 'bracelets', 'BRACELETS', 1, 'gold', 0, 'products/curabitur-cursus-dignis.html'),
(1, 'earrings', 'EARRINGS', 1, 'gold', 0, 'products/donec-aliquam-ante-non.html'),
(2, 'necklaces', 'NECKLACES', 1, 'gold', 0, 'products/donec-justo-condimentum.html'),
(3, 'rings', 'RINGS', 1, 'gold', 0, 'products/gravida-est-quis-euismod.html'),
(4, 'mangalsutra', 'MANGAL SUTRA', 1, 'gold', 0, 'products/curabitur-cursus-dignis.html'),
(5, 'bracelets', 'BRACELETS', 2, 'silver', 1, 'products/donec-aliquam-ante-non.html'),
(6, 'earrings', 'EARRINGS', 2, 'silver', 1, 'products/donec-justo-condimentum.html'),
(7, 'necklaces', 'NECKLACES', 2, 'slver', 1, 'products/gravida-est-quis-euismod.html'),
(8, 'silverring', 'SILVER RINGs', 2, 'silver', 1, 'products/SMenu.html'),
(9, 'silverplate', 'SILVER PLATE', 2, 'silver', 1, 'products/TestMenu1.html');

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
(0, 'gold', 'GOLD', 1, 'gold'),
(1, 'silver', 'SILVER', 2, 'silver');

-- --------------------------------------------------------

--
-- Table structure for table `upload_data`
--

CREATE TABLE `upload_data` (
  `ID` int(5) NOT NULL,
  `FILE_NAME` varchar(200) NOT NULL,
  `FILE_SIZE` varchar(200) NOT NULL,
  `FILE_TYPE` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `upload_data`
--

INSERT INTO `upload_data` (`ID`, `FILE_NAME`, `FILE_SIZE`, `FILE_TYPE`) VALUES
(1, '0ACTO application - ODISHA SSC.pdf', '124737', 'pdf'),
(2, '1ADVT-OAVS.pdf', '902454', 'pdf'),
(3, '2Capture.JPG', '87140', 'jpg'),
(4, 'bulksms.png', '89477', 'png'),
(5, 'invetorylkl.xlsx', '11808', 'xlsx'),
(6, 'Invoice Bill Part 1.pdf', '34266', 'pdf');

-- --------------------------------------------------------

--
-- Table structure for table `vendor_details`
--

CREATE TABLE `vendor_details` (
  `ID` bigint(20) NOT NULL,
  `VENDOR_NAME` varchar(200) NOT NULL,
  `VENDOR_ADDR` varchar(400) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vendor_details`
--

INSERT INTO `vendor_details` (`ID`, `VENDOR_NAME`, `VENDOR_ADDR`) VALUES
(14118, 'SSL Gold Suppliers', 'Balesore'),
(53635, 'SKP Gold & Silver Suppliers', 'Berhampur');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barcode`
--
ALTER TABLE `barcode`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `catagory_details`
--
ALTER TABLE `catagory_details`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `gold_rate`
--
ALTER TABLE `gold_rate`
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
-- Indexes for table `popular_collections`
--
ALTER TABLE `popular_collections`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `price_details`
--
ALTER TABLE `price_details`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `PRODUCT_ID` (`PRODUCT_ID`);

--
-- Indexes for table `product_details`
--
ALTER TABLE `product_details`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `VENDOR_ID` (`VENDOR_ID`);

--
-- Indexes for table `prod_desc_details`
--
ALTER TABLE `prod_desc_details`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `PRODUCT_ID` (`PRODUCT_ID`);

--
-- Indexes for table `prod_document_details`
--
ALTER TABLE `prod_document_details`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `PRODUCT_ID` (`PRODUCT_ID`);

--
-- Indexes for table `quantity_details`
--
ALTER TABLE `quantity_details`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `PRODUCT_ID` (`PRODUCT_ID`);

--
-- Indexes for table `stone_details`
--
ALTER TABLE `stone_details`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `QUANTITY_ID` (`QUANTITY_ID`);

--
-- Indexes for table `sub_catagory`
--
ALTER TABLE `sub_catagory`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `CATAGORY_ID` (`CATAGORY_ID`);

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
-- Indexes for table `upload_data`
--
ALTER TABLE `upload_data`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `vendor_details`
--
ALTER TABLE `vendor_details`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barcode`
--
ALTER TABLE `barcode`
  MODIFY `id` bigint(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `catagory_details`
--
ALTER TABLE `catagory_details`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `popular_collections`
--
ALTER TABLE `popular_collections`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `price_details`
--
ALTER TABLE `price_details`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `prod_desc_details`
--
ALTER TABLE `prod_desc_details`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `prod_document_details`
--
ALTER TABLE `prod_document_details`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `quantity_details`
--
ALTER TABLE `quantity_details`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `stone_details`
--
ALTER TABLE `stone_details`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `sub_catagory`
--
ALTER TABLE `sub_catagory`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `upload_data`
--
ALTER TABLE `upload_data`
  MODIFY `ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
