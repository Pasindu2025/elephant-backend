-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 03, 2026 at 01:38 PM
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
-- Database: `oop_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `agent`
--

CREATE TABLE `agent` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `assigned_area` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `employee_id` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `injured_elephants`
--

CREATE TABLE `injured_elephants` (
  `id` bigint(20) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `severity` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `reported_by` varchar(255) DEFAULT NULL,
  `reported_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `injured_elephants`
--

INSERT INTO `injured_elephants` (`id`, `latitude`, `longitude`, `severity`, `description`, `reported_by`, `reported_at`) VALUES
(1, 7.909632, 80.971985, 'Critical', 'Unknown Location incident', 'Agent_001', '2026-05-01 10:02:15'),
(2, 7.955877, 81.112061, 'Critical', 'Unknown Location incident', 'Agent_001', '2026-05-01 10:02:31'),
(3, 7.85794, 81.112061, 'Critical', 'Unknown Location incident', 'Agent_001', '2026-05-01 10:02:34'),
(4, 7.944996, 81.180725, 'Critical', 'Unknown Location incident', 'Agent_001', '2026-05-01 10:03:23'),
(5, 7.738208, 81.199951, 'Critical', 'Unknown Location incident', 'Agent_001', '2026-05-01 10:03:28'),
(6, 7.75998, 80.939026, 'Limping', 'Unknown Location incident', 'Agent_001', '2026-05-01 10:03:33'),
(7, 7.944996, 80.917053, 'Critical', 'Unknown Location incident', 'Agent_001', '2026-05-01 10:13:33'),
(8, 7.463241, 80.568237, 'Critical', 'Unknown Location incident', 'Agent_001', '2026-05-01 10:13:56'),
(9, 7.58305, 81.150513, 'Gunshot Wound', 'Unknown Location incident', 'Agent_001', '2026-05-01 10:14:01'),
(10, 8.132648, 81.103821, 'Critical', 'Unknown Location incident', 'Agent_001', '2026-05-02 06:31:11');

-- --------------------------------------------------------

--
-- Table structure for table `sl_locations`
--

CREATE TABLE `sl_locations` (
  `id` int(11) NOT NULL,
  `village` varchar(100) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `full_name`, `password`, `username`) VALUES
(1, 'pasindu@gmail.com', 'apsindu', '123pas', 'pasindu'),
(2, 'Rasindu@gmail.com', 'Pasindu', '12345', 'Rasiya'),
(3, 'lakshan@gmail.com', 'lakshan', '123456', 'Laka'),
(4, 'Laka@gmail.com', 'Laka', '676767', 'Lakshan'),
(5, 'Nimala@gmail.com', 'Nimala', '222222', 'nimala'),
(6, 'wildlife@gmail.com', 'Wildlife Admin', 'wild123', 'wildlife_admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agent`
--
ALTER TABLE `agent`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `agent`
--
ALTER TABLE `agent`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
