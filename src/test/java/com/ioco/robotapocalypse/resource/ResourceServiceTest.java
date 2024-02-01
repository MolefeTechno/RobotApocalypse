package com.ioco.robotapocalypse.resource;

import com.ioco.robotapocalypse.survivor.Survivor;
import com.ioco.robotapocalypse.survivor.SurvivorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ResourceServiceTest {

    @Mock
    private ResourceRepository resourceRepository;

    @Mock
    private SurvivorRepository survivorRepository;

    @InjectMocks
    private ResourceService resourceService;

    private Survivor survivor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveResources_shouldReturnSavedResource() {
        // Arrange
        Resource inputResource = new Resource("TestResource", 2, survivor);
        Resource savedResource = new Resource("TestResource", 2, survivor);

        when(resourceRepository.save(inputResource)).thenReturn(savedResource);

        // Act
        Resource resultResource = resourceService.saveResources(inputResource);

        // Assert
        assertEquals(savedResource, resultResource);
    }

    @Test
    void getResources_shouldReturnListOfResources() {
        // Arrange
        List<Resource> expectedResources = Arrays.asList(
            new Resource("Resource1", 2, survivor),
            new Resource("Resource2", 2, survivor)
        );

        when(resourceRepository.findAll()).thenReturn(expectedResources);

        // Act
        List<Resource> actualResources = resourceService.getResources();

        // Assert
        assertEquals(expectedResources, actualResources);
    }

    @Test
    void addResourceToSurvivor_shouldReturnAddedResource() {
        // Arrange
        Resource inputResource = new Resource("TestResource", 2, survivor);
        int survivorId = 1;
        Survivor survivor = new Survivor("TestSurvivor", 31, "male", 37.0, -122.0, 0,false);
        Resource addedResource = new Resource("TestResource", 2, survivor);

        when(survivorRepository.findById(survivorId)).thenReturn(Optional.of(survivor));
        when(resourceRepository.save(inputResource)).thenReturn(addedResource);

        // Act
        Resource resultResource = resourceService.addResourceToSurvivor(inputResource, survivorId);

        // Assert
        assertEquals(addedResource, resultResource);
    }

    @Test
    void addResourceToSurvivor_shouldThrowExceptionForNonexistentSurvivor() {
        // Arrange
        Resource inputResource = new Resource("TestResource", 2, survivor);
        int nonexistentSurvivorId = 999;

        when(survivorRepository.findById(nonexistentSurvivorId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(RuntimeException.class,
                () -> resourceService.addResourceToSurvivor(inputResource, nonexistentSurvivorId));
    }

}
