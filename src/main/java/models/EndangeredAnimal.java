package models;

import java.util.Objects;

public class EndangeredAnimal {
    private String name;
    private int id;
    private String health;
    private String age;

    public EndangeredAnimal(String name, int id, String health, String age) {
        this.name = name;
        this.id = id;
        this.health = health;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EndangeredAnimal)) return false;
        EndangeredAnimal that = (EndangeredAnimal) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(health, that.health) && Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, health, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
