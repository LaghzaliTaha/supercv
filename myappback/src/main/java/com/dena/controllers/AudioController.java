package com.dena.controllers;



import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dena.entities.Audio;
import com.dena.service.IAudioService;


@RestController
@RequestMapping("/audio")
public class AudioController {

        @Autowired
		private IAudioService audioService ;
		
		@RequestMapping(method=RequestMethod.POST)
		public Audio save(@RequestBody Audio audio) {
			return audioService.save(audio);
		}
		@RequestMapping(method=RequestMethod.GET)
		public List<Audio> findAll() {
			return audioService.findAll();
		}
		@RequestMapping(value="/{id}",method=RequestMethod.GET)
		public Audio findById(@PathVariable long id) {
			return audioService.findById(id);
		}
		@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
		public void delete(@PathVariable long id) {
			audioService.delete(id);
		}
		 @RequestMapping( value="/update/{id}",method=RequestMethod.PUT)
		public Audio update(@ PathVariable long id,@RequestBody Audio audio) {
			return audioService.update(id,audio);
		}
  
		

	}

