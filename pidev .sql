-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 27 fév. 2020 à 11:30
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pidev`
--

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

DROP TABLE IF EXISTS `evenement`;
CREATE TABLE IF NOT EXISTS `evenement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `capacite` varchar(11) NOT NULL,
  `nom` varchar(55) NOT NULL,
  `heure_d` varchar(15) NOT NULL,
  `description` varchar(55) NOT NULL,
  `date_evt` varchar(15) NOT NULL,
  `image` varchar(55) NOT NULL,
  `type` varchar(12) NOT NULL,
  `depart` varchar(25) DEFAULT NULL,
  `destination` varchar(25) DEFAULT NULL,
  `lieu` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`id`, `capacite`, `nom`, `heure_d`, `description`, `date_evt`, `image`, `type`, `depart`, `destination`, `lieu`) VALUES
(14, 'zaeazeazeaz', 'zeazeaze', '18:05', 'aeazeazeazeaz', '2020-01-29', 'C:\\Users\\ASUS\\Pictures\\Saved Pictures\\5.png', 'Excursion', 'zaeaze', 'ezaeaz', NULL),
(15, '50', 'aaaaaaaa', '14:39', 'fdss', '2020-02-24', 'C:UsersASUSPicturesSaved Pictures5.png', 'Excursion', 'fsdfsdf', 'dsffsdfsdf', NULL),
(17, '50', 'fsdfsd', '12:29', 'fdsf', '2020-02-04', 'C:UsersASUSPicturesSaved Pictures5.png', 'Excursion', 'fdnkfsdkj', 'fklndsfskl', NULL),
(18, '25', 'fdqfs', '23:29', 'qcsdkj', '2020-02-07', 'C:UsersASUSDesktopimage\nader.jpg', 'Excursion', 'fdsfsd', 'fdssdf', NULL),
(20, '50', 'dscq', '12:36', 'dfskdj', '2020-02-12', 'C:UsersASUSDesktopimagesana.jpg', 'Excursion', 'fsjkshjb', 'kljfsdgkj', NULL),
(21, '25', ',sgkdf', '12:44', 'zfednskvjbh', '2020-02-26', 'file:/C:/Users/ASUS/Pictures/Saved%20Pictures/5.png', 'Excursion', 'fsklgn', 'fsdksjk', NULL),
(22, '75', 'gfdgf', '18:33', 'gfdgdf', '2020-02-24', 'C:UsersASUSPicturesSaved Pictures5.png', 'Excursion', 'fsdfsd', 'sfds', NULL),
(23, '50', 'ghcfhg', '20:54', 'uigy', '2020-02-26', 'file:/C:/Users/ASUS/Pictures/Saved%20Pictures/5.png', 'Excursion', 'jdfkl', 'DSJKBH', NULL),
(27, '25', 'feteees', '17:07', 'dqfqd', '2020-02-12', 'C:UsersASUSPicturesSaved Pictures5.png', 'Fête', NULL, NULL, 'zaezea'),
(28, '25', 'hhhh', '00:19', 'fdgdfg', '2020-02-25', 'file:/C:/Users/ASUS/Pictures/Saved%20Pictures/5.png', 'Excursion', 'dghd', 'dfhdggh', NULL),
(29, '50', 'fgdf', '12:16', 'gdfg', '2020-02-19', 'C:UsersASUSPicturesSaved Pictures5.png', 'Fête', NULL, NULL, 'tazarka');

-- --------------------------------------------------------

--
-- Structure de la table `inscrevt`
--

DROP TABLE IF EXISTS `inscrevt`;
CREATE TABLE IF NOT EXISTS `inscrevt` (
  `id` int(11) NOT NULL,
  `id_enfant` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `inscrevt`
--

INSERT INTO `inscrevt` (`id`, `id_enfant`) VALUES
(19, 19),
(17, 17),
(14, 14),
(17, 17);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
