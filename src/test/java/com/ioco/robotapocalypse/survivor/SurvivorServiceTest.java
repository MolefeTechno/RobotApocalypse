package com.ioco.robotapocalypse.survivor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

class SurvivorServiceTest {

    @Mock
    private SurvivorRepository survivorRepository;

    @InjectMocks
    private SurvivorService survivorService;

     @InjectMocks
    private SurvivorController survivorController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

   

    @Test
    void saveSurvivor_shouldReturnSavedSurvivor() {
        // Arrange
        Survivor inputSurvivor = new Survivor("TestSurvivor", 31, "male", 37.0, -122.0, 0,false);
        Survivor savedSurvivor = new Survivor("TestSurvivor", 31, "male", 37.0, -122.0, 0,false);

        when(survivorRepository.save(inputSurvivor)).thenReturn(savedSurvivor);

        // Act
        Survivor resultSurvivor = survivorService.saveSurvivor(inputSurvivor);

        // Assert
        assertNotNull(resultSurvivor);
        assertEquals(savedSurvivor, resultSurvivor);
    }

    @Test
    void getSurvivors_shouldReturnListOfSurvivors() {
        // Arrange
        List<Survivor> expectedSurvivors = Arrays.asList(
            new Survivor("TestSurvivor", 31, "male", 37.0, -122.0, 0,false),
            new Survivor("TestSurvivor", 31, "male", 37.0, -122.0, 0,false)
        );

        when(survivorRepository.findAll()).thenReturn(expectedSurvivors);

        // Act
        List<Survivor> actualSurvivors = survivorService.getSurvivors();

        // Assert
        assertEquals(expectedSurvivors, actualSurvivors);
    }

    @Test
    void getSurvivorById_shouldReturnOptionalSurvivor() {
        // Arrange
        int survivorId = 1;
        Survivor expectedSurvivor = new Survivor("TestSurvivor", 31, "male", 37.0, -122.0, 0,false);

        when(survivorRepository.findById(survivorId)).thenReturn(Optional.of(expectedSurvivor));

        // Act
        Optional<Survivor> actualSurvivor = survivorService.getSurvivorById(survivorId);

        // Assert
        assertTrue(actualSurvivor.isPresent());
        assertEquals(expectedSurvivor, actualSurvivor.get());
    }

    @Test
    void getSurvivorByIdShouldReturnEmptyOptionalForNonexistentSurvivor() {
        // Arrange
        int nonexistentSurvivorId = 999;

        when(survivorRepository.findById(nonexistentSurvivorId)).thenReturn(Optional.empty());

        // Act
        Optional<Survivor> actualSurvivor = survivorService.getSurvivorById(nonexistentSurvivorId);

        // Assert
        assertTrue(actualSurvivor.isEmpty());
    }
 

}
