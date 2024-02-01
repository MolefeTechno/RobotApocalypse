package com.ioco.robotapocalypse.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository 
 extends JpaRepository<Resource, Integer>{
    
}
