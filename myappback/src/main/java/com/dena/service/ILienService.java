package com.dena.service;

import java.util.List;

import com.dena.entities.Lien ;

public interface ILienService {


		public Lien save(Lien mail) ;
		public List<Lien> findAll() ;
		public Lien findById(long id) ;
		public void delete(long id) ;
		public Lien update(long id,Lien mail);
	}

