## App-Name
Forest-Service-App
## Project Description
Forest-Service App is an App that allows Rangers to track Animal sightings in the area.

Each time an animal species of either category is seen, a Sighting must be reported.

When wildlife is spotted, a Ranger submits a form to record a Sighting containing the following:id, Animal, Endangered Species, Location and Ranger name.
## Author's Information
This project was developed by Brian Karu.

Click on [Karuu](https://github.com/Karuu-01) to find the link to my Github Site.

## Demo
Here is a working live demo :https://java-forest-service.herokuapp.com/

## Set Up Instructions

## Database Set Up Instructions
- Run psql in the project terminal.
- Type the command: CREATE DATABASE wildlife_tracker;
- Navigate into the database by typing the command: \c wildlife_tracker;
Create tables by running following commands:
- 1.CREATE TABLE RangerAnimal (id serial PRIMARY KEY, name VARC
   HAR, tag INT, phone INT, email VARCHAR);
- 2.CREATE TABLE Wildlife (id serial PRIMARY KEY, name VARCHAR,health VARCHAR, age VARCHAR);
- 3.CREATE TABLE EndangeredAnimal(id serial PRIMARY KEY, name VARCHAR, health VARCHAR, age VARCHAR);
- 4.CREATE TABLE AnimalLocation (id serial PRIMARY KEY, name VARCHAR);
- 5.CREATE TABLE AnimalSighting (id SERIAL PRIMARY KEY, animalId INT, rangerId INT, locationId INT, time TIMESTAMP);
- Create a test database by typing the command: CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;

### To set up this project:

- Clone the repository by executing the following command in your terminal in the directory of your choice - git clone https://github.com/Karuu-01/Java-Forest-Service
- Navigate into the Forest-Service directory - cd Forest-Service
- Build project
- Build
- Run gradle build to build the project.

## Technologies Used:
- Java.
- Spark.
- Gradle.
- Maven.
- Bootstrap.
- JUnit.

## Contact Information
- Email : brian.karu.work@gmail.com
- Phone : +254 706844439

## License
[MIT](License) © Brian Karu