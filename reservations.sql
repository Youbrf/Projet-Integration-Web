-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 16 juin 2022 à 21:03
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `reservations`
--

-- --------------------------------------------------------

--
-- Structure de la table `artists`
--

CREATE TABLE `artists` (
  `id` int(11) NOT NULL,
  `firstname` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `lastname` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `artists`
--

INSERT INTO `artists` (`id`, `firstname`, `lastname`) VALUES
(1, 'Daniel', 'Marcelin'),
(2, 'Philippe', 'Laurent'),
(3, 'Marius', 'Von Mayenburg'),
(4, 'Olivier', 'Boudon'),
(5, 'Anne Marie', 'Loop'),
(6, 'Pietro', 'Varasso'),
(7, 'Laurent', 'Caron'),
(8, 'Élena', 'Perez'),
(9, 'Guillaume', 'Alexandre'),
(10, 'Claude', 'Semal'),
(11, 'Laurence', 'Warin'),
(12, 'Pierre', 'Wayburn'),
(13, 'Gwendoline', 'Gauthier');

-- --------------------------------------------------------

--
-- Structure de la table `artist_type`
--

CREATE TABLE `artist_type` (
  `id` int(11) NOT NULL,
  `artist_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `artist_type`
--

INSERT INTO `artist_type` (`id`, `artist_id`, `type_id`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 1, 2),
(4, 2, 2),
(5, 1, 3),
(6, 3, 1),
(7, 4, 2),
(8, 5, 3),
(9, 6, 3),
(10, 7, 3),
(11, 8, 3),
(12, 9, 3),
(13, 10, 1),
(14, 11, 2),
(15, 10, 3),
(16, 12, 1),
(17, 13, 1),
(18, 12, 3),
(19, 13, 3);

-- --------------------------------------------------------

--
-- Structure de la table `artist_type_show`
--

CREATE TABLE `artist_type_show` (
  `id` int(11) NOT NULL,
  `artist_type_id` int(11) NOT NULL,
  `show_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `artist_type_show`
--

INSERT INTO `artist_type_show` (`id`, `artist_type_id`, `show_id`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 1),
(4, 4, 1),
(5, 5, 1),
(6, 6, 2),
(7, 7, 2),
(8, 8, 2),
(9, 9, 2),
(10, 10, 2),
(11, 11, 2),
(12, 12, 2),
(13, 13, 3),
(14, 14, 3),
(15, 15, 3),
(16, 4, 4),
(17, 16, 4),
(18, 17, 4),
(19, 18, 4),
(20, 19, 4);

-- --------------------------------------------------------

--
-- Structure de la table `flyway_schema_history`
--

CREATE TABLE `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT current_timestamp(),
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `flyway_schema_history`
--

INSERT INTO `flyway_schema_history` (`installed_rank`, `version`, `description`, `type`, `script`, `checksum`, `installed_by`, `installed_on`, `execution_time`, `success`) VALUES
(1, '1.1', 'create artists table', 'SQL', 'V1_1__create_artists_table.sql', -1928428595, 'root', '2022-06-16 18:07:09', 29, 1),
(2, '1.2', 'insert artists table', 'SQL', 'V1_2__insert_artists_table.sql', -280175186, 'root', '2022-06-16 18:07:09', 5, 1),
(3, '2.1', 'create types table', 'SQL', 'V2_1__create_types_table.sql', 1925872095, 'root', '2022-06-16 18:07:09', 26, 1),
(4, '2.2', 'insert types table', 'SQL', 'V2_2__insert_types_table.sql', -126045216, 'root', '2022-06-16 18:07:09', 5, 1),
(5, '3.1', 'create localities table', 'SQL', 'V3_1__create_localities_table.sql', 175429460, 'root', '2022-06-16 18:07:09', 26, 1),
(6, '3.2', 'insert localities table', 'SQL', 'V3_2__insert_localities_table.sql', 805785997, 'root', '2022-06-16 18:07:09', 7, 1),
(7, '4.1', 'create roles table', 'SQL', 'V4_1__create_roles_table.sql', 239598783, 'root', '2022-06-16 18:07:10', 21, 1),
(8, '4.2', 'insert roles table', 'SQL', 'V4_2__insert_roles_table.sql', -1624113663, 'root', '2022-06-16 18:07:10', 4, 1),
(9, '5.1', 'create locations table', 'SQL', 'V5_1__create_locations_table.sql', 1736301610, 'root', '2022-06-16 18:07:10', 79, 1),
(10, '5.2', 'insert locations table', 'SQL', 'V5_2__insert_locations_table.sql', -24996490, 'root', '2022-06-16 18:07:10', 5, 1),
(11, '6.1', 'create shows table', 'SQL', 'V6_1__create_shows_table.sql', -892313632, 'root', '2022-06-16 18:07:10', 94, 1),
(12, '6.2', 'insert shows table', 'SQL', 'V6_2__insert_shows_table.sql', -2085968838, 'root', '2022-06-16 18:07:10', 4, 1),
(13, '7.1', 'create representations table', 'SQL', 'V7_1__create_representations_table.sql', 180579787, 'root', '2022-06-16 18:07:10', 88, 1),
(14, '7.2', 'insert representations  table', 'SQL', 'V7_2__insert_representations _table.sql', -1984306659, 'root', '2022-06-16 18:07:10', 4, 1),
(15, '8.1', 'create artist type table', 'SQL', 'V8_1__create_artist_type_table.sql', 1676507029, 'root', '2022-06-16 18:07:10', 163, 1),
(16, '8.2', 'insert artist type table', 'SQL', 'V8_2__insert_artist_type_table.sql', -1003207613, 'root', '2022-06-16 18:07:10', 4, 1),
(17, '9.1', 'create artist type show table', 'SQL', 'V9_1__create_artist_type_show_table.sql', -423954201, 'root', '2022-06-16 18:07:10', 89, 1),
(18, '9.2', 'insert artist type show table', 'SQL', 'V9_2__insert_artist_type_show_table.sql', -31123080, 'root', '2022-06-16 18:07:10', 4, 1),
(19, '10.1', 'create users table', 'SQL', 'V10_1__create_users_table.sql', 513360628, 'root', '2022-06-16 18:07:10', 37, 1),
(20, '10.2', 'insert users table', 'SQL', 'V10_2__insert_users_table.sql', -297260466, 'root', '2022-06-16 18:07:10', 6, 1),
(21, '11.1', 'create user role table', 'SQL', 'V11_1__create_user_role_table.sql', -330443967, 'root', '2022-06-16 18:07:11', 151, 1),
(22, '11.2', 'insert user role table', 'SQL', 'V11_2__insert_user_role_table.sql', 425274378, 'root', '2022-06-16 18:07:11', 4, 1),
(23, '12.1', 'create reservations table', 'SQL', 'V12_1__create_reservations_table.sql', 1726137537, 'root', '2022-06-16 18:07:11', 158, 1),
(24, '12.2', 'insert reservations table', 'SQL', 'V12_2__insert_reservations_table.sql', 2074592799, 'root', '2022-06-16 18:07:11', 4, 1),
(25, '13.1', 'create rooms table', 'SQL', 'V13_1__create_rooms_table.sql', 1163394789, 'root', '2022-06-16 18:07:11', 86, 1),
(26, '13.2', 'insert rooms table', 'SQL', 'V13_2__insert_rooms_table.sql', 790925655, 'root', '2022-06-16 18:07:11', 3, 1);

-- --------------------------------------------------------

--
-- Structure de la table `localities`
--

CREATE TABLE `localities` (
  `id` int(11) NOT NULL,
  `postal_code` varchar(6) COLLATE utf8mb4_unicode_ci NOT NULL,
  `locality` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `localities`
--

INSERT INTO `localities` (`id`, `postal_code`, `locality`) VALUES
(1, '1000', 'Bruxelles'),
(2, '1020', 'Laeken'),
(3, '1030', 'Schaerbeek'),
(4, '1170', 'Watermael-Boistfort');

-- --------------------------------------------------------

--
-- Structure de la table `locations`
--

CREATE TABLE `locations` (
  `id` int(11) NOT NULL,
  `slug` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `designation` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `locality_id` int(11) NOT NULL,
  `website` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `locations`
--

INSERT INTO `locations` (`id`, `slug`, `designation`, `address`, `locality_id`, `website`, `phone`) VALUES
(1, 'espace-delvaux-la-venerie', 'Espace Delvaux / La Vénerie', '3 rue Gratès', 4, 'https://www.lavenerie.be', '+32 (0)2/663.85.50'),
(2, 'dexia-art-center', 'Dexia Art Center', '50 rue de l\'Ecuyer', 1, NULL, NULL),
(3, 'la-samaritaine', 'La Samaritaine', '16 rue de la samaritaine', 1, 'http://www.lasamaritaine.be/', NULL),
(4, 'espace-magh', 'Espace Magh', '17 rue du Poinçon', 1, 'http://www.espacemagh.be', '+32 (0)2/274.05.10');

-- --------------------------------------------------------

--
-- Structure de la table `representations`
--

CREATE TABLE `representations` (
  `id` int(11) NOT NULL,
  `show_id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL,
  `when` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `representations`
--

INSERT INTO `representations` (`id`, `show_id`, `room_id`, `when`) VALUES
(1, 1, 3, '2012-10-12 13:30:00.000000'),
(2, 1, 2, '2012-10-12 20:30:00.000000'),
(3, 2, 1, '2012-10-02 20:30:00.000000'),
(4, 3, 4, '2012-10-16 20:30:00.000000');

-- --------------------------------------------------------

--
-- Structure de la table `reservations`
--

CREATE TABLE `reservations` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `representation_id` int(11) NOT NULL,
  `places` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `reservations`
--

INSERT INTO `reservations` (`id`, `user_id`, `representation_id`, `places`) VALUES
(1, 2, 1, 3),
(2, 2, 2, 5);

-- --------------------------------------------------------

--
-- Structure de la table `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `role` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `roles`
--

INSERT INTO `roles` (`id`, `role`) VALUES
(1, 'admin'),
(3, 'affiliate'),
(2, 'member');

-- --------------------------------------------------------

--
-- Structure de la table `rooms`
--

CREATE TABLE `rooms` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `seats` int(11) DEFAULT NULL,
  `location_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `rooms`
--

INSERT INTO `rooms` (`id`, `name`, `seats`, `location_id`) VALUES
(1, 'ubuntu', 50, 1),
(2, 'kibera', 40, 2),
(3, 'Fellini', 100, 4),
(4, 'kuito', 80, 3);

-- --------------------------------------------------------

--
-- Structure de la table `shows`
--

CREATE TABLE `shows` (
  `id` int(11) NOT NULL,
  `slug` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` longtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `poster_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `bookable` tinyint(1) NOT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `location_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `shows`
--

INSERT INTO `shows` (`id`, `slug`, `title`, `description`, `poster_url`, `bookable`, `price`, `created_at`, `updated_at`, `location_id`) VALUES
(1, 'ayiti', 'Ayiti', 'Un homme est bloqué à l’aéroport.\n Questionné par les douaniers, il doit alors justifier son identité, et surtout prouver qu\'il est haïtien – qu\'est-ce qu\'être haïtien ?', 'ayiti.jpg', 1, '9.00', '2020-04-21 19:08:44.583000', NULL, 1),
(2, 'cible-mouvante', 'Cible mouvante', 'Dans ce « thriller d’anticipation », des adultes semblent alimenter et véhiculer une crainte féroce envers les enfants âgés entre 10 et 12 ans.', 'cible.jpg', 1, '9.00', '2020-04-21 19:08:53.156000', NULL, 2),
(3, 'ceci-nest-pas-un-chanteur-belge', 'Ceci n\'est pas un chanteur belge', 'Non peut-être ?!\nEntre Magritte (pour le surréalisme comique) et Maigret (pour le réalisme mélancolique), ce dixième opus semalien propose quatorze nouvelles chansons mêlées à de petits textes humoristiques et à quelques fortes images poétiques.', 'claudebelgesaison220.jpg', 1, '5.50', '2020-04-21 19:08:53.189000', '2020-04-21 19:08:53.189000', NULL),
(4, 'manneke', 'Manneke… !', 'A tour de rôle, Pierre se joue de ses oncles, tantes, grands-parents et surtout de sa mère.', 'wayburn.jpg', 1, '10.50', '2020-04-21 19:09:02.426000', '2020-04-21 19:09:02.426000', 3);

-- --------------------------------------------------------

--
-- Structure de la table `types`
--

CREATE TABLE `types` (
  `id` int(11) NOT NULL,
  `type` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `types`
--

INSERT INTO `types` (`id`, `type`) VALUES
(1, 'auteur'),
(2, 'scénographe'),
(3, 'comédien');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `login` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `firstname` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `lastname` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `langue` varchar(2) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `login`, `password`, `firstname`, `lastname`, `email`, `langue`, `created_at`) VALUES
(1, 'bob', '', 'Bob', 'Sull', 'bob@sull.com', 'fr', '2010-01-01 12:00:00'),
(2, 'lana', '', 'Lana', 'Sull', 'lana@sull.com', 'fr', '2010-01-01 12:00:00'),
(3, 'affiliate', '', 'Affi', 'Liate', 'contact@affiliate.com', 'fr', '2020-01-01 12:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `user_role`
--

CREATE TABLE `user_role` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `user_role`
--

INSERT INTO `user_role` (`id`, `user_id`, `role_id`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `artists`
--
ALTER TABLE `artists`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `artist_type`
--
ALTER TABLE `artist_type`
  ADD PRIMARY KEY (`id`),
  ADD KEY `artist_type_artist_id_ IDX_3060D1B6B7970CF8_fk_artists_id` (`artist_id`),
  ADD KEY `artist_type_type_id_ IDX_3060D1B6C54C8C93_fk_types_id` (`type_id`);

--
-- Index pour la table `artist_type_show`
--
ALTER TABLE `artist_type_show`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_9F6421FED0C1FC64` (`show_id`),
  ADD KEY `IDX_9F6421FE7203D2A4` (`artist_type_id`);

--
-- Index pour la table `flyway_schema_history`
--
ALTER TABLE `flyway_schema_history`
  ADD PRIMARY KEY (`installed_rank`),
  ADD KEY `flyway_schema_history_s_idx` (`success`);

--
-- Index pour la table `localities`
--
ALTER TABLE `localities`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `locations`
--
ALTER TABLE `locations`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `slug` (`slug`),
  ADD KEY `locations_locality_id_22dd0b44_fk_localities_id` (`locality_id`);

--
-- Index pour la table `representations`
--
ALTER TABLE `representations`
  ADD PRIMARY KEY (`id`),
  ADD KEY `representations_show_id_a6832141_fk_shows_id` (`show_id`),
  ADD KEY `representations_fk_room_id` (`room_id`);

--
-- Index pour la table `reservations`
--
ALTER TABLE `reservations`
  ADD PRIMARY KEY (`id`),
  ADD KEY `reservations_user_id` (`user_id`),
  ADD KEY `reservations_representation_id` (`representation_id`);

--
-- Index pour la table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `role` (`role`);

--
-- Index pour la table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`id`),
  ADD KEY `rooms_fk_locations_id` (`location_id`);

--
-- Index pour la table `shows`
--
ALTER TABLE `shows`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `slug` (`slug`),
  ADD KEY `shows_location_id_a6832141_fk_locations_id` (`location_id`);

--
-- Index pour la table `types`
--
ALTER TABLE `types`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_role_user_id` (`user_id`),
  ADD KEY `user_role_role_id` (`role_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `artists`
--
ALTER TABLE `artists`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `artist_type`
--
ALTER TABLE `artist_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT pour la table `artist_type_show`
--
ALTER TABLE `artist_type_show`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT pour la table `localities`
--
ALTER TABLE `localities`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `locations`
--
ALTER TABLE `locations`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `representations`
--
ALTER TABLE `representations`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `reservations`
--
ALTER TABLE `reservations`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `shows`
--
ALTER TABLE `shows`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `types`
--
ALTER TABLE `types`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `user_role`
--
ALTER TABLE `user_role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `artist_type`
--
ALTER TABLE `artist_type`
  ADD CONSTRAINT `artist_type_artist_id_ 3060D1B6B7970CF8_fk_artists_id` FOREIGN KEY (`artist_id`) REFERENCES `artists` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `artist_type_type_id_ 3060D1B6C54C8C93 _fk_artists_id` FOREIGN KEY (`type_id`) REFERENCES `types` (`id`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `artist_type_show`
--
ALTER TABLE `artist_type_show`
  ADD CONSTRAINT `FK_9F6421FE7203D2A4` FOREIGN KEY (`artist_type_id`) REFERENCES `artist_type` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_9F6421FED0C1FC64` FOREIGN KEY (`show_id`) REFERENCES `shows` (`id`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `locations`
--
ALTER TABLE `locations`
  ADD CONSTRAINT `locations_locality_id_22dd0b44_fk_localities_id` FOREIGN KEY (`locality_id`) REFERENCES `localities` (`id`);

--
-- Contraintes pour la table `representations`
--
ALTER TABLE `representations`
  ADD CONSTRAINT `representations_fk_room_id` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `representations_show_id_a6832141_fk_shows_id` FOREIGN KEY (`show_id`) REFERENCES `shows` (`id`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `reservations`
--
ALTER TABLE `reservations`
  ADD CONSTRAINT `reservations_representation_id` FOREIGN KEY (`representation_id`) REFERENCES `representations` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `reservations_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `rooms`
--
ALTER TABLE `rooms`
  ADD CONSTRAINT `rooms_fk_locations_id` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`);

--
-- Contraintes pour la table `shows`
--
ALTER TABLE `shows`
  ADD CONSTRAINT `shows_location_id_a6832141_fk_locations_id` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`);

--
-- Contraintes pour la table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `user_role_role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `user_role_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
