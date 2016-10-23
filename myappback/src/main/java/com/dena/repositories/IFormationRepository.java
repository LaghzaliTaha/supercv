package com.dena.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.dena.entities.Formation;

public interface IFormationRepository  extends JpaRepository<Formation, Long>{
	
}


