INSERT INTO `Utilisateur` (`username`, `password`) VALUES
('abdel', 'azerty');

INSERT INTO `Utilisateur` (`username`, `password`) VALUES
('franck', 'azerty');

INSERT INTO `Utilisateur` (`username`, `password`) VALUES
('sara', 'azerty');

INSERT INTO `Role` (`nom`) VALUES
('apprenant');

INSERT INTO `Role` (`nom`) VALUES
('formateur');

INSERT INTO `Role` (`nom`) VALUES
('administrateur');

INSERT INTO `Utilisateur_Role` (`Utilisateur_id`,`Role_id`) VALUES
(1,1);

INSERT INTO `Utilisateur_Role` (`Utilisateur_id`,`Role_id`) VALUES
(2,1);

INSERT INTO `Utilisateur_Role` (`Utilisateur_id`,`Role_id`) VALUES
(2,3);

INSERT INTO `Utilisateur_Role` (`Utilisateur_id`,`Role_id`) VALUES
(3,2);