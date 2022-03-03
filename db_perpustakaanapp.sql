-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 03, 2022 at 04:28 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_perpustakaanapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `admin_nama` varchar(20) NOT NULL,
  `admin_password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `admin_nama`, `admin_password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `anggota`
--

CREATE TABLE `anggota` (
  `anggota_id` int(11) NOT NULL,
  `anggota_nama` varchar(20) NOT NULL,
  `anggota_password` varchar(15) NOT NULL,
  `anggota_notelp` varchar(12) NOT NULL,
  `anggota_alamat` varchar(100) NOT NULL,
  `anggota_aktif` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `anggota`
--

INSERT INTO `anggota` (`anggota_id`, `anggota_nama`, `anggota_password`, `anggota_notelp`, `anggota_alamat`, `anggota_aktif`) VALUES
(1, 'rudi', '1234', '081', 'perak', 0),
(2, 'rafli', '123', '099', 'benowo', 0),
(3, 'budi', '232323', '023', 'papua', 0),
(4, 'yanto', '1234', '077', 'bali', 0),
(5, 'hafizh', '1234', '999', 'medan', 1),
(6, 'yanto', '234', '071', 'tanjung', 0),
(7, 'yanto', '999', '077', 'asemrowo', 1);

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `buku_isbn` varchar(13) NOT NULL,
  `buku_judul` varchar(255) NOT NULL,
  `buku_penerbit` varchar(50) NOT NULL,
  `buku_terbit` int(11) NOT NULL,
  `buku_halaman` int(11) NOT NULL,
  `buku_ketersediaan` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`buku_isbn`, `buku_judul`, `buku_penerbit`, `buku_terbit`, `buku_halaman`, `buku_ketersediaan`) VALUES
('01', 'kancil', 'hafizh', 123, 2001, 0),
('02', 'kelelawar', 'paijo', 98, 2001, 0),
('03', 'kalajengkin', 'jaya', 23, 2001, 0),
('04', 'lumba', 'gani', 234, 2001, 1);

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `peminjaman_id` varchar(100) NOT NULL,
  `buku_isbn` varchar(13) NOT NULL,
  `anggota_id` int(11) NOT NULL,
  `peminjaman_tgl` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `pengembalian_tgl` timestamp NULL DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`peminjaman_id`, `buku_isbn`, `anggota_id`, `peminjaman_tgl`, `pengembalian_tgl`, `status`) VALUES
('PJM001', '02', 3, '2022-01-05 03:16:32', '2022-01-04 17:00:00', 1),
('PJM002', '03', 5, '2022-01-05 10:47:13', '2022-01-04 17:00:00', 1),
('PJM003', '04', 7, '2022-01-08 21:14:47', '2022-01-08 17:00:00', 1),
('PJM004', '04', 7, '2022-01-14 17:00:00', NULL, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`anggota_id`);

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`buku_isbn`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`peminjaman_id`),
  ADD KEY `buku_isbn` (`buku_isbn`),
  ADD KEY `anggota_id` (`anggota_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `anggota`
--
ALTER TABLE `anggota`
  MODIFY `anggota_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `peminjaman_ibfk_1` FOREIGN KEY (`buku_isbn`) REFERENCES `buku` (`buku_isbn`),
  ADD CONSTRAINT `peminjaman_ibfk_2` FOREIGN KEY (`anggota_id`) REFERENCES `anggota` (`anggota_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
