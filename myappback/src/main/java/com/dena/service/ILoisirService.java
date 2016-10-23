package com.dena.service;

import java.util.List;

import com.dena.entities.Loisir ;

public interface ILoisirService {

			public Loisir save(Loisir loisir) ;
			public List<Loisir> findAll() ;
			public Loisir findById(long id) ;
			public void delete(long id) ;
			public Loisir update(long id,Loisir mail);
		}
	

