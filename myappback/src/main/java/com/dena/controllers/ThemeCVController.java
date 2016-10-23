package com.dena.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dena.entities.ThemeCV ;
import com.dena.service.IThemeCVService;


@RestController
@RequestMapping("themecv")
public class ThemeCVController {

     @Autowired
		private IThemeCVService themeCVService ;

		@RequestMapping(method=RequestMethod.POST)
		public ThemeCV save(@RequestBody ThemeCV video) {
			return themeCVService.save(video);
		}
		@RequestMapping(method=RequestMethod.GET)
		public List<ThemeCV> findAll() {
			return themeCVService.findAll();
		}
		@RequestMapping(value="/find/{id}",method=RequestMethod.GET)
		public ThemeCV findById(@PathVariable long id) {
			return themeCVService.findById(id);
		}
		@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
		public void delete(@PathVariable long id) {
			themeCVService.delete(id);
		}
		 @RequestMapping( value="/update/{id}",method=RequestMethod.PUT)
		public ThemeCV update(@ PathVariable long id,@RequestBody ThemeCV typeCV) {
			return themeCVService.update(id,typeCV);
		}
		 
	
	

	}
