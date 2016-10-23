package com.dena.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dena.entities.Video;
import com.dena.service.IVideoService;


@RestController
@RequestMapping("video")
public class VideoController {

     @Autowired
		private IVideoService videoService ;

		public IVideoService getCVService() {
			return videoService;
		}

		public void setIVideoService(IVideoService cvService) {
			this.videoService = cvService;
		}

		@RequestMapping(
				method = {RequestMethod.GET,RequestMethod.POST}, 
				produces = { "application/json" }
				)
		public List<Video> findAll(HttpServletResponse response) {
			List<Video> video = null;
			
				video = videoService.findAll();
			
		
			
			return video;
			
		}

	}




