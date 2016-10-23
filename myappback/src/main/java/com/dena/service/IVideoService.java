package com.dena.service;


import java.util.List;

import com.dena.entities.Video ;
public interface IVideoService {



			public Video save(Video typeCV) ;
			public List<Video> findAll() ;
			public Video findById(long id) ;
			public void delete(long id) ;
			public Video update(long id,Video video);
		}

