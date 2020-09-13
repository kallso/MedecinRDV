-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 13 sep. 2020 à 12:48
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
-- Base de données :  `medecinrdv`
--
CREATE DATABASE IF NOT EXISTS `medecinrdv` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `medecinrdv`;

-- --------------------------------------------------------

--
-- Structure de la table `creneau`
--

DROP TABLE IF EXISTS `creneau`;
CREATE TABLE IF NOT EXISTS `creneau` (
  `id_creneau` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `date_debut` datetime NOT NULL,
  `date_fin` datetime NOT NULL,
  PRIMARY KEY (`id_creneau`),
  KEY `creneau_medecin` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `medecin`
--

DROP TABLE IF EXISTS `medecin`;
CREATE TABLE IF NOT EXISTS `medecin` (
  `id_user` int(11) NOT NULL,
  `specialisation` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `temps_rdv` varchar(10) NOT NULL,
  `code_postal` int(11) NOT NULL,
  `ville` varchar(255) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `id_medecin` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `medecin`
--

INSERT INTO `medecin` (`id_user`, `specialisation`, `adresse`, `temps_rdv`, `code_postal`, `ville`) VALUES
(29, 'cardio', '15 rue des pillules fraiches', '00:15', 31300, 'Nantes'),
(30, 'cardio', '26 rue des bonbonnes enflammées', '02:00', 31600, 'Toulouse'),
(39, 'cardio', '2 rue des chiens aux aboies', '01:45', 31400, 'Toulouse'),
(42, 'pediatre', '5 rue des mamies débousolées', '00:45', 31140, 'Toulouse'),
(43, 'cardio', '6 rue des cocktails de quartier', '00:45', 31456, 'Toulouse'),
(44, 'pediatre', '9 rue des borgnes immaculés', '02:45', 31800, 'Toulouse');

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE IF NOT EXISTS `patient` (
  `id_user` int(11) NOT NULL,
  `num_secu` int(11) NOT NULL,
  PRIMARY KEY (`id_user`),
  KEY `id_patient` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`id_user`, `num_secu`) VALUES
(2, 12345);

-- --------------------------------------------------------

--
-- Structure de la table `rdv`
--

DROP TABLE IF EXISTS `rdv`;
CREATE TABLE IF NOT EXISTS `rdv` (
  `id_user` int(11) NOT NULL,
  `id_creneau` int(11) NOT NULL,
  `heure_debut` datetime NOT NULL,
  `id_rdv` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_rdv`),
  KEY `rdv_patient` (`id_user`),
  KEY `rdv_crenau` (`id_creneau`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `telephone` varchar(255) NOT NULL,
  PRIMARY KEY (`id_user`),
  KEY `id_user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id_user`, `nom`, `prenom`, `mail`, `password`, `telephone`) VALUES
(1, 'Raiff', 'Bertrand', 'bertrand@VM.com', 'LAVMMARCHEPA', '+33666666666'),
(2, 'Garcia', 'Simon', 'fantome@gmail.com', 'jesuispalaaaaa', '+33541235822'),
(3, 'Balatia', 'Yaya', 'yayaToure@but.com', 'CLEBUUUUUUT', '+33544658499'),
(8, 'Ulster', 'Francis', 'franfran@casonade.slah', '123456789', '+3366666666'),
(29, 'Mas', 'Charles', 'piquouze@bobo.fr', '123456', '01456684598'),
(30, 'Durand', 'Marc', 'dudu@mama.fr', 'motDePa$$', '0145668458'),
(39, 'Costner', 'Kevin', 'aieaie@bobo.fr', '123456', '01456687862'),
(42, 'Corias', 'Pierre', 'aiiiicafaitmal@bobo.fr', '123456', '01456687862'),
(43, 'Astier', 'Kevin', 'voodoo@grammar.com', 'astalavistamiamorbabe', '0645781923'),
(44, 'Zalzali', 'Ahmad', 'zalza@salsa.sli', 'lafrite', '+33457895622');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `creneau`
--
ALTER TABLE `creneau`
  ADD CONSTRAINT `creneau_medecin` FOREIGN KEY (`id_user`) REFERENCES `medecin` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `medecin`
--
ALTER TABLE `medecin`
  ADD CONSTRAINT `user_medecin` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `patient`
--
ALTER TABLE `patient`
  ADD CONSTRAINT `user_patient` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `rdv`
--
ALTER TABLE `rdv`
  ADD CONSTRAINT `rdv_creneau` FOREIGN KEY (`id_creneau`) REFERENCES `creneau` (`id_creneau`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rdv_patient` FOREIGN KEY (`id_user`) REFERENCES `patient` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
