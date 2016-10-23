package com.dena.service;


import java.util.List;

import com.dena.entities.Competence;
import com.dena.entities.Image;

public interface IImageService {

               public Image save(Image ex) ;
				public List<Image> findAll() ;
				public Image findById(long id) ;
				public void delete(long id) ;
				public Image update(long id,Image image);
					}

