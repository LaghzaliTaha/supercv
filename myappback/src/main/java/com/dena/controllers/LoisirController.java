package com.dena.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dena.entities.Loisir;
import com.dena.service.ICVService;
import com.dena.service.ILoisirService;

@RestController
@RequestMapping("/loisir")

public class LoisirController {


		@Autowired
		private ILoisirService loisirService ;
		
		public ILoisirService getLoisirService() {
			return loisirService;
		}
		public void setLoisirService(ILoisirService loisirService) {
			this.loisirService = loisirService;
		}
		@Autowired
		private ICVService cvService;
		
	
		public ICVService getCvService() {
			return cvService;
		}
		public void setCvService(ICVService cvService) {
			this.cvService = cvService;
		}
		@RequestMapping(method=RequestMethod.POST)
		public Loisir save(@RequestBody Loisir loisir) {
			return loisirService.save(loisir);
		}
		@RequestMapping(method=RequestMethod.GET)
		public List<Loisir> findAll() {
			return loisirService.findAll();
		}
		@RequestMapping(value="/{id}/add",method=RequestMethod.POST)
		public Loisir save(@PathVariable Long id,@RequestBody Loisir loisir) {
			loisir.setCv(cvService.findById(id));
			return loisirService.save(loisir);
		}
		@RequestMapping(value="/{id}",method=RequestMethod.GET)
		public Loisir findById(@PathVariable long id) {
			return loisirService.findById(id);
		}
		@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
		public void delete(@PathVariable long id) {
			loisirService.delete(id);
		}
		 @RequestMapping( value="/update/{id}",method=RequestMethod.PUT)
		public Loisir update(@ PathVariable long id,@RequestBody Loisir loisir) {
			return loisirService.update(id,loisir);
		}
		 @RequestMapping(value="/deleteDetaille/{detaille}/{id}",method=RequestMethod.DELETE)
			public void deleteMission(@PathVariable String detaille,@PathVariable long id) {
			 Loisir x=loisirService.findById(id);
			 List<String> list=x.getDetailles();
			 list.remove(detaille);
			 x.setDetailles(list);;
			 loisirService.save(x);
				
			}
		

	}


