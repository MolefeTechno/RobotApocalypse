package com.ioco.robotapocalypse.survivor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.Column;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import java.util.UUID;

import org.assertj.core.api.Assertions;

public class survivorTest {
   
    private Survivor survivor;
   
    @Column(nullable = false)
    private Integer contaminationReports;
    
    @Column(nullable = false)
    private Boolean isInfected = false;
  

    @BeforeEach
    void setUp() {
        survivor = new Survivor();
        survivor.setName("Molefe Sealanyane");
        survivor.setAge(21);
        survivor.setGender("male");
        survivor.setLatitude(100.00);
        survivor.setLongitude(100.00);  
        survivor.setContaminationReports(0);
    }

    @Test
    public void testSurvivorDetails(){
        assertEquals("Molefe Sealanyane", survivor.getName());
        assertEquals(Integer.valueOf(21), survivor.getAge());
        assertEquals("male", survivor.getGender());
        assertEquals(Double.valueOf(100.00), survivor.getLatitude());
        assertEquals(Double.valueOf(100.00), survivor.getLongitude());
        assertEquals(Integer.valueOf(0), survivor.getContaminationReports());
        assertEquals(Boolean.valueOf(false), survivor.getIsInfected());
    }
    @Test
    void testGetIdAndSetIdWhenIdIsSetThenIdIsRetrieved() {
        // Given
        Integer newId = 1;
        survivor.setId(newId);

        // When
        Integer retrievedId = survivor.getId();

        // Then
        Integer expected = 1;
        Assertions.assertThat(retrievedId).isEqualTo(expected);
    }

    @Test
    void testGetSurvivorNameAndSetSurvivorNameWhenSurvivorNameIsSetThenSurvivorNameIsRetrieved() {
        // Given
        String newSurvivorName = "New Survivor Name";
        survivor.setName(newSurvivorName);

        // When
        String retrievedSurvivorName = survivor.getName();

        // Then
        Assertions.assertThat(retrievedSurvivorName).isEqualTo(newSurvivorName);
    }
}
