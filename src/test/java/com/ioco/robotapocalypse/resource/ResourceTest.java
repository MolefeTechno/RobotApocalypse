package com.ioco.robotapocalypse.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ioco.robotapocalypse.survivor.Survivor;

public class ResourceTest {
   
    private Resource resource;
    private Survivor survivor;
    
    @BeforeEach
    void setUp() {
        resource = new Resource("Water", 10, survivor);
        resource.setName("Water");
        resource.setQuantity(10);
        
        survivor = new Survivor();

        //survivor.setId(Integer.valueOf(1));
        survivor.setName("Molefe");

        //set other survivor properties in the survivor class
        resource.setSurvivorId(survivor);
       
    }

    @Test
    void testGetResourseNameAndQuantityAndSetResourceNameAndQuantityIfResourseNameAndQuantityIsNotSet(){
        assertEquals("Water", resource.getName());
        assertEquals(Integer.valueOf(10), resource.getQuantity());
    }
    @Test
    void getSurvivorAssociationWithAResource() {
        assertNotNull(resource.getSurvivorId());

        assertEquals("Molefe", resource.getSurvivorId().getName());
    }
}
