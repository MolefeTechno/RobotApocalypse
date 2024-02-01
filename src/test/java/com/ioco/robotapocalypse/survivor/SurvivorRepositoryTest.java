package com.ioco.robotapocalypse.survivor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SurvivorRepositoryTest {

    @Autowired
    private SurvivorRepository survivorRepository;

    @Test
    void checkIfSaveSurvivoReturnSavedSurvivor() {
        // Arrange
        Survivor survivor = new Survivor("TestSurvivor", 31, "male", 37.0, -122.0, 0,false);

        // Act
        Survivor savedSurvivor = survivorRepository.save(survivor);

        // Assert
        assertNotNull(savedSurvivor.getId());
        assertEquals(survivor.getName(), savedSurvivor.getName());
        assertEquals(survivor.getLatitude(), savedSurvivor.getLatitude());
        assertEquals(survivor.getLongitude(), savedSurvivor.getLongitude());
    }

    @Test
    void checkIfFindByIdReturnsOptionalSurvivor() {
        // Arrange
        Survivor survivor = new Survivor("TestSurvivor", 31, "male", 337.0, -222.0, 0,false);
        Survivor savedSurvivor = survivorRepository.save(survivor);

        // Act
        Optional<Survivor> optionalSurvivor = survivorRepository.findById(savedSurvivor.getId());

        // Assert
        assertTrue(optionalSurvivor.isPresent());
        assertEquals(savedSurvivor, optionalSurvivor.get());
    }

    @Test
    void checkIfFindByIdReturnsEmptyOptionalForNonexistentSurvivor() {
        // Arrange
        int nonexistentSurvivorId = 999;

        // Act
        Optional<Survivor> optionalSurvivor = survivorRepository.findById(nonexistentSurvivorId);

        // Assert
        assertTrue(optionalSurvivor.isEmpty());
    }

    @Test
    void checkIfFindAllReturnsListOfSurvivors() {
        // Arrange
        Survivor survivor1 = new Survivor("Survivor1", 31, "male", 37.0, -122.0, 0,false);
        Survivor survivor2 = new Survivor("Survivor2", 36, "female", 37.0, -132.0, 0,false);
        survivorRepository.saveAll(List.of(survivor1, survivor2));

        // Act
        List<Survivor> allSurvivors = survivorRepository.findAll();

        // Assert
        assertEquals(2, allSurvivors.size());
    }


}
