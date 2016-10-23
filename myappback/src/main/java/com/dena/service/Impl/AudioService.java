package com.dena.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dena.entities.Audio ;
import com.dena.repositories.IAudioRepository;
import com.dena.service.IAudioService;

@Service
@Transactional
public class AudioService implements IAudioService {

		@Autowired
		private IAudioRepository audioRepository ;
		
		

		@Override
		public Audio save(Audio abonnement) {
			// TODO Auto-generated method stub
			return audioRepository.save(abonnement);
		}

		@Override
		public List<Audio> findAll() {
			// TODO Auto-generated method stub
			return audioRepository.findAll();
		}

		@Override
		public Audio findById(long id) {
			// TODO Auto-generated method stub
			return audioRepository.findOne(id);
		}

		@Override
		public void delete(long id) {
			// TODO Auto-generated method stub
			audioRepository.delete(id);
			
		}

		

		public IAudioRepository getAudioRepository() {
			return audioRepository;
		}

		public void setAudioRepository(IAudioRepository abonnementRepository) {
			this.audioRepository = abonnementRepository;
		}

		@Override
		public Audio update(long id,Audio audio) {
			Audio x=audioRepository.findOne(id);
			x.setUrl(audio.getUrl());
			x.setEmplacement(audio.getEmplacement());
			return audioRepository.save(x);
		}
		
	}


