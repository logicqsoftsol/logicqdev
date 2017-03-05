-- phpMyAdmin SQL Dump
-- version 2.11.6
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 27, 2009 at 07:17 AM
-- Server version: 5.0.51
-- PHP Version: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;


-- --------------------------------------------------------

--
-- Table structure for table `user_profile`
--

CREATE TABLE login (
  email varchar(250) ,
  username varchar(100) NOT NULL,
  password varchar(150) NOT NULL,
  fname varchar(150) NOT NULL,
  lname varchar(100) NOT NULL,
  verification_code varchar(50) NOT NULL,
   mobilenumber varchar(11) NOT NULL,
  PRIMARY KEY  (username),
  UNIQUE KEY mobilenumber (mobilenumber)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `logicqso_stmaryrnpur`.`login` (`email`, `username`, `password`, `fname`, `lname`, `verification_code`, `mobilenumber`) 
VALUES ('admin@stmaryrnpur.org', 'admin', 'admin', 'ADMIN', 'ADMIN', '74458', '7057014119');



CREATE TABLE news (
  title varchar(150) NOT NULL,
  news_date date NOT NULL,
  details varchar(300) NOT NULL,
  imageurl varchar(250) NOT NULL,
  id varchar(10) NOT NULL,
  PRIMARY KEY  (id),
  UNIQUE KEY title (title)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `logicqso_stmaryrnpur`.`news` (`title`, `news_date`, `details`, `imageurl`, `id`) 
VALUES ('Annual alumni game', '2017-03-02', 'Fusce condimentum pulvinar mattis. Nunc condimentum sapien sit amet odio vulputate, nec suscipit orci pharetra', 'http://stmaryrnpur.org/images/recent-news-thumb-3.jpg', 'ASDFGSF');


CREATE TABLE events (
  eventname varchar(150) NOT NULL,
  event_date date NOT NULL,
  description varchar(300) NOT NULL,
  id varchar(10) NOT NULL,
  PRIMARY KEY  (id),
  UNIQUE KEY description (description)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `logicqso_stmaryrnpur`.`events` (`eventname`, `event_date`, `description`, `id`) 
VALUES ('SRINATH EVENT', '2017-03-08', 'Fusce condimentum pulvinar mattis. Nunc condimentum sapien sit amet odio vulputate, nec suscipit orci pharetra', 'DFGRT');



CREATE TABLE announcements(
  title varchar(150) NOT NULL,
  details varchar(300) NOT NULL,
  fileurl varchar(250),
  id varchar(10) NOT NULL,
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `logicqso_stmaryrnpur`.`announcements` (`title`, `details`, `fileurl`, `id`) VALUES ('Students achievements', 'Class x Students achived assddadasdada', 'http://stmaryrnpur.org/upload/announcements/xyz.pdf', 'DFGSFS');
