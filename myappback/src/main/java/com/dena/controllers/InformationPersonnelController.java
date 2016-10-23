package com.dena.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dena.entities.InformationPersonnel;
import com.dena.service.IInformationPersonnelService;


@RestController
@RequestMapping("informationpersonnel")

public class InformationPersonnelController {
	

		@Autowired
		private IInformationPersonnelService informationPersonnelService ;

		public IInformationPersonnelService getIInformationPersonnelService() {
			return informationPersonnelService;
		}

		public void setIInformationPersonnelService(IInformationPersonnelService informationPersonnelService) {
			this.informationPersonnelService = informationPersonnelService;
		}

		@RequestMapping(method=RequestMethod.POST)
		public InformationPersonnel save(@RequestBody InformationPersonnel informationPersonnel) {
			return informationPersonnelService.save(informationPersonnel);
		}
		@RequestMapping(method=RequestMethod.GET,headers="Accept=application/json")
		public List<InformationPersonnel> findAll() {
			return informationPersonnelService.findAll();
		}
		@RequestMapping(value="/find/{id}",method=RequestMethod.GET)
		public InformationPersonnel findById(@PathVariable long id) {
			return informationPersonnelService.findById(id);
		}
		@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
		public void delete(@PathVariable long id) {
			informationPersonnelService.delete(id);
		}
		 @RequestMapping( value="/update/{id}",method=RequestMethod.PUT)
		public InformationPersonnel update(@ PathVariable long id,@RequestBody InformationPersonnel informationPersonnel) {
			return informationPersonnelService.update(id,informationPersonnel);
		}

	}


