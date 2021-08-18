package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EndangeredAnimalTest {

    @BeforeEach
    void setUp() throws Exception{
    }

    @AfterEach
    void tearDown() throws Exception{
    }

    @Test
    void GetObjectsInstantiatesCorrectly_true() {
        EndangeredAnimal testEndangered = setupEndangered();
        assertTrue(testEndangered instanceof EndangeredAnimal);
    }

    @Test
    void GetNameOfEndangeredAnimalInstantiatesStringNameCorrectly() {
        EndangeredAnimal testEndangered = setupEndangered();
        assertEquals("White Rhino", testEndangered.getName());
    }

    @Test
    void GetIdOfEndangeredAnimalInstantiatesCorrectly_true() {
        EndangeredAnimal testEndangered = setupEndangered();
        assertEquals(1, testEndangered.getId());
    }

    @Test
    void GetHealthOfEndangeredAnimalInstantiatesCorrectly_true() {
        EndangeredAnimal testEndangered = setupEndangered();
        assertEquals("Strong", testEndangered.getHealth());
    }

    @Test
    void GetAgeOfEndangeredAnimalInstantiatesCorrectly_true() {
        EndangeredAnimal testEndangered = setupEndangered();
        assertEquals("old", testEndangered.getAge());
    }

    public EndangeredAnimal setupEndangered() {
        return new EndangeredAnimal("White Rhino", 1, "Strong", "old");
    }
}