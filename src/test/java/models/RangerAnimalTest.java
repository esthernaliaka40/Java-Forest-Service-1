package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangerAnimalTest {

    @BeforeEach
    void setUp() throws Exception{
    }

    @AfterEach
    void tearDown() throws Exception{
    }

    @Test
    void GetInstantiatesObjectsTrueCorrectly() throws Exception{
        RangerAnimal testRanger = setupRanger();
        assertTrue(testRanger instanceof RangerAnimal);
    }

    @Test
    void GetRangerStringNameAndInstantiateCorrectly() throws Exception{
        RangerAnimal testRanger = setupRanger();
        assertEquals("Todd", testRanger.getName());
    }

    @Test
    void GetRangerIntTagNumberInstantiatesCorrectly() throws Exception{
        RangerAnimal testRanger = setupRanger();
        assertEquals(10, testRanger.getTag());
    }

    @Test
    void GetRangersContactNoAndInstantiatesCorrectly_true() {
        RangerAnimal testRanger = setupRanger();
        assertEquals(01003, testRanger.getPhone());
    }

    @Test
    void GetEmailOfRangerInstantiatesCorrectlyReturns_true() {
        RangerAnimal testRanger = setupRanger();
        assertEquals("todd@gmail.com", testRanger.getEmail());
    }

    public RangerAnimal setupRanger() {
        return new RangerAnimal("Todd", 10, 01003, "todd@gmail.com");
    }
}