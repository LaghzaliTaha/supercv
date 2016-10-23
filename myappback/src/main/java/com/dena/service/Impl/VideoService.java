package com.dena.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dena.entities.Video;
import com.dena.repositories.IVideoRepository;
import com.dena.service.IVideoService;


@Service
@Transactional
public class VideoService implements IVideoService{

			@Autowired
			private IVideoRepository videoRepository ;
			
			

			@Override
			public Video save(Video ex) {
				// TODO Auto-generated method stub
				return videoRepository.save(ex);
			}

			@Override
			public List<Video> findAll() {
				// TODO Auto-generated method stub
				return videoRepository.findAll();
			}

			@Override
			public Video findById(long id) {
				// TODO Auto-generated method stub
				return videoRepository.findOne(id);
			}

			@Override
			public void delete(long id) {
				// TODO Auto-generated method stub
				videoRepository.delete(id);
				
			}
			public IVideoRepository getVideoRepository() {
				return videoRepository;
			}

			public void setExperienceRepository(IVideoRepository videoRepository) {
				this.videoRepository = videoRepository;
			}
			
			@Override
			public Video update(long id,Video video) {
				Video x=videoRepository.findOne(id);
				x.setPortfolio(video.getPortfolio());
				x.setUrl(video.getUrl());
				return videoRepository.save(x);
			}
		}




