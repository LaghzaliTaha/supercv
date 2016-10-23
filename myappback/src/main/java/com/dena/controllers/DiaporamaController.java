package com.dena.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dena.entities.Diaporama;
import com.dena.service.IDiaporamaService;

@RestController
@RequestMapping("diaporama")
public class DiaporamaController {

	@Autowired
	private IDiaporamaService diaporamaService ;

	public IDiaporamaService getExperienceService() {
		return diaporamaService;
	}

	public void setIDiaporamaService(IDiaporamaService diaporamaService) {
		this.diaporamaService = diaporamaService;
	}

	@RequestMapping(
			method = {RequestMethod.GET,RequestMethod.POST}, 
			produces = { "application/json" }
			)
	public List<Diaporama> findAll(HttpServletResponse response) throws IOException{
		List<Diaporama> diaporama = null;
		try
		{
			diaporama = diaporamaService.findAll();
		}
		catch(Exception e)
		{
			response.sendError(404);
		}
		return diaporama ;
	}
} 
