-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 13 Bulan Mei 2020 pada 09.48
-- Versi server: 10.4.6-MariaDB
-- Versi PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbresponsi`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `idd` varchar(15) NOT NULL,
  `namaa` varchar(30) NOT NULL,
  `alamatt` char(50) NOT NULL,
  `no_hpp` varchar(15) NOT NULL,
  `posisii` varchar(30) NOT NULL,
  `gajii` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_gaji`
--

CREATE TABLE `data_gaji` (
  `idp` varchar(15) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `posisi` varchar(30) NOT NULL,
  `alamat` char(50) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `gajipokok` int(11) NOT NULL,
  `lembur` int(11) NOT NULL,
  `tunjangan` int(11) NOT NULL,
  `totalgaji` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `data_gaji`
--

INSERT INTO `data_gaji` (`idp`, `nama`, `posisi`, `alamat`, `no_hp`, `gajipokok`, `lembur`, `tunjangan`, `totalgaji`) VALUES
('123180091', 'Alya', 'Manager', 'Yogya', '087671628123', 5000000, 12, 180000, 5130000);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
