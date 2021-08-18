package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WildlifeTest {

    @BeforeEach
    void setUp() throws Exception{
    }

    @AfterEach
    void tearDown() throws Exception{
    }

    @Test
    void GetObjectsInstantiatesCorrectly_true() {
        Wildlife testWildlife = setupWildlife();
        assertTrue(testWildlife instanceof Wildlife);
    }

    @Test
    void GetNameOfWildlifeAnimalInstantiatesCorrectly() {
        Wildlife testWildlife = setupWildlife();
        assertEquals("Elephant", testWildlife.getName());
    }

    @Test
    void GetHealthOfWildlifeAnimalInstantiatesCorrectly() {
        Wildlife testWildlife = setupWildlife();
        assertEquals("Okay", testWildlife.getHealth());
    }

    @Test
    void GetAgeOfWildlfieAnimalInstantiatesCoreectly_true() {
        Wildlife testWildlife = setupWildlife();
        assertEquals("Young", testWildlife.getAge());
    }

    public Wildlife setupWildlife(){
        return new Wildlife("Elephant", "Okay", "Young");
    }
}