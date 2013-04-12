DROP TABLE Arrangorer;

CREATE TABLE Arrangorer (
id DOUBLE precision not null auto_increment unique,
name VARCHAR(50),
phone VARCHAR(25),
email VARCHAR(50),
primary key (id)
);
