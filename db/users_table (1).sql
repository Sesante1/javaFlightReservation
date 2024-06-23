-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 23, 2024 at 09:51 AM
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
-- Table structure for table `users_table`
--

CREATE TABLE `users_table` (
  `Id` int(50) NOT NULL,
  `First_Name` varchar(100) NOT NULL,
  `Last_Name` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Username` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Contact` varchar(100) NOT NULL,
  `User_type` varchar(100) NOT NULL,
  `Status` varchar(100) NOT NULL,
  `profile` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users_table`
--

INSERT INTO `users_table` (`Id`, `First_Name`, `Last_Name`, `Email`, `Username`, `Password`, `Contact`, `User_type`, `Status`, `profile`) VALUES
(23, 'Kendra ', 'Purisima', 'doe@email.com', 'admin', '7c222fb2927d828af22f592134e8932480637c0d', '234355', 'Admin', 'Active', 'src/userProfile/Screenshot 2024-06-03 005214.png'),
(24, 'alice', 'testing', 'alice@email.com', 'user', '7c222fb2927d828af22f592134e8932480637c0d', '12345678', 'User', 'Active', 'src/userProfile/Screenshot 2024-06-23 154118.png'),
(25, 'testing', 'testing', 'testing@email.com', 'testing', '7c222fb2927d828af22f592134e8932480637c0d', '12345678', 'Admin', 'Pending', ' '),
(26, 'testing1', 'testing1', 'testing1@email.com', 'testing1', '7c222fb2927d828af22f592134e8932480637c0d', '53445453543', 'Admin', 'Pending', 'src/userProfile/Screenshot 2024-01-31 232013.png'),
(27, 'testing2', 'testing2', 'testing2@email.com', 'testing2', '7c222fb2927d828af22f592134e8932480637c0d', '3454356', 'Admin', 'Pending', ' '),
(28, 'testing3', 'testing3', 'testing3@email.com', 'testing3', '7c222fb2927d828af22f592134e8932480637c0d', '431343452', 'User', 'Pending', ' '),
(29, 'testing4', 'testing4', 'testing4@email.com', 'testing4', '7c222fb2927d828af22f592134e8932480637c0d', '3452453534', 'Admin', 'Pending', ' '),
(30, 'testing5', 'testing5', 'testing5@email.com', 'testing5', '7c222fb2927d828af22f592134e8932480637c0d', '1235455', 'Admin', 'Pending', ' ');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users_table`
--
ALTER TABLE `users_table`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users_table`
--
ALTER TABLE `users_table`
  MODIFY `Id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
