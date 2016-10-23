package com.dena.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dena.entities.ItemCompetence;
import com.dena.repositories.IItemCompetenceRepository;
import com.dena.service.IItemCompetenceService;
@Service
@Transactional
public class ItemCompetenceService implements IItemCompetenceService{
	@Autowired
	private IItemCompetenceRepository itemCompetenceService;

	public IItemCompetenceRepository getItemCompetenceService() {
		return itemCompetenceService;
	}

	public void setItemCompetenceService(IItemCompetenceRepository itemCompetenceService) {
		this.itemCompetenceService = itemCompetenceService;
	}

	@Override
	public ItemCompetence save(ItemCompetence ex) {
		// TODO Auto-generated method stub
		return itemCompetenceService.save(ex);
	}

	@Override
	public List<ItemCompetence> findAll() {
		// TODO Auto-generated method stub
		return itemCompetenceService.findAll();
	}

	@Override
	public ItemCompetence findById(long id) {
		// TODO Auto-generated method stub
		return itemCompetenceService.findOne(id);
	}

	@Override
	public void delete(long id) {
		itemCompetenceService.delete(id);
		
	}

	@Override
	public ItemCompetence update(long id, ItemCompetence competence) {
		ItemCompetence x=itemCompetenceService.findOne(id);
		x.setTitreItemCompetence(competence.getTitreItemCompetence());
		x.setLogoItemCompetence(competence.getLogoItemCompetence());
		x.setLevelItemCompetence(competence.getLevelItemCompetence());
		
		
		return itemCompetenceService.save(x);
	}

}
