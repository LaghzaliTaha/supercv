package com.dena.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dena.entities.Document;
import com.dena.entities.Image;
import com.dena.repositories.IImageRepository;
import com.dena.service.IImageService;

@Service
@Transactional


public class ImageService implements IImageService {

         	@Autowired
			private IImageRepository imageRepository ;
			
			

			@Override
			public Image save(Image image) {
				// TODO Auto-generated method stub
				return imageRepository.save(image);
			}

			@Override
			public List<Image> findAll() {
				// TODO Auto-generated method stub
				return imageRepository.findAll();
			}

			@Override
			public Image findById(long id) {
				// TODO Auto-generated method stub
				return imageRepository.findOne(id);
			}

			@Override
			public void delete(long id) {
				// TODO Auto-generated method stub
				imageRepository.delete(id);
				
			}

			

			public IImageRepository getImageRepository() {
				return imageRepository;
			}

			public void setImageRepository(IImageRepository imageRepository) {
				this.imageRepository = imageRepository;
			}
			@Override
			public Image update(long id,Image image) {
				Image x=imageRepository.findOne(id);
				x.setEmplacement(image.getEmplacement());
				x.setPotfolio(image.getPotfolio());
				x.setUrl(image.getUrl());
				return imageRepository.save(x);
			}
			}
		
	
	
	

