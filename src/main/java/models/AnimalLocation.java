package models;

import java.util.ArrayList;
import java.util.Objects;

public class AnimalLocation {
  private String name;
  private int id;
  private static ArrayList<AnimalLocation> instances = new ArrayList<>();

    public AnimalLocation(String name, int id) {
        this.name = name;
        this.id = id;
        instances.add(this);
        this.id=instances.size();
    }

    public static ArrayList<AnimalLocation> getAllInstances() {
        return  instances;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalLocation testLocation = (AnimalLocation) o;
        return id == testLocation.id && name.equals(testLocation.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
