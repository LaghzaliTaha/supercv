package com.dena.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dena.entities.Language;
import com.dena.entities.Lien;
import com.dena.service.ICVService;
import com.dena.service.ILanguageService;

@RestController
@RequestMapping("language")
public class LanguageController {
	@Autowired
	private ILanguageService languageService ;
	@Autowired
	private ICVService cvService;

	
	public ILanguageService getLanguageService() {
		return languageService;
	}

	public void setLanguageService(ILanguageService languageService) {
		this.languageService = languageService;
	}
	@RequestMapping(value="/{id}/add",method=RequestMethod.POST)
	public Language save(@PathVariable Long id,@RequestBody Language language) {
		language.setCv(cvService.findById(id));
		return languageService.save(language);
	}
	
	
	public ICVService getCvService() {
		return cvService;
	}

	public void setCvService(ICVService cvService) {
		this.cvService = cvService;
	}

	@RequestMapping(method=RequestMethod.GET)
	public List<Language> findAll() {
		return languageService.findAll();
	}
	@RequestMapping(value="/find/{id}",method=RequestMethod.GET)
	public Language findById(@PathVariable long id) {
		return languageService.findById(id);
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		languageService.delete(id);
	}
	 @RequestMapping( value="/update/{id}",method=RequestMethod.PUT)
	public Language update(@ PathVariable long id,@RequestBody Language language) {
		return languageService.update(id,language);
	}

}
