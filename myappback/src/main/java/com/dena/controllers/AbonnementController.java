package com.dena.controllers;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dena.entities.Abonnement;
import com.dena.service.IAbonnementService;


@RestController
@RequestMapping("/abonnement")
public class AbonnementController {

	@Autowired
	private IAbonnementService abonnementService ;
	@RequestMapping(value="/find/typeabonnement/{typeabonnement}",method=RequestMethod.GET)
	public List<Abonnement> findByTypeAbonnement(@PathVariable Integer typeabonnement) {
		return abonnementService.findByTypeAbonnement(typeabonnement);
	}
	@CrossOrigin(origins = "http://localhost:63342")
	@RequestMapping(method=RequestMethod.POST)
	public Abonnement save(@RequestBody Abonnement abonnement) {
		return abonnementService.save(abonnement);
	}
	@CrossOrigin(origins = "http://localhost:63342")
	@RequestMapping(method=RequestMethod.GET)
	public List<Abonnement> findAll() {
		return abonnementService.findAll();
	}
	@RequestMapping(value="/find/{id}",method=RequestMethod.GET)
	public Abonnement findById(@PathVariable long id) {
		return abonnementService.findById(id);
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		abonnementService.delete(id);
	}
	 @RequestMapping( value="/update/{id}",method=RequestMethod.PUT)
	public Abonnement update(@ PathVariable long id,@RequestBody Abonnement abonnement) {
		return abonnementService.update(id,abonnement);
	}

	

}