package com.dena.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dena.entities.Formation;
import com.dena.service.ICVService;
import com.dena.service.IFormationService;


@RestController
@RequestMapping("formation")
public class FormationController {
	
			@Autowired
			private IFormationService formationService ;
			@Autowired
			private ICVService cvService;

		
			public IFormationService getIFormationService() {
				return formationService;
			}

			public void setIFichierProfessionelService(IFormationService formationService) {
				this.formationService = formationService;
			}

			@RequestMapping(value="/{id}/add",method=RequestMethod.POST)
			public Formation save(@PathVariable Long id,@RequestBody Formation formation) {
				formation.setCv(cvService.findById(id));
				return formationService.save(formation);
			}
			@RequestMapping(method=RequestMethod.GET,headers="Accept=application/json")
			public List<Formation> findAll() {
				return formationService.findAll();
			}
			@RequestMapping(value="/find/{id}",method=RequestMethod.GET)
			public Formation findById(@PathVariable long id) {
				return formationService.findById(id);
			}
			@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
			public void delete(@PathVariable long id) {
				formationService.delete(id);
			}
			 @RequestMapping( value="/update/{id}",method=RequestMethod.PUT)
			public Formation update(@ PathVariable long id,@RequestBody Formation formation) {
				return formationService.update(id,formation);
			}
			 @RequestMapping(value="/deleteSpecialite/{specialite}/{id}",method=RequestMethod.DELETE)
				public void deleteSpecialite(@PathVariable String specialite,@PathVariable long id) {
				 Formation x=formationService.findById(id);
				 List<String> list=x.getSpecialities();
				 list.remove(specialite);
				 x.setSpecialities(list);;
				 formationService.save(x);
					
				}

	}


