package com.dena.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dena.entities.Portfolio;
import com.dena.service.IPortfolioService;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

	@Autowired
	private IPortfolioService portfolioService ;
	
	@RequestMapping(method=RequestMethod.POST)
	public Portfolio save(@RequestBody Portfolio role) {
		return portfolioService.save(role);
	}
	@RequestMapping(method=RequestMethod.GET)
	public List<Portfolio> findAll() {
		return portfolioService.findAll();
	}
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Portfolio findById(@PathVariable long id) {
		return portfolioService.findById(id);
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		portfolioService.delete(id);
	}
	 @RequestMapping( value="/update/{id}",method=RequestMethod.PUT)
	public Portfolio update(@ PathVariable long id,@RequestBody Portfolio portfolio) {
		return portfolioService.update(id,portfolio);
	}
  
	 @RequestMapping(value="/find/titreportfolio/{titreportfolio}",method=RequestMethod.GET)
		public List<Portfolio> findByTitrePortfolio(@PathVariable String titreportfolio) {
			return portfolioService.findByTitrePortfolio(titreportfolio);
		}
	 
	 @RequestMapping(value="/find/description/{description}",method=RequestMethod.GET)
		public List<Portfolio> findByDescription(@PathVariable String description) {
			return portfolioService.findByDescription(description);
		}
	

}
