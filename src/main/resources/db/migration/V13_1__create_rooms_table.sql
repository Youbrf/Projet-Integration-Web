CREATE TABLE `rooms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `seats` int(11) DEFAULT NULL,
  `location_id` int(11) DEFAULT NULL,
  PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET= utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Index pour la table `rooms`
--
ALTER TABLE `rooms`
  ADD KEY `rooms_fk_locations_id` (`location_id`);

--
-- Contraintes pour la table `rooms`
--
ALTER TABLE `rooms`
  ADD CONSTRAINT `rooms_fk_locations_id` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`);
