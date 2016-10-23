package com.dena.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dena.entities.Paiement;
import com.dena.service.IPaiementService;


@RestController
@RequestMapping("/paiement")
public class PaiementController {

	@Autowired
	private IPaiementService paiementService ;
	@RequestMapping(value="/find/datepaiement/{datepaiement}",method=RequestMethod.GET)
	public List<Paiement> findByDatePaiement(@PathVariable Date datepaiement) {
		return paiementService.findByDatePaiement(datepaiement);
	}
	@RequestMapping(value="/find/expiration/{expiration}",method=RequestMethod.GET)
	public List<Paiement> findByExpiration(@PathVariable Date expiration) {
		return paiementService.findByExpiration(expiration);
	}
	@RequestMapping(method=RequestMethod.POST)
	public Paiement save(@RequestBody Paiement paiement) {
		return paiementService.save(paiement);
	}
	@RequestMapping(method=RequestMethod.GET)
	public List<Paiement> findAll() {
		return paiementService.findAll();
	}
	@RequestMapping(value="/find/{id}",method=RequestMethod.GET)
	public Paiement findById(@PathVariable long id) {
		return paiementService.findById(id);
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		paiementService.delete(id);
	}
	 @RequestMapping( value="/update/{id}",method=RequestMethod.PUT)
	public Paiement update(@ PathVariable long id,@RequestBody Paiement paiement) {
		return paiementService.update(id,paiement);
	}

	

}