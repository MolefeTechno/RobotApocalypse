package com.ioco.robotapocalypse.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/survivors/resources")

public class ResourceController {
    private final ResourceService resourceService;
    
    @Autowired
    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping
	public List<Resource> getResources(){
		
        return resourceService.getResources();

	}

     @PostMapping("/add-to-survivor/{survivorId}")
    public ResponseEntity<Resource> addResourceToSurvivor(
            @RequestBody Resource resource,
            @PathVariable Integer survivorId
    ) {
        Resource addedResource = resourceService.addResourceToSurvivor(resource, survivorId);
        return new ResponseEntity<>(addedResource, HttpStatus.CREATED);
    }

}

