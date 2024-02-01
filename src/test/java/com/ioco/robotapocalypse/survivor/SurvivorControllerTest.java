package com.ioco.robotapocalypse.survivor;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SurvivorControllerTest {

    @Mock
    private SurvivorService survivorService;

    @InjectMocks
    private SurvivorController survivorController;

    public SurvivorControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getSurvivors_shouldReturnListOfSurvivors() {
        // Arrange
        List<Survivor> expectedSurvivors = Arrays.asList(
            new Survivor("TestSurvivor", 31, "male", 37.0, -122.0, 0,false),
            new Survivor("TestSurvivor2", 32, "Female", 37.0, -122.0, 0, false)
        );

        when(survivorService.getSurvivors()).thenReturn(expectedSurvivors);

        // Act
        List<Survivor> actualSurvivors = survivorController.getSurvivors();

        // Assert
        assertEquals(expectedSurvivors, actualSurvivors);
    }

    @Test
    void saveSurvivor_shouldReturnSavedSurvivor() {
        // Arrange
        Survivor inputSurvivor = new Survivor("TestSurvivor", 31, "male", 37.0, -122.0, 0,false);
        Survivor savedSurvivor = new Survivor("TestSurvivor", 31, "male", 37.0, -122.0, 0,false);

        when(survivorService.saveSurvivor(inputSurvivor)).thenReturn(savedSurvivor);

        // Act
        ResponseEntity<Survivor> responseEntity = survivorController.saveSurvivor(inputSurvivor);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(savedSurvivor, responseEntity.getBody());
    }

    

}
