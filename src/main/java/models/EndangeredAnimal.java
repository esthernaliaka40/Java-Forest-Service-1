package models;

import org.sql2o.Connection;

import java.util.List;
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

    public EndangeredAnimal(String name, String health, String age) {
        this.name = name;
        this.age = age;
        this.health = health;
    }

    public static List<EndangeredAnimal> all() {
        String sql = "SELECT * FROM wildlife_tracker";
        try(Connection conn = DB.sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(EndangeredAnimal.class);

        }
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

    public void save() {
    }
}
