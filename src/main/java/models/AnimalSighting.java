package models;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class AnimalSighting {

    private int id;
    private int animalId;
    private int rangerId;
    private int locationId;
    private Date date = new Date();
    private Timestamp time;

    public AnimalSighting(int animalId,  int rangerId, int locationId) {
        this.animalId = animalId;
        this.rangerId = rangerId;
        this.locationId =locationId;
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
}
