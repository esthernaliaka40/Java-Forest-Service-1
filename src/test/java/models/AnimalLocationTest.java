package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalLocationTest {

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void GetsLocationInstantiatesCorrectly() {
        AnimalLocation testLocation = setupLocation();
        assertTrue(testLocation instanceof AnimalLocation);
    }

    @Test
    void GetsStringNameOfLocationCorrectly() {
        AnimalLocation testLocation = setupLocation();
        assertEquals("Zone A", testLocation.getName());
    }

    @Test
    void GetIdOfAreaOfLocation() {
        AnimalLocation testLocation = setupLocation();
        assertEquals(2, testLocation.getId());
    }

    public AnimalLocation setupLocation() {
        return new AnimalLocation("Zone A", 0);
    }
}