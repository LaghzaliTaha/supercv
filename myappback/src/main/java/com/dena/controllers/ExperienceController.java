package com.dena.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dena.entities.Experience;
import com.dena.service.ICVService;
import com.dena.service.IExperienceService;

@RestController
@RequestMapping("experience")
public class ExperienceController {

	@Autowired
	private IExperienceService experienceService ;
	@Autowired
	private ICVService cvService;
	public IExperienceService getExperienceService() {
		return experienceService;
	}
	public void setIExperienceService(IExperienceService experienceService) {
		this.experienceService = experienceService;
	}

	@RequestMapping(method=RequestMethod.POST)
	public Experience save(@RequestBody Experience experience) {
		return experienceService.save(experience);
	}
	@RequestMapping(value="/{id}/add",method=RequestMethod.POST)
	public Experience save(@PathVariable Long id,@RequestBody Experience experience) {
		experience.setCv(cvService.findById(id));
		return experienceService.save(experience);
	}
	@RequestMapping(method=RequestMethod.GET,headers="Accept=application/json")
	public List<Experience> findAll() {
		return experienceService.findAll();
	}
	@RequestMapping(value="/find/{id}",method=RequestMethod.GET)
	public Experience findById(@PathVariable long id) {
		return experienceService.findById(id);
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		experienceService.delete(id);
	}
	 @RequestMapping( value="/update/{id}",method=RequestMethod.PUT)
	public Experience update(@ PathVariable long id,@RequestBody Experience experience) {
		return experienceService.update(id,experience);
	}
	 @RequestMapping(value="/deleteMission/{mission}/{id}",method=RequestMethod.DELETE)
		public void deleteMission(@PathVariable String mission,@PathVariable long id) {
		 Experience x=experienceService.findById(id);
		 List<String> list=x.getMission();
		 list.remove(mission);
		 x.setMission(list);
		 experienceService.save(x);
			
		}
	

}
