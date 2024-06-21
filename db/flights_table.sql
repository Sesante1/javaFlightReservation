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
-- Table structure for table `flights_table`
--

CREATE TABLE `flights_table` (
  `Flight_Id` int(50) NOT NULL,
  `airline_Id` int(50) NOT NULL,
  `Departure` varchar(100) NOT NULL,
  `Departure_Time` varchar(100) NOT NULL,
  `Arrival` varchar(100) NOT NULL,
  `Arrival_Time` varchar(100) NOT NULL,
  `Flying_From` varchar(100) NOT NULL,
  `Flying_To` varchar(100) NOT NULL,
  `Price` varchar(100) DEFAULT NULL,
  `Seats` int(100) NOT NULL,
  `Status` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `flights_table`
--

INSERT INTO `flights_table` (`Flight_Id`, `airline_Id`, `Departure`, `Departure_Time`, `Arrival`, `Arrival_Time`, `Flying_From`, `Flying_To`, `Price`, `Seats`, `Status`) VALUES
(8, 1, '25-05-2024', '1:00', '25-05-2024', '2:00', 'manila', 'bacolod', '1000', 200, 'Arrived'),
(10, 2, '01-06-2024', '4:00 PM', '25-05-2024', '3:00 PM', 'chicago', 'canada', '400', 200, 'Arrived'),
(11, 2, '03-06-2024', '3:00', '03-06-2024', '4:00', 'manila', 'bacolod', '3000', 200, 'Not yet departed'),
(12, 1, '23-06-2024', '12:00 PM', '25-06-2024', '12:00 AM', 'cebu', 'japan', '2000', 100, 'Not yet departed'),
(13, 1, '22-06-2024', '2:00 am', '22-06-2024', '1:00 pm', 'asdf', 'asdf', '12', 200, 'Not yet departed');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `flights_table`
--
ALTER TABLE `flights_table`
  ADD PRIMARY KEY (`Flight_Id`),
  ADD KEY `a_Id` (`airline_Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `flights_table`
--
ALTER TABLE `flights_table`
  MODIFY `Flight_Id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `flights_table`
--
ALTER TABLE `flights_table`
  ADD CONSTRAINT `a_Id` FOREIGN KEY (`airline_Id`) REFERENCES `airlines` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
