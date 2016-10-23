package com.dena.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dena.entities.ThemeCarte;
import com.dena.service.IThemeCarteService;


@RestController
@RequestMapping("/themecarte")
public class ThemeCarteController{

	@Autowired
	private IThemeCarteService themeCarteService ;
	@RequestMapping(value="/find/nomthemecarte/{nomthemecarte}",method=RequestMethod.GET)
	public List<ThemeCarte> findByNomThemeCarte(@PathVariable String nomthemecarte) {
		return themeCarteService.findByNomThemeCarte(nomthemecarte);
	}
	@RequestMapping(method=RequestMethod.POST)
	public ThemeCarte save(@RequestBody ThemeCarte themeCarte) {
		return themeCarteService.save(themeCarte);
	}
	@RequestMapping(method=RequestMethod.GET)
	public List<ThemeCarte> findAll() {
		return themeCarteService.findAll();
	}
	@RequestMapping(value="/find/{id}",method=RequestMethod.GET)
	public ThemeCarte findById(@PathVariable long id) {
		return themeCarteService.findById(id);
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		themeCarteService.delete(id);
	}
	 @RequestMapping( value="/update/{id}",method=RequestMethod.PUT)
	public ThemeCarte update(@ PathVariable long id,@RequestBody ThemeCarte themeCarte) {
		return themeCarteService.update(id,themeCarte);
	}

	

}