DROP TABLE IF EXISTS utilisateur;
DROP TABLE IF EXISTS book;
CREATE TABLE utilisateur
(
    id_user INT AUTO_INCREMENT PRIMARY KEY,
    nom     VARCHAR(255),
    pseudo  VARCHAR(255),
    mdp     VARCHAR(255),
    roles   VARCHAR(255)
);

CREATE TABLE book
(
    id_book INT AUTO_INCREMENT PRIMARY KEY,
    title     VARCHAR(255),
    description  VARCHAR(255),
    nb_pages     INT
);


