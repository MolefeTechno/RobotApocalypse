package com.ioco.robotapocalypse.survivor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Optional;

@RestController
@RequestMapping(path = "/survivors")
public class SurvivorController {
   
    private final SurvivorService survivorService;
    
    @Autowired
    public SurvivorController(SurvivorService survivorService) {
        this.survivorService = survivorService;
    }

    @GetMapping
	public List<Survivor> getSurvivors(){		
        return survivorService.getSurvivors();
	}

    @PostMapping()
    public ResponseEntity<Survivor> saveSurvivor(@RequestBody Survivor survivor) {
        Survivor savedSurvivor = survivorService.saveSurvivor(survivor);        
        return new ResponseEntity<>(savedSurvivor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Survivor> getSurvivorById(@PathVariable Integer id) {
        Optional<Survivor> optionalSurvivor = survivorService.getSurvivorById(id);

        return optionalSurvivor.map(survivor -> new ResponseEntity<>(survivor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}/update-location")
    public ResponseEntity<Survivor> updateSurvivorLocation(
            @PathVariable Integer id,
            @RequestParam double latitude,
            @RequestParam double longitude
    ) {
        try {
            Survivor updatedSurvivor = survivorService.updateSurvivorLocation(id, latitude, longitude);
            return new ResponseEntity<>(updatedSurvivor, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}/check-infection")
    public ResponseEntity<String> checkAndSetInfectionStatus(@PathVariable Survivor id) {
        try {
            survivorService.checkAndUpdateInfectionStatus(id);
            return new ResponseEntity<>("Infection status checked and updated.", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}

