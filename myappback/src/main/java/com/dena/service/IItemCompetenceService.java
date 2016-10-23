package com.dena.service;

import java.util.List;

import com.dena.entities.ItemCompetence;

public interface IItemCompetenceService {
	public ItemCompetence save(ItemCompetence ex) ;
	public List<ItemCompetence> findAll() ;
	public ItemCompetence findById(long id) ;
	public void delete(long id) ;
	public ItemCompetence update(long id,ItemCompetence competence);

}
