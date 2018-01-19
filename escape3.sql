-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 19 Janvier 2018 à 00:10
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `escape3`
--

-- --------------------------------------------------------

--
-- Structure de la table `agence_location`
--

CREATE TABLE IF NOT EXISTS `agence_location` (
  `id_agence` int(11) NOT NULL AUTO_INCREMENT,
  `nom_agence` varchar(30) NOT NULL,
  `num_fixe` int(11) NOT NULL,
  `adresse_agence` varchar(30) NOT NULL,
  `mail_agence` varchar(30) NOT NULL,
  `mdp_agence` int(11) NOT NULL,
  PRIMARY KEY (`id_agence`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `bus`
--

CREATE TABLE IF NOT EXISTS `bus` (
  `matricule` varchar(11) NOT NULL,
  `chauffeur` varchar(20) NOT NULL,
  `nbr_places` int(11) NOT NULL,
  `prix_bus` float NOT NULL,
  `id_agence` int(20) NOT NULL,
  PRIMARY KEY (`matricule`),
  KEY `idagence` (`id_agence`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

CREATE TABLE IF NOT EXISTS `commentaire` (
  `id_comment` int(100) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `commentaire` varchar(20) DEFAULT NULL,
  `titre` varchar(500) NOT NULL,
  `date_env` varchar(5000) DEFAULT NULL,
  `user_name` varchar(500) NOT NULL,
  `signals` varchar(100) NOT NULL,
  `photo` varchar(5000) DEFAULT NULL,
  `idsuj` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_comment`),
  KEY `fk_user` (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=66 ;

--
-- Contenu de la table `commentaire`
--

INSERT INTO `commentaire` (`id_comment`, `id_user`, `commentaire`, `titre`, `date_env`, `user_name`, `signals`, `photo`, `idsuj`) VALUES
(42, 5, 'msss', 'ou allez ', '0000-00-00 00:00:00', 'ss', 'ssss', NULL, NULL),
(48, 8, 'ffmmmmm', 'bcp eau', '0000-00-00 00:00:00', 'null', 'ppp', NULL, NULL),
(49, 9, 'no comment', 'bcp eau', '0000-00-00 00:00:00', 'sir', 'oui', NULL, NULL),
(50, 5, 'mch bhyy jimla', 'nouveautés', '0000-00-00 00:00:00', 'null', 'ppp', NULL, NULL),
(51, 5, 'mch bhyy jimla', 'conseils', '0000-00-00 00:00:00', 'null', 'ppp', NULL, NULL),
(52, 5, 'mch bhyy jimla', 'annonces', '0000-00-00 00:00:00', 'null', 'ppp', NULL, NULL),
(53, 5, 'mch bhyy jimla jimla', 'conseils', '0000-00-00 00:00:00', 'null', 'ppp', NULL, NULL),
(54, 5, 'mmpppp', 'randonnées', '0000-00-00 00:00:00', 'null', 'ppp', NULL, NULL),
(56, 5, 'mmmmpppp', 'randonnées', '0000-00-00 00:00:00', 'null', 'ppp', NULL, NULL),
(57, 5, 'mmpppp', 'randonnées', '0000-00-00 00:00:00', 'null', 'ppp', NULL, NULL),
(58, 5, 'mmpppp', 'randonnées', '0000-00-00 00:00:00', 'null', 'ppp', NULL, NULL),
(59, 8, 'cdcxc', 'nouveautés', '0000-00-00 00:00:00', 'date', '0', NULL, NULL),
(61, 8, 'kjgbkjbj,', 'nouveautés', '0000-00-00 00:00:00', 'date', '0', NULL, NULL),
(62, 8, ',;k;', 'conseils', '0000-00-00 00:00:00', 'date', '0', NULL, NULL),
(63, 8, 'dsd', 'nouveautés', '0000-00-00 00:00:00', 'date', '0', '0', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `forum`
--

CREATE TABLE IF NOT EXISTS `forum` (
  `idF` int(11) NOT NULL AUTO_INCREMENT,
  `nomF` varchar(500) NOT NULL,
  `topicF` varchar(20) NOT NULL,
  PRIMARY KEY (`idF`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `forum`
--

INSERT INTO `forum` (`idF`, `nomF`, `topicF`) VALUES
(1, 'randonnées', 'ou allez nous'),
(2, ' nouveautés', 'des astuces'),
(3, 'conseils', 'améliorez votre vie'),
(4, 'annonces', 'achat_vente');

-- --------------------------------------------------------

--
-- Structure de la table `lieu`
--

CREATE TABLE IF NOT EXISTS `lieu` (
  `id_lieu` int(11) NOT NULL AUTO_INCREMENT,
  `gouvernorat` varchar(20) NOT NULL,
  `delegation` varchar(20) NOT NULL,
  `description` varchar(20) NOT NULL,
  `evaluation` int(20) NOT NULL,
  PRIMARY KEY (`id_lieu`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `lieu`
--

INSERT INTO `lieu` (`id_lieu`, `gouvernorat`, `delegation`, `description`, `evaluation`) VALUES
(6, 'tunis', 'ksar hlel', 'tak tak tak', 10);

-- --------------------------------------------------------

--
-- Structure de la table `note`
--

CREATE TABLE IF NOT EXISTS `note` (
  `id_note` int(11) NOT NULL AUTO_INCREMENT,
  `note` int(20) NOT NULL,
  `nom` varchar(1000) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_sujet` int(11) NOT NULL,
  PRIMARY KEY (`id_note`),
  KEY `fkid_user` (`id_user`),
  KEY `fkid_sujet` (`id_sujet`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `notification`
--

CREATE TABLE IF NOT EXISTS `notification` (
  `id_notification` int(11) NOT NULL AUTO_INCREMENT,
  `description` longtext NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_notification`),
  KEY `id_user` (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `notification`
--

INSERT INTO `notification` (`id_notification`, `description`, `id_user`) VALUES
(1, 'alerte', 3),
(2, 'alerte', 3),
(3, 'alerte', 3),
(4, 'alerte', 3),
(5, 'notification', 3),
(6, 'notification', 3),
(7, 'notification', 3),
(8, 'notification', 3);

-- --------------------------------------------------------

--
-- Structure de la table `offre_emploi`
--

CREATE TABLE IF NOT EXISTS `offre_emploi` (
  `id_offre` int(11) NOT NULL AUTO_INCREMENT,
  `id_user_fk` int(11) NOT NULL,
  `id_boutique_fk` int(11) NOT NULL,
  `poste` varchar(50) DEFAULT NULL,
  `specialite` varchar(50) DEFAULT NULL,
  `salaire` float DEFAULT NULL,
  `nbr_demandé` int(11) DEFAULT NULL,
  `date_expiration` date DEFAULT NULL,
  PRIMARY KEY (`id_offre`),
  KEY `id_boutique` (`id_boutique_fk`),
  KEY `id_user_fk` (`id_user_fk`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `offre_emploi`
--

INSERT INTO `offre_emploi` (`id_offre`, `id_user_fk`, `id_boutique_fk`, `poste`, `specialite`, `salaire`, `nbr_demandé`, `date_expiration`) VALUES
(2, 1, 8, 'chef', 'resto', 1500, 5, '2010-08-12');

-- --------------------------------------------------------

--
-- Structure de la table `randonnee`
--

CREATE TABLE IF NOT EXISTS `randonnee` (
  `id_randonnee` int(11) NOT NULL AUTO_INCREMENT,
  `categorie` varchar(20) NOT NULL,
  `duree` varchar(20) NOT NULL,
  `nb_places` int(20) NOT NULL,
  `prix` varchar(225) NOT NULL,
  `materiel` varchar(50) NOT NULL,
  `description` varchar(50) NOT NULL,
  `image_rando` varchar(225) NOT NULL,
  `date_debut` varchar(20) NOT NULL,
  `heure_depart` varchar(20) NOT NULL,
  `etat` int(11) NOT NULL,
  `statut` varchar(20) NOT NULL,
  `id_guide` int(20) NOT NULL,
  `id_photographe` int(20) NOT NULL,
  `id_randonneur` int(11) NOT NULL,
  `id_lieu` int(11) NOT NULL,
  `updated_at` varchar(20) NOT NULL,
  `id_organisateur` int(11) NOT NULL,
  PRIMARY KEY (`id_randonnee`),
  KEY `id_guiide` (`id_guide`),
  KEY `id_photoo` (`id_photographe`),
  KEY `id_randoo` (`id_randonneur`),
  KEY `id_lieuu` (`id_lieu`),
  KEY `id_organi` (`id_organisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

CREATE TABLE IF NOT EXISTS `reclamation` (
  `id_reclamation` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL,
  `text` longtext NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_reclamation`),
  KEY `id_user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE IF NOT EXISTS `reservation` (
  `id_reservation` int(11) NOT NULL AUTO_INCREMENT,
  `id_randonnee` int(11) NOT NULL,
  `id_randonneur` int(11) NOT NULL,
  `compteur` int(20) NOT NULL,
  PRIMARY KEY (`id_reservation`),
  KEY `id_rano` (`id_randonnee`),
  KEY `id_randonneurr` (`id_randonneur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `sujet`
--

CREATE TABLE IF NOT EXISTS `sujet` (
  `id_sujet` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `titre` varchar(5000) NOT NULL,
  `theme` varchar(500) NOT NULL,
  `name_user` varchar(500) NOT NULL,
  `texte` varchar(500) NOT NULL,
  `date` varchar(11) NOT NULL,
  PRIMARY KEY (`id_sujet`),
  UNIQUE KEY `id_sujet` (`id_sujet`),
  KEY `fk_iduser` (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=27 ;

--
-- Contenu de la table `sujet`
--

INSERT INTO `sujet` (`id_sujet`, `id_user`, `titre`, `theme`, `name_user`, `texte`, `date`) VALUES
(9, 5, 'randonnées', 'ou se trouve hergla?', 'bella', 'belle lieu', '17/08/5'),
(10, 8, 'nouveautés', 'nouveau', 'toto', 'mawmaw', 'm'),
(21, 5, 'conseils', 'santé', '3amara', 'fruits', 'mmmm'),
(22, 5, 'conseils', 'food', 'alianza ', 'pomme', 'mmmm'),
(24, 8, 'annonces', 'matériel ', 'moumou', 'jeans ', 'mmmm'),
(26, 5, 'conseils', 'pluie', 'koukou', 'bcp d''eau', 'm');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `cin` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `adresse_mail` varchar(30) NOT NULL,
  `adresse` varchar(20) NOT NULL,
  `date_naissance` date NOT NULL,
  `num_tel` int(11) NOT NULL,
  `metier` varchar(20) NOT NULL,
  `sexe` varchar(20) NOT NULL,
  `nationalite` varchar(20) NOT NULL,
  `mdp` varchar(20) NOT NULL,
  `role` varchar(20) NOT NULL,
  `competence` varchar(20) NOT NULL,
  `annee_exp` int(11) NOT NULL,
  `about_me` varchar(30) NOT NULL,
  `evaluation` int(11) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id_user`, `cin`, `nom`, `prenom`, `adresse_mail`, `adresse`, `date_naissance`, `num_tel`, `metier`, `sexe`, `nationalite`, `mdp`, `role`, `competence`, `annee_exp`, `about_me`, `evaluation`) VALUES
(5, 5555, 'marwa', 'tounsi', 'hhh', 'jjjjjjj', '2017-10-03', 555, 'jj', 'jjjj', 'fgdfgfg', 'dg', 'gsgff', 'ffff', 455, 'fff', 77),
(8, 555, 'saleh', 'nabli', 'sss', 'sdd', '2017-10-10', 5202020, 'fale7', 'rrrp', 'hendi', '4444', 'batal', 'ka3bla le', 1485, 'chay', 574),
(9, 20254, 'sawsn', 'ben ahmed', 'ggggg', 'ggggggggg', '2017-10-04', 20, 'ffffff', 'fdssssdsd', 'dsdsds', 'dsdsds', 'dsdsd', 'dsds', 88, 'sdsds', 888);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `bus`
--
ALTER TABLE `bus`
  ADD CONSTRAINT `bus_ibfk_1` FOREIGN KEY (`id_agence`) REFERENCES `agence_location` (`id_agence`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `fkid_sujet` FOREIGN KEY (`id_sujet`) REFERENCES `sujet` (`id_sujet`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fkid_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `randonnee`
--
ALTER TABLE `randonnee`
  ADD CONSTRAINT `fkguide` FOREIGN KEY (`id_guide`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FKlieu` FOREIGN KEY (`id_lieu`) REFERENCES `lieu` (`id_lieu`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fkorganisateur` FOREIGN KEY (`id_organisateur`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FKphoto` FOREIGN KEY (`id_photographe`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fkrandonneur` FOREIGN KEY (`id_randonneur`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `fkrandonnee` FOREIGN KEY (`id_randonnee`) REFERENCES `randonnee` (`id_randonnee`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fkrandonneurr` FOREIGN KEY (`id_randonneur`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `sujet`
--
ALTER TABLE `sujet`
  ADD CONSTRAINT `fk_iduser` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
