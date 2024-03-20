CREATE SCHEMA IF NOT EXISTS tourist_guide_db;


DROP TABLE IF EXISTS tourist_guide_db.tourist_attraction;

CREATE TABLE tourist_guide_db.tourist_attraction(
                                   touristID INT auto_increment,
                                   name VARCHAR(50) NOT NULL,
                                   description VARCHAR(255) NOT NULL,
                                   city VARCHAR(25) NOT NULL,
                                   primary key(touristID)
);

INSERT INTO tourist_guide_db.tourist_attraction (name, description, city)
VALUES
    ("Jellinge sten_H2", "Vikinge historie_H2", "Jellinge_H2"),
    ("Rundetårn_H2", "Overblik over København_H2", "København_H2"),
    ("Den lille havfrue_H2", "Demonstrations plads_H2", "København_H2");


DROP TABLE IF EXISTS tourist_guide_db.tag;

CREATE TABLE tourist_guide_db.tag(
                    tagID INT auto_increment,
                    tagName VARCHAR(50) NOT NULL unique,
                    primary key(tagID)
);

INSERT INTO tourist_guide_db.tag (tagName)
VALUES
    ("Børnevenlig_H2"),
    ("Dyr_H2"),
    ("Gebyr_H2"),
    ("Gratis_H2"),
    ("Historie_H2"),
    ("Natur_H2"),
    ("Vikinger_H2");


DROP TABLE IF EXISTS tourist_guide_db.tourist_attraction_tag;

CREATE TABLE tourist_guide_db.tourist_attraction_tag(
                                       touristID INT,
                                       tagID INT,
                                       foreign key (touristID) references tourist_attraction(touristID),
                                       foreign key (tagID) references tag(tagID)

);

INSERT INTO tourist_guide_db.tourist_attraction_tag (touristID, tagID)
VALUES
    (1, 2),
    (1, 1),
    (1, 4),
    (1, 5),
    (1, 6),
    (2, 2),
    (2, 5),
    (2, 3);