package com.ioco.robotapocalypse.survivor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//This will reate a repository interface for the Survivor entity by extending JpaRepository. 
//This interface will provide CRUD operations for Survivor entity.

@Repository
public interface SurvivorRepository
    extends JpaRepository<Survivor, Integer>{
    
}
