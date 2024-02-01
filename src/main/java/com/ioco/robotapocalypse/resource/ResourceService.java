package com.ioco.robotapocalypse.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ioco.robotapocalypse.survivor.Survivor;
import com.ioco.robotapocalypse.survivor.SurvivorRepository;


@Service
public class ResourceService {
   @Autowired
    private ResourceRepository resourceRepository;
	private SurvivorRepository survivorRepository;
    
    public ResourceService(ResourceRepository resourceRepository){
        this.resourceRepository = resourceRepository;
    }
	public Resource saveResources(Resource resource) {
        return resourceRepository.save(resource);
    }
    public List<Resource> getResources(){
		return resourceRepository.findAll();
	}
	
	public Resource addResourceToSurvivor(Resource resource, Integer survivorId) {
        
        Survivor survivor = survivorRepository.findById(survivorId)
                .orElseThrow(() -> new RuntimeException("Survivor not found with ID: " + survivorId));

        resource.setSurvivorId(survivor);
        return resourceRepository.save(resource);
    }
}
