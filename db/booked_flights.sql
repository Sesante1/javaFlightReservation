-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 21, 2024 at 10:47 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `flight_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `booked_flights`
--

CREATE TABLE `booked_flights` (
  `Id` int(11) NOT NULL,
  `Flights_Id` int(11) NOT NULL,
  `Customer_Id` int(11) NOT NULL,
  `Booked_Date` varchar(100) NOT NULL,
  `Gate` varchar(100) NOT NULL,
  `Seat` varchar(100) NOT NULL,
  `Boarding_Time` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `booked_flights`
--

INSERT INTO `booked_flights` (`Id`, `Flights_Id`, `Customer_Id`, `Booked_Date`, `Gate`, `Seat`, `Boarding_Time`) VALUES
(1, 8, 2, '2024-06-22 00:27:31', '2', 'A1', '12:00 PM');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `booked_flights`
--
ALTER TABLE `booked_flights`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `f_id` (`Flights_Id`),
  ADD KEY `c_id` (`Customer_Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `booked_flights`
--
ALTER TABLE `booked_flights`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booked_flights`
--
ALTER TABLE `booked_flights`
  ADD CONSTRAINT `c_id` FOREIGN KEY (`Customer_Id`) REFERENCES `customer_table` (`Id`),
  ADD CONSTRAINT `f_id` FOREIGN KEY (`Flights_Id`) REFERENCES `flights_table` (`Flight_Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
