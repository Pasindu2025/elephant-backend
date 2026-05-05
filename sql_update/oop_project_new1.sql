-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2026 at 02:38 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

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
-- Table structure for table `fence`
--

CREATE TABLE `fence` (
  `id` bigint(20) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `place_name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `fence`
--

INSERT INTO `fence` (`id`, `latitude`, `longitude`, `place_name`, `status`, `created_by`) VALUES
(13, 8.039598, 80.906153, 'Minneriya', 'BROKEN', 'WILDLIFE'),
(14, 6.873427, 81.36054, 'Monaragala', 'ELECTRIC FAILURE', 'WILDLIFE'),
(15, 6.503457, 80.926323, 'Udawalawe', 'DAMAGE', 'WILDLIFE');

-- --------------------------------------------------------

--
-- Table structure for table `fence_reference_locations`
--

CREATE TABLE `fence_reference_locations` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `type` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `fence_reference_locations`
--

INSERT INTO `fence_reference_locations` (`id`, `name`, `latitude`, `longitude`, `type`) VALUES
(1, 'Udawalawe Fence Area', 6.476, 80.891, 'FENCE_AREA'),
(2, 'Minneriya Fence Zone', 8.035, 80.894, 'FENCE_AREA'),
(3, 'Habarana Elephant Corridor', 8.037, 80.754, 'CORRIDOR'),
(4, 'Wasgamuwa Risk Zone', 7.75, 80.933, 'RISK_AREA'),
(5, 'Udawalawe Electric Fence Line', 6.4755, 80.8908, 'FENCE_AREA'),
(6, 'Minneriya Electric Fence', 8.0362, 80.8935, 'FENCE_AREA'),
(7, 'Kaudulla Fence Boundary', 8.141, 80.887, 'FENCE_AREA'),
(8, 'Wasgamuwa Electric Fence', 7.7515, 80.934, 'FENCE_AREA'),
(9, 'Habarana Elephant Corridor', 8.037, 80.754, 'CORRIDOR'),
(10, 'Gal Oya Elephant Corridor', 7.22, 81.35, 'CORRIDOR'),
(11, 'Mahaweli Elephant Crossing', 7.95, 80.98, 'CORRIDOR'),
(12, 'Wilpattu Elephant Pathway', 8.45, 80.1, 'CORRIDOR'),
(13, 'Anuradhapura HEC Zone', 8.3114, 80.4037, 'RISK_AREA'),
(14, 'Polonnaruwa Elephant Conflict Zone', 7.9403, 81.0188, 'RISK_AREA'),
(15, 'Hambantota Conflict Area', 6.1241, 81.1185, 'RISK_AREA'),
(16, 'Monaragala Elephant Risk Zone', 6.8728, 81.3507, 'RISK_AREA'),
(17, 'Udawalawe National Park', 6.474, 80.888, 'PARK'),
(18, 'Minneriya National Park', 8.0365, 80.889, 'PARK'),
(19, 'Yala National Park', 6.3735, 81.516, 'PARK'),
(20, 'Wilpattu National Park', 8.45, 80.05, 'PARK'),
(21, 'Thanamalwila Elephant Area', 6.433, 81.133, 'VILLAGE'),
(22, 'Nochchiyagama Risk Village', 8.2667, 80.2, 'VILLAGE'),
(23, 'Kebithigollewa Risk Area', 8.6333, 80.3333, 'VILLAGE'),
(24, 'Medirigiriya Elephant Area', 8.1333, 80.75, 'VILLAGE');

-- --------------------------------------------------------

--
-- Table structure for table `injured_elephants`
--

CREATE TABLE `injured_elephants` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `reported_at` datetime(6) DEFAULT NULL,
  `reported_by` varchar(255) DEFAULT NULL,
  `severity` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `injured_elephants`
--

INSERT INTO `injured_elephants` (`id`, `description`, `latitude`, `longitude`, `reported_at`, `reported_by`, `severity`) VALUES
(1, 'Unknown Location incident', 7.792636, 80.774231, '2026-05-02 18:28:47.000000', 'Agent_001', 'Critical'),
(2, 'Unknown Location incident', 7.52315, 81.002197, '2026-05-02 18:29:12.000000', 'Agent_001', 'Critical'),
(3, 'Unknown Location incident', 7.520427, 81.004944, '2026-05-02 18:29:31.000000', 'Agent_001', 'Critical'),
(4, 'Unknown Location incident', 7.52315, 81.00769, '2026-05-02 18:29:40.000000', 'Agent_001', 'Critical'),
(5, 'Unknown Location incident', 7.944996, 81.243896, '2026-05-03 22:07:50.000000', 'Agent_001', 'Critical'),
(6, 'Unknown Location incident', 8.233237, 80.397949, '2026-05-03 22:08:28.000000', 'Agent_001', 'Gunshot Wound');

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
-- Indexes for dumped tables
--

--
-- Indexes for table `agent`
--
ALTER TABLE `agent`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `fence`
--
ALTER TABLE `fence`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `fence_reference_locations`
--
ALTER TABLE `fence_reference_locations`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idx_ref_name` (`name`);

--
-- Indexes for table `injured_elephants`
--
ALTER TABLE `injured_elephants`
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
-- AUTO_INCREMENT for table `fence`
--
ALTER TABLE `fence`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `fence_reference_locations`
--
ALTER TABLE `fence_reference_locations`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `injured_elephants`
--
ALTER TABLE `injured_elephants`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
