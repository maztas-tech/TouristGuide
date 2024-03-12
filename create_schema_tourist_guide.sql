CREATE SCHEMA tourist_guide_db;


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






