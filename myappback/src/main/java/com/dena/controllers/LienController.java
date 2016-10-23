package com.dena.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dena.entities.Lien;
import com.dena.service.ICVService;
import com.dena.service.ILienService;

@RestController
@RequestMapping("/lien")

public class LienController {
	
       @Autowired
		private ILienService lienService ;
       @Autowired
       private ICVService cvService;
		
		public ILienService getLienService() {
		return lienService;
	}
	public void setLienService(ILienService lienService) {
		this.lienService = lienService;}

	
		public ICVService getIcvService() {
		return cvService;
	}
	public void setIcvService(ICVService icvService) {
		this.cvService = icvService;
	}
		@RequestMapping(method=RequestMethod.POST)
		public Lien save(@RequestBody Lien lien) {
			return lienService.save(lien);
		}
		@RequestMapping(method=RequestMethod.GET)
		public List<Lien> findAll() {
			return lienService.findAll();
		}
		@RequestMapping(value="/{id}/add",method=RequestMethod.POST)
		public Lien save(@PathVariable Long id,@RequestBody Lien lien) {
			lien.setCv(cvService.findById(id));
			return lienService.save(lien);
		}
		@RequestMapping(value="/{id}",method=RequestMethod.GET)
		public Lien findById(@PathVariable long id) {
			return lienService.findById(id);
		}
		@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
		public void delete(@PathVariable long id) {
			lienService.delete(id);
		}
		 @RequestMapping( value="/update/{id}",method=RequestMethod.PUT)
		public Lien update(@ PathVariable long id,@RequestBody Lien lien) {
			return lienService.update(id,lien);
		}
 
		
	}




