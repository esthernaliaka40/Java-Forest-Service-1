package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalSightingTest {

    @BeforeEach
    void setUp() throws Exception{
    }

    @AfterEach
    void tearDown() throws Exception{
    }

    @Test
    void GetAndInstantiatesAllObjectsTrueAndCorrectly() {
        AnimalSighting testSighting = setupSighting();
        assertTrue(testSighting instanceof AnimalSighting);
    }

    @Test
    void GetRangerIdInstantiatesCorrectly_int() {
        AnimalSighting testSighting = setupSighting();
        assertEquals(1, testSighting.getRangerId());
    }

    @Test
    void GetAnimalWhereaboutsByIdReturnsCorrectly() {
        AnimalSighting testSighting = setupSighting();
        assertEquals(1, testSighting.getAnimalId());
    }

    @Test
    void GetLocationOfAnimalByIdReturnsCorrectly() {
        AnimalSighting testSighting = setupSighting();
        assertEquals(1, testSighting.getLocationId());
    }

    public AnimalSighting setupSighting() {
        return new AnimalSighting(1,1,1);
    }
}