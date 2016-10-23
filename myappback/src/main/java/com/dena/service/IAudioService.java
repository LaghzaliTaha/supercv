package com.dena.service;

import java.util.List;

import com.dena.entities.Abonnement;
import com.dena.entities.Audio;

public interface IAudioService {
	

		public Audio save(Audio ex) ;
		public List<Audio> findAll() ;
		public Audio findById(long id) ;
		public void delete(long id) ;
		public Audio update(long id,Audio audio);

	}


