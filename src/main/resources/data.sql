CREATE SCHEMA if not exists tourist_guide_db;

USE tourist_guide_db;

CREATE TABLE tourist_attraction(
                                   touristID INT auto_increment,
                                   name VARCHAR(50) NOT NULL,
                                   description VARCHAR(255) NOT NULL,
                                   city VARCHAR(25) NOT NULL,
                                   primary key(touristID)
);

CREATE TABLE tag(
                    tagID INT auto_increment,
                    tagName VARCHAR(50) NOT NULL unique,
                    primary key(tagID)
);

CREATE TABLE tourist_attraction_tag(
                                       touristID INT,
                                       tagID INT,
                                       foreign key (touristID) references tourist_attraction(touristID),
                                       foreign key (tagID) references tag(tagID)

);

-- Inserting test data into tourist_attraction table
INSERT INTO tourist_attraction (name, description, city)
VALUES
    ('Jellinge sten_H2', 'Vikinge historie_H2', 'Jellinge_H2'),
    ('Rundetårn_H2', 'Overblik over København_H2', 'København_H2'),
    ('Den lille havfrue_H2', 'Demonstrations plads_H2', 'København_H2');



-- Inserting test data into tag table
INSERT INTO tag (tagName) VALUES
                              ('Børnevenlig_H2'),
                              ('Dyr_H2'),
                              ('Gebyr_H2'),
                              ('Gratis_H2'),
                              ('Historie_H2'),
                              ('Natur_H2'),
                              ('Vikinger_H2');

-- Inserting test data into tourist_attraction_tag table
-- Assigning tags to tourist attractions
INSERT INTO tourist_attraction_tag (touristID, tagID)
VALUES
    (1, 2),
    (1, 1),
    (1, 4),
    (1, 5),
    (1, 6),
    (2, 2),
    (2, 5),
    (2, 3);

