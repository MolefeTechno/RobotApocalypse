package com.ioco.robotapocalypse.resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ioco.robotapocalypse.survivor.Survivor;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class ResourceRepositoryTest {

    @Autowired
    private ResourceRepository resourceRepository;
    Survivor survivor = new Survivor();
    @Test
    void saveResource_shouldReturnSavedResource() {
        // Arrange
        Resource inputResource = new Resource("TestResource", 2, survivor);
        Resource savedResource = resourceRepository.save(inputResource);

        // Act
        Resource resultResource = resourceRepository.findById(savedResource.getId()).orElse(null);

        // Assert
        assertEquals(savedResource, resultResource);
    }

    @Test
    void findAll_shouldReturnListOfResources() {
        // Arrange
        List<Resource> expectedResources = Arrays.asList(
            new Resource("Resource1", 2, survivor),
            new Resource("Resource2", 2, survivor)
        );

        resourceRepository.saveAll(expectedResources);

        // Act
        List<Resource> actualResources = resourceRepository.findAll();

        // Assert
        assertEquals(expectedResources, actualResources);
    }

}
