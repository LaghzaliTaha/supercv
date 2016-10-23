package com.dena.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dena.entities.ItemCompetence;
import com.dena.service.IItemCompetenceService;

@RestController
@RequestMapping("itemCompetence")
public class ItemCompetenceController {
	@Autowired
	private IItemCompetenceService itemCompetenceService ;

	public IItemCompetenceService getiItemCompetenceService() {
		return itemCompetenceService;
	}

	public void setiItemCompetenceService(IItemCompetenceService iItemCompetenceService) {
		this.itemCompetenceService = iItemCompetenceService;
	}
	@RequestMapping(method=RequestMethod.POST)
	public ItemCompetence save(@RequestBody ItemCompetence itemCompetence ) {
		return itemCompetenceService.save(itemCompetence);
	}
	@RequestMapping(method=RequestMethod.GET)
	public List<ItemCompetence> findAll() {
		return itemCompetenceService.findAll();
	}
	@RequestMapping(value="/find/{id}",method=RequestMethod.GET)
	public ItemCompetence findById(@PathVariable long id) {
		return itemCompetenceService.findById(id);
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		itemCompetenceService.delete(id);;
	}
	 @RequestMapping( value="/update/{id}",method=RequestMethod.PUT)
	public ItemCompetence update(@ PathVariable long id,@RequestBody ItemCompetence itemCompetence) {
		return itemCompetenceService.update(id, itemCompetence);
	}
}
