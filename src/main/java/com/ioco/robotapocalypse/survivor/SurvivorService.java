package com.ioco.robotapocalypse.survivor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SurvivorService {

	@Autowired
    private SurvivorRepository survivorRepository;
    
    public SurvivorService(SurvivorRepository survivorRepository){
        this.survivorRepository = survivorRepository;
    }
	public Survivor saveSurvivor(Survivor survivor) {
        return survivorRepository.save(survivor);
    }
    public List<Survivor> getSurvivors(){
		return survivorRepository.findAll();
	}

	public Optional<Survivor> getSurvivorById(Integer id) {
        return survivorRepository.findById(id);
    }

    public Survivor updateSurvivorLocation(Integer id, double latitude, double longitude) {
        Optional<Survivor> optionalSurvivor = survivorRepository.findById(id);

        if (optionalSurvivor.isPresent()) {
            Survivor survivor = optionalSurvivor.get();
            survivor.setLatitude(latitude);
            survivor.setLongitude(longitude);
            return survivorRepository.save(survivor);
        } else {
            // Handle the case when the survivor with the given id is not found
            throw new IllegalArgumentException("Survivor with ID " + id + " not found.");
        }
    }

	void checkAndUpdateInfectionStatus(Survivor nonexistentSurvivorId) {
        int contaminationReports = nonexistentSurvivorId.getContaminationReports();

        if (contaminationReports >= 3) {
            nonexistentSurvivorId.setIsInfected(true);
        }
    }
}
