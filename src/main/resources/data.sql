CREATE SCHEMA if not exists tourist_guide_db;

USE tourist_guide_db;

CREATE TABLE city(
                     cityID INT auto_increment,
                     cityName VARCHAR(50) NOT NULL unique,
                     primary key(cityID)
);

CREATE TABLE tourist_attraction(
                                   touristID INT auto_increment,
                                   name VARCHAR(50) NOT NULL,
                                   description VARCHAR(255) NOT NULL,
                                   cityID INT,
                                   primary key(touristID),
                                   foreign key(cityID) references city(cityID)
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
INSERT INTO tourist_attraction (name, description)
VALUES
    ('Jellinge sten_H2', 'Vikinge historie_H2'),
    ('Rundetårn_H2', 'Overblik over København_H2'),
    ('Den lille havfrue_H2', 'Demonstrations plads_H2'),
    ('Tivoli_H2', 'Forlystelse_H2'),
    ('Kronborg_slot_H2', 'Demonstrations plads_H2');



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
    (2, 3),
    (3, 1),
    (3, 4);


INSERT INTO city(cityName)
VALUES
    ('København'),
    ('Jellinge'),
    ('Roskilde'),
    ('Aarhus');


UPDATE tourist_attraction SET cityID = 2 WHERE name = 'Jellinge sten_H2';
UPDATE tourist_attraction SET cityID = 1 WHERE name = 'Rundetårn_H2';
UPDATE tourist_attraction SET cityID = 1 WHERE name = 'Den lille havfrue_H2';