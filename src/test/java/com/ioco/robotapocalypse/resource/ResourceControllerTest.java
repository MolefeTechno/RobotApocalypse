package com.ioco.robotapocalypse.resource;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ioco.robotapocalypse.survivor.Survivor;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ResourceControllerTest {

    @Mock
    private ResourceService resourceService;

    @InjectMocks
    private ResourceController resourceController;

    Survivor survivor = new Survivor();
    
    public ResourceControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getResources_shouldReturnListOfResources() {
        // Arrange
        List<Resource> expectedResources = Arrays.asList(
            new Resource("Resource1", 2, survivor),
            new Resource("Resource2", 2, survivor)
        );

        when(resourceService.getResources()).thenReturn(expectedResources);

        // Act
        List<Resource> actualResources = resourceController.getResources();

        // Assert
        assertEquals(expectedResources, actualResources);
    }

    @Test
    void addResourceToSurvivor_shouldReturnAddedResource() {
        // Arrange
        Resource inputResource = new Resource("TestResource", 2, survivor);
        int survivorId = 1;
        Resource addedResource = new Resource("TestResource", 2, survivor);

        when(resourceService.addResourceToSurvivor(inputResource, survivorId)).thenReturn(addedResource);

        // Act
        ResponseEntity<Resource> responseEntity = resourceController.addResourceToSurvivor(inputResource, survivorId);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(addedResource, responseEntity.getBody());
    }

}
