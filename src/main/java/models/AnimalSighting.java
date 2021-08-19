package models;

import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class AnimalSighting {

    private int id;
    private String location;
    private String animalRangerName;
    private String name;
    private String health;
    private String age;
    private String species;
    private int animalId;
    private int rangerId;
    private int locationId;
    private Date date = new Date();
    private Timestamp time;

    public AnimalSighting(int animalId,  int rangerId, int locationId, String animalRangerName, String name, String health, String age, String species, String location) {
        this.animalId = animalId;
        this.rangerId = rangerId;
        this.locationId =locationId;
        this.animalRangerName = animalRangerName;
        this.age = age;
        this.health = health;
        this.species = species;
        this.location = location;
        this.name = name;
    }

    public AnimalSighting(int id, String location, String animalRangerName) {
        this.id = id;
        this.location = location;
        this.animalRangerName = animalRangerName;
    }

    public AnimalSighting(String name, String location, String animalRangerName) {
    }

    public static List<AnimalSighting> getAll() {
        String sql = "SELECT * FROM AnimalSighting";
        try (Connection con = DB.sql2o.open()){
            return con.createQuery(sql).executeAndFetch(AnimalSighting.class);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalSighting testSighting = (AnimalSighting) o;
        return id == testSighting.id && rangerId == testSighting.rangerId && animalId == testSighting.animalId && locationId == testSighting.locationId && date.equals(testSighting.date) && time.equals(testSighting.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rangerId, animalId, locationId, date, time);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public int getRangerId() {
        return rangerId;
    }

    public void setRangerId(int rangerId) {
        this.rangerId = rangerId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAnimalRangerName() {
        return animalRangerName;
    }

    public void setAnimalRangerName(String animalRangerName) {
        this.animalRangerName = animalRangerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
    

    public void save() {
    }
}
