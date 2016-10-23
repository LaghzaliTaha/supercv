package com.dena.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dena.entities.Experience;
import java.util.Date;
import java.util.List;

public interface IExperienceRepository extends JpaRepository<Experience, Long> {

	
}
