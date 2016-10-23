package com.dena.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dena.entities.Competence;
import com.dena.entities.ItemCompetence;
import com.dena.service.ICVService;
import com.dena.service.ICompetenceService;
import com.dena.service.IItemCompetenceService;

@RestController
@RequestMapping("competence")
public class CompetenceController {

	@Autowired
	private ICompetenceService competenceService;
	@Autowired
	private ICVService cvService;
	@Autowired
	private IItemCompetenceService itemCompetenceService;

	public IItemCompetenceService getItemCompetenceService() {
		return itemCompetenceService;
	}

	public void setItemCompetenceService(IItemCompetenceService itemCompetenceService) {
		this.itemCompetenceService = itemCompetenceService;
	}

	

	public ICompetenceService getCompetenceService() {
		return competenceService;
	}

	public void setICompetenceService(ICompetenceService competenceService) {
		this.competenceService = competenceService;
	}

	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Competence> findAll() {
		return competenceService.findAll();
	}

	@RequestMapping(value = "/{id}/add", method = RequestMethod.POST)
	public Competence save(@PathVariable Long id, @RequestBody Competence competence) {
		Competence x=new Competence();
		x.setDomaineCompetence(competence.getDomaineCompetence());
		x.setCv(cvService.findById(id));
		Competence tx=competenceService.save(x);
		for (ItemCompetence ic : competence.getItemCompetences()) {
			ic.setCompetence(tx);
			itemCompetenceService.save(ic);
		}
	
		
		return competence;
	}

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public Competence findById(@PathVariable long id) {
		return competenceService.findById(id);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		Competence x=competenceService.findById(id);
		Collection<ItemCompetence> list=x.getItemCompetences();
		for (ItemCompetence itemCompetence : list) {
			itemCompetenceService.delete(itemCompetence.getIdItemCompetence());
		}
		
		competenceService.delete(id);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public Competence update(@PathVariable long id, @RequestBody Competence competence) {
		return competenceService.update(id, competence);
	}

}
