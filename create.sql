CREATE DATABASE wildlife_tracker;
\c wildlife_tracker;
CREATE TABLE RangerAnimal (id serial PRIMARY KEY, name VARCHAR, tag INT, phone INT, email VARCHAR);
CREATE TABLE Wildlife (id serial PRIMARY KEY, name VARCHAR,health VARCHAR, age VARCHAR);
CREATE TABLE EndangeredAnimal(id serial PRIMARY KEY, name VARCHAR, health VARCHAR, age VARCHAR);
CREATE TABLE AnimalLocation (id serial PRIMARY KEY, name VARCHAR);
CREATE TABLE AnimalSighting (id SERIAL PRIMARY KEY, animalId INT, rangerId INT, locationId INT, time TIMESTAMP);
CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;