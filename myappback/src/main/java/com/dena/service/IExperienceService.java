package com.dena.service;

import java.util.List;

import com.dena.entities.Experience;

public interface IExperienceService {
	public Experience save(Experience ex) ;
	public List<Experience> findAll() ;
	public Experience findById(long id) ;
	public void delete(long id) ;
	public Experience update(long id,Experience competence);
}
