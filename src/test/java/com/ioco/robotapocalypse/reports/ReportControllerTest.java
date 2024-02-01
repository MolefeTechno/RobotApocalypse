package com.ioco.robotapocalypse.reports;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ioco.robotapocalypse.survivor.Survivor;
import com.ioco.robotapocalypse.survivor.SurvivorController;
import com.ioco.robotapocalypse.survivor.SurvivorService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
                new Survivor("Survivor1", 1, "Male", 35.0, -120.0, 0,false),
                new Survivor("Survivor2", 2, "Female", 40.0, -110.0, 0,false)
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
        Survivor inputSurvivor = new Survivor("TestSurvivor", 50, "male", 37.0, -122.0, 0,false);
        Survivor savedSurvivor = new Survivor("TestSurvivor", 50, "male", 37.0, -122.0, 0, false);

        when(survivorService.saveSurvivor(inputSurvivor)).thenReturn(savedSurvivor);

        // Act
        ResponseEntity<Survivor> responseEntity = survivorController.saveSurvivor(inputSurvivor);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(savedSurvivor, responseEntity.getBody());
    }

    @Test
    void getSurvivorById_shouldReturnSurvivorById() {
        // Arrange
        int survivorId = 1;
        Survivor expectedSurvivor = new Survivor("TestSurvivor", 50, "Male", 37.0, -122.0, 0, false);

        when(survivorService.getSurvivorById(survivorId)).thenReturn(Optional.of(expectedSurvivor));

        // Act
        ResponseEntity<Survivor> responseEntity = survivorController.getSurvivorById(survivorId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedSurvivor, responseEntity.getBody());
    }

    @Test
    void getSurvivorById_shouldReturnNotFoundForNonexistentSurvivor() {
        // Arrange
        int nonexistentSurvivorId = 999;

        when(survivorService.getSurvivorById(nonexistentSurvivorId)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Survivor> responseEntity = survivorController.getSurvivorById(nonexistentSurvivorId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void updateSurvivorLocation_shouldReturnUpdatedSurvivor() {
        // Arrange
        int survivorId = 1;
        double latitude = 38.0;
        double longitude = -123.0;
        Survivor updatedSurvivor = new Survivor("TestSurvivor", 45, "Male", latitude, longitude, 0, false);

        when(survivorService.updateSurvivorLocation(survivorId, latitude, longitude)).thenReturn(updatedSurvivor);

        // Act
        ResponseEntity<Survivor> responseEntity = survivorController.updateSurvivorLocation(survivorId, latitude, longitude);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(updatedSurvivor, responseEntity.getBody());
    }

    @Test
    void updateSurvivorLocation_shouldReturnNotFoundForNonexistentSurvivor() {
        // Arrange
        int nonexistentSurvivorId = 999;
        double latitude = 38.0;
        double longitude = -123.0;

        when(survivorService.updateSurvivorLocation(nonexistentSurvivorId, latitude, longitude))
                .thenThrow(new IllegalArgumentException("Survivor not found."));

        // Act
        ResponseEntity<Survivor> responseEntity = survivorController.updateSurvivorLocation(nonexistentSurvivorId, latitude, longitude);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

}
