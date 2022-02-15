-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 15 fév. 2022 à 16:35
-- Version du serveur :  10.4.19-MariaDB
-- Version de PHP : 7.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `sujet-v-mannai-ahmed`
--

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

CREATE TABLE `classe` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `semestre_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`id`, `description`, `semestre_id`) VALUES
(1, 'GI101S01', 1),
(2, 'GI101S02', 2);

-- --------------------------------------------------------

--
-- Structure de la table `eleve_class`
--

CREATE TABLE `eleve_class` (
  `id` bigint(20) NOT NULL,
  `classe_id` bigint(20) DEFAULT NULL,
  `eleve_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `eleve_class`
--

INSERT INTO `eleve_class` (`id`, `classe_id`, `eleve_id`) VALUES
(1, 1, 2),
(2, 2, 2),
(3, 1, 3),
(4, 2, 3),
(5, 1, 4),
(6, 2, 4),
(7, 1, 5),
(8, 2, 5),
(9, 1, 6),
(10, 2, 6);

-- --------------------------------------------------------

--
-- Structure de la table `enseignant_matiere_class`
--

CREATE TABLE `enseignant_matiere_class` (
  `id` bigint(20) NOT NULL,
  `classe_id` bigint(20) DEFAULT NULL,
  `enseignant_id` bigint(20) DEFAULT NULL,
  `matiere_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `enseignant_matiere_class`
--

INSERT INTO `enseignant_matiere_class` (`id`, `classe_id`, `enseignant_id`, `matiere_id`) VALUES
(1, 1, 7, 1),
(2, 1, 7, 2),
(3, 1, 8, 3),
(4, 1, 8, 2),
(5, 1, 8, 3),
(6, 1, 7, 4),
(7, 1, 7, 5),
(8, 1, 7, 4),
(9, 1, 8, 5),
(10, 1, 8, 6),
(11, 1, 7, 7),
(12, 1, 7, 6),
(13, 1, 7, 7),
(14, 2, 7, 8),
(15, 2, 7, 9),
(16, 2, 8, 8),
(17, 2, 7, 9),
(18, 2, 7, 10),
(19, 2, 8, 11),
(20, 2, 7, 10),
(21, 2, 7, 11),
(22, 2, 8, 12),
(23, 2, 7, 13),
(24, 2, 8, 12),
(25, 2, 8, 13),
(26, 2, 8, 14);

-- --------------------------------------------------------

--
-- Structure de la table `examen`
--

CREATE TABLE `examen` (
  `id` bigint(20) NOT NULL,
  `date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `matiere_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `examen`
--

INSERT INTO `examen` (`id`, `date`, `description`, `matiere_id`) VALUES
(1, '2022-02-11 16:46:50', 'examen deMathématique de l\'ingénieur 1', 1),
(2, '2022-02-11 16:46:50', 'examen deAlgorithme ', 2),
(3, '2022-02-11 16:46:50', 'examen deProgrammation C ', 3),
(4, '2022-02-11 16:46:50', 'examen deDevelopement Web  ', 4),
(5, '2022-02-11 16:46:50', 'examen deCour Javascript  ', 5),
(6, '2022-02-11 16:46:50', 'examen deUml', 6),
(7, '2022-02-11 16:46:50', 'examen debase de donnees', 7),
(8, '2022-02-11 16:46:50', 'examen deMathématique de l\'ingénieur 2', 8),
(9, '2022-02-11 16:46:50', 'examen deStatistique inférentielle', 9),
(10, '2022-02-11 16:46:50', 'examen deComplexité des algorithmes et graphes', 10),
(11, '2022-02-11 16:46:50', 'examen deAlgorithmique avancée', 11),
(12, '2022-02-11 16:46:50', 'examen deProgrammationorientée objet ', 12),
(13, '2022-02-11 16:46:50', 'examen deDéveloppement Web avancé ', 13),
(14, '2022-02-11 16:46:50', 'examen deSGBD', 14);

-- --------------------------------------------------------

--
-- Structure de la table `examen_classe`
--

CREATE TABLE `examen_classe` (
  `id` bigint(20) NOT NULL,
  `classe_id` bigint(20) DEFAULT NULL,
  `examen_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `examen_classe`
--

INSERT INTO `examen_classe` (`id`, `classe_id`, `examen_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 1, 5),
(6, 1, 6),
(7, 1, 7),
(8, 2, 8),
(9, 2, 9),
(10, 2, 10),
(11, 2, 11),
(12, 2, 12),
(13, 2, 13),
(14, 2, 14);

-- --------------------------------------------------------

--
-- Structure de la table `matiere`
--

CREATE TABLE `matiere` (
  `id` bigint(20) NOT NULL,
  `coefficient` double DEFAULT NULL,
  `libellee` varchar(255) DEFAULT NULL,
  `module_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `matiere`
--

INSERT INTO `matiere` (`id`, `coefficient`, `libellee`, `module_id`) VALUES
(1, 1.5, 'Mathématique de l\'ingénieur 1', 1),
(2, 3, 'Algorithme ', 2),
(3, 3, 'Programmation C ', 2),
(4, 3, 'Developement Web  ', 3),
(5, 3, 'Cour Javascript  ', 3),
(6, 1.5, 'Uml', 4),
(7, 1.5, 'base de donnees', 4),
(8, 3, 'Mathématique de l\'ingénieur 2', 5),
(9, 1.5, 'Statistique inférentielle', 5),
(10, 2, 'Complexité des algorithmes et graphes', 6),
(11, 3, 'Algorithmique avancée', 6),
(12, 3, 'Programmationorientée objet ', 7),
(13, 3, 'Développement Web avancé ', 7),
(14, 3, 'SGBD', 8);

-- --------------------------------------------------------

--
-- Structure de la table `module`
--

CREATE TABLE `module` (
  `id` bigint(20) NOT NULL,
  `libellee` varchar(255) DEFAULT NULL,
  `semestre_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `module`
--

INSERT INTO `module` (`id`, `libellee`, `semestre_id`) VALUES
(1, 'Mathématiques', 1),
(2, 'Algorithmique et Programmation', 1),
(3, 'Développement Web', 1),
(4, 'Conception', 1),
(5, 'Mathématiques2', 2),
(6, 'Programmation Avancée', 2),
(7, 'Développement Web Objet', 2),
(8, 'bases de donnees', 2);

-- --------------------------------------------------------

--
-- Structure de la table `niveau`
--

CREATE TABLE `niveau` (
  `id` bigint(20) NOT NULL,
  `libellee` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `niveau`
--

INSERT INTO `niveau` (`id`, `libellee`) VALUES
(1, '1er ingenieur'),
(2, '2emme ingenieur'),
(3, '3emme ingenieur'),
(4, '10 emme ingenieur'),
(5, '12 emme ingenieur');

-- --------------------------------------------------------

--
-- Structure de la table `note`
--

CREATE TABLE `note` (
  `id` bigint(20) NOT NULL,
  `note_examen` double NOT NULL,
  `eleve_id` bigint(20) DEFAULT NULL,
  `enseignant_id` bigint(20) DEFAULT NULL,
  `examen_classe_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `note`
--

INSERT INTO `note` (`id`, `note_examen`, `eleve_id`, `enseignant_id`, `examen_classe_id`) VALUES
(1, 16, 2, 7, 1),
(2, 4, 3, 7, 1),
(3, 19, 4, 7, 1),
(4, 17, 5, 7, 1),
(5, 19, 6, 7, 1),
(6, 3, 2, 7, 2),
(7, 10, 3, 7, 2),
(8, 20, 4, 7, 2),
(9, 20, 5, 7, 2),
(10, 14, 6, 7, 2),
(11, 8, 2, 8, 3),
(12, 7, 3, 8, 3),
(13, 2, 4, 8, 3),
(14, 6, 5, 8, 3),
(15, 4, 6, 8, 3),
(16, 7, 2, 7, 4),
(17, 17, 3, 7, 4),
(18, 0, 4, 7, 4),
(19, 13, 5, 7, 4),
(20, 16, 6, 7, 4),
(21, 15, 2, 7, 5),
(22, 19, 3, 7, 5),
(23, 17, 4, 7, 5),
(24, 17, 5, 7, 5),
(25, 17, 6, 7, 5),
(26, 2, 2, 8, 6),
(27, 4, 3, 8, 6),
(28, 9, 4, 8, 6),
(29, 19, 5, 8, 6),
(30, 11, 6, 8, 6),
(31, 15, 2, 7, 7),
(32, 4, 3, 7, 7),
(33, 4, 4, 7, 7),
(34, 13, 5, 7, 7),
(35, 17, 6, 7, 7),
(36, 2, 2, 7, 8),
(37, 3, 3, 7, 8),
(38, 9, 4, 7, 8),
(39, 0, 5, 7, 8),
(40, 0, 6, 7, 8),
(41, 9, 2, 7, 9),
(42, 7, 3, 7, 9),
(43, 7, 4, 7, 9),
(44, 20, 5, 7, 9),
(45, 5, 6, 7, 9),
(46, 1, 2, 7, 10),
(47, 18, 3, 7, 10),
(48, 17, 4, 7, 10),
(49, 5, 5, 7, 10),
(50, 11, 6, 7, 10),
(51, 18, 2, 8, 11),
(52, 12, 3, 8, 11),
(53, 5, 4, 8, 11),
(54, 5, 5, 8, 11),
(55, 19, 6, 8, 11),
(56, 20, 2, 8, 12),
(57, 8, 3, 8, 12),
(58, 3, 4, 8, 12),
(59, 6, 5, 8, 12),
(60, 17, 6, 8, 12),
(61, 17, 2, 7, 13),
(62, 10, 3, 7, 13),
(63, 0, 4, 7, 13),
(64, 14, 5, 7, 13),
(65, 2, 6, 7, 13),
(66, 5, 2, 8, 14),
(67, 16, 3, 8, 14),
(68, 5, 4, 8, 14),
(69, 9, 5, 8, 14),
(70, 16, 6, 8, 14);

-- --------------------------------------------------------

--
-- Structure de la table `semestre`
--

CREATE TABLE `semestre` (
  `id` bigint(20) NOT NULL,
  `libellee` varchar(255) DEFAULT NULL,
  `niveau_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `semestre`
--

INSERT INTO `semestre` (`id`, `libellee`, `niveau_id`) VALUES
(1, 'Semestre1', 1),
(2, 'Semestre2', 1),
(3, 'Semestre3', 2),
(4, 'Semestre4', 2),
(5, 'Semestre5', 3),
(6, 'Semestre6', 3);

-- --------------------------------------------------------

--
-- Structure de la table `t_user`
--

CREATE TABLE `t_user` (
  `user_type` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `numero_inscription` bigint(20) DEFAULT NULL,
  `numero_carte_identitee` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `t_user`
--

INSERT INTO `t_user` (`user_type`, `id`, `email`, `login`, `nom`, `password`, `prenom`, `numero_inscription`, `numero_carte_identitee`) VALUES
('A', 1, 'mannai.ahmed55@gmail.com', 'ahmed55', 'Mannai', '123', 'Ahmed', NULL, NULL),
('EL', 2, 'anis.masoudi@gmail.com', 'anis55', 'masoudi', '123', 'anis', 123456789, NULL),
('EL', 3, 'tawfik.belghith@gmail.com', 'tawfik55', 'belghith', '123', 'tawfik', 441235789, NULL),
('EL', 4, 'karim.hasouni@gmail.com', 'karim55', 'hasouni', '123', 'karim', 251235789, NULL),
('EL', 5, 'tarek.gamoudi@gmail.com', 'tarek55', 'gamoudi', '123', 'tarek', 451235789, NULL),
('EL', 6, 'faycel.twati@gmail.com', 'faycel55', 'twati', '123', 'faycel', 581235789, NULL),
('EN', 7, 'chaker.toujeni@gmail.com', 'chaker55', 'toujeni', '123', 'chaker', NULL, 1975628),
('EN', 8, 'fawzi.hedfi@gmail.com', 'fawzi55', 'hedfi', '123', 'fawzi', NULL, 664908);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `classe`
--
ALTER TABLE `classe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKe7oa3v31ke22q1myu5slka3sn` (`semestre_id`);

--
-- Index pour la table `eleve_class`
--
ALTER TABLE `eleve_class`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhtxpy7yknemh19f5ka777nu8v` (`classe_id`),
  ADD KEY `FK68a2ul0k8iab7pw6nv1kpsbhs` (`eleve_id`);

--
-- Index pour la table `enseignant_matiere_class`
--
ALTER TABLE `enseignant_matiere_class`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbxblehqaccii4nmxva2sieyuu` (`classe_id`),
  ADD KEY `FKo8ic20mwx870i06oxe6kog580` (`enseignant_id`),
  ADD KEY `FKdet9f17tekr649mbfvxfr8str` (`matiere_id`);

--
-- Index pour la table `examen`
--
ALTER TABLE `examen`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKm8y5cp4cgkbo7fju5tjsvf3p7` (`matiere_id`);

--
-- Index pour la table `examen_classe`
--
ALTER TABLE `examen_classe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKp8qy3rnr88c7syc7si5rbotd7` (`classe_id`),
  ADD KEY `FKcpvmh2bm3c0i78p8yidth4gcm` (`examen_id`);

--
-- Index pour la table `matiere`
--
ALTER TABLE `matiere`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK83gjgf557c3rca4ootlrtmjbf` (`module_id`);

--
-- Index pour la table `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKoeiw5u717c5epg1pc84su1dqb` (`semestre_id`);

--
-- Index pour la table `niveau`
--
ALTER TABLE `niveau`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `note`
--
ALTER TABLE `note`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKk1h5eujjsqcwheot88a5novbx` (`eleve_id`),
  ADD KEY `FKtr5vq0qnvi6wwkd46xdbkcenw` (`enseignant_id`),
  ADD KEY `FK1ti1sw2etqqc9q79v8pxr0kcr` (`examen_classe_id`);

--
-- Index pour la table `semestre`
--
ALTER TABLE `semestre`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKj46pckguhydlj980jvtynw54s` (`niveau_id`);

--
-- Index pour la table `t_user`
--
ALTER TABLE `t_user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `classe`
--
ALTER TABLE `classe`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `eleve_class`
--
ALTER TABLE `eleve_class`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `enseignant_matiere_class`
--
ALTER TABLE `enseignant_matiere_class`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT pour la table `examen`
--
ALTER TABLE `examen`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `examen_classe`
--
ALTER TABLE `examen_classe`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `matiere`
--
ALTER TABLE `matiere`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `module`
--
ALTER TABLE `module`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `niveau`
--
ALTER TABLE `niveau`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `note`
--
ALTER TABLE `note`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;

--
-- AUTO_INCREMENT pour la table `semestre`
--
ALTER TABLE `semestre`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `t_user`
--
ALTER TABLE `t_user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `FKe7oa3v31ke22q1myu5slka3sn` FOREIGN KEY (`semestre_id`) REFERENCES `semestre` (`id`);

--
-- Contraintes pour la table `eleve_class`
--
ALTER TABLE `eleve_class`
  ADD CONSTRAINT `FK68a2ul0k8iab7pw6nv1kpsbhs` FOREIGN KEY (`eleve_id`) REFERENCES `t_user` (`id`),
  ADD CONSTRAINT `FKhtxpy7yknemh19f5ka777nu8v` FOREIGN KEY (`classe_id`) REFERENCES `classe` (`id`);

--
-- Contraintes pour la table `enseignant_matiere_class`
--
ALTER TABLE `enseignant_matiere_class`
  ADD CONSTRAINT `FKbxblehqaccii4nmxva2sieyuu` FOREIGN KEY (`classe_id`) REFERENCES `classe` (`id`),
  ADD CONSTRAINT `FKdet9f17tekr649mbfvxfr8str` FOREIGN KEY (`matiere_id`) REFERENCES `matiere` (`id`),
  ADD CONSTRAINT `FKo8ic20mwx870i06oxe6kog580` FOREIGN KEY (`enseignant_id`) REFERENCES `t_user` (`id`);

--
-- Contraintes pour la table `examen`
--
ALTER TABLE `examen`
  ADD CONSTRAINT `FKm8y5cp4cgkbo7fju5tjsvf3p7` FOREIGN KEY (`matiere_id`) REFERENCES `matiere` (`id`);

--
-- Contraintes pour la table `examen_classe`
--
ALTER TABLE `examen_classe`
  ADD CONSTRAINT `FKcpvmh2bm3c0i78p8yidth4gcm` FOREIGN KEY (`examen_id`) REFERENCES `examen` (`id`),
  ADD CONSTRAINT `FKp8qy3rnr88c7syc7si5rbotd7` FOREIGN KEY (`classe_id`) REFERENCES `classe` (`id`);

--
-- Contraintes pour la table `matiere`
--
ALTER TABLE `matiere`
  ADD CONSTRAINT `FK83gjgf557c3rca4ootlrtmjbf` FOREIGN KEY (`module_id`) REFERENCES `module` (`id`);

--
-- Contraintes pour la table `module`
--
ALTER TABLE `module`
  ADD CONSTRAINT `FKoeiw5u717c5epg1pc84su1dqb` FOREIGN KEY (`semestre_id`) REFERENCES `semestre` (`id`);

--
-- Contraintes pour la table `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `FK1ti1sw2etqqc9q79v8pxr0kcr` FOREIGN KEY (`examen_classe_id`) REFERENCES `examen_classe` (`id`),
  ADD CONSTRAINT `FKk1h5eujjsqcwheot88a5novbx` FOREIGN KEY (`eleve_id`) REFERENCES `t_user` (`id`),
  ADD CONSTRAINT `FKtr5vq0qnvi6wwkd46xdbkcenw` FOREIGN KEY (`enseignant_id`) REFERENCES `t_user` (`id`);

--
-- Contraintes pour la table `semestre`
--
ALTER TABLE `semestre`
  ADD CONSTRAINT `FKj46pckguhydlj980jvtynw54s` FOREIGN KEY (`niveau_id`) REFERENCES `niveau` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
