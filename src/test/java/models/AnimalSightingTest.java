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
    void GetNameInstantiatesCorrectlyWithStringReturn_true() {
        AnimalSighting testSighting = setupSighting();
        assertEquals("Lion", testSighting.getName());
    }

    @Test
    void GetLocationOfAnimalSpotted() {
        AnimalSighting testSighting = setupSighting();
        assertEquals("Zone A", testSighting.getLocation());
    }

    @Test
    void GetRangerNameInstantiatesCorrectly() {
        AnimalSighting testSighting = setupSighting();
        assertEquals("Rob", testSighting.getAnimalRangerName());
    }

    @Test
    void GetHealthOfSpottedAnimal() {
        AnimalSighting testSighting = setupSighting();
        assertEquals("Okay", testSighting.getHealth());
    }

    @Test
    void GetAgeOfAnimalSpotted () {
        AnimalSighting testSighting = setupSighting();
        assertEquals("newborn", testSighting.getAge());
    }

    @Test
    void GetSpeciesOfAnimalInstantiatesCorrectly() {
        AnimalSighting testSighting = setupSighting();
        assertEquals("endangered", testSighting.getSpecies());
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
        return new AnimalSighting("Robb", "Cheetah", "Okay", "Newborn", "Endangered", "Zone A");
    }
}