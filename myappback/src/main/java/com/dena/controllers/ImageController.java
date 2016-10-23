package com.dena.controllers;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.dena.entities.Image;
import com.dena.service.IImageService;


@RestController
@RequestMapping("image")


public class ImageController {
	
	@Autowired
	private IImageService imageService ;

	public IImageService getIImageService() {
		return imageService;
	}

	public void setIImageService(IImageService imageService) {
		this.imageService = imageService;
	}

	@RequestMapping(
			method = {RequestMethod.GET,RequestMethod.POST}, 
			produces = { "application/json" }
			)
	public List<Image> findAll(HttpServletResponse response) {
		List<Image> image = null;
		
			image = imageService.findAll();
	
		return image;
		
	}

}


