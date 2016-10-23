package com.dena.controllers;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dena.entities.Experience;
import com.dena.entities.FichierProfessionel;
import com.dena.service.IExperienceService;
import com.dena.service.IFichierProfessionelService;

@RestController
@RequestMapping("fichierprofesstionel")

public class FichierProfessionelController {

		@Autowired
		private IFichierProfessionelService fichierProfesstionelService ;

		public IFichierProfessionelService getFichierProfessionelService() {
			return fichierProfesstionelService;
		}

		public void setIFichierProfessionelService(IFichierProfessionelService fichierProfesstionelService) {
			this.fichierProfesstionelService = fichierProfesstionelService;
		}

		@RequestMapping(
				method = {RequestMethod.GET,RequestMethod.POST}, 
				produces = { "application/json" }
				)
		public List<FichierProfessionel> findAll(HttpServletResponse response) throws IOException{
			List<FichierProfessionel> fichierprofesstionel = null;
			try
			{
				fichierprofesstionel = fichierProfesstionelService.findAll();
			}
			catch(Exception e)
			{
				response.sendError(404);
			}
			return fichierprofesstionel;
			
		}

}
