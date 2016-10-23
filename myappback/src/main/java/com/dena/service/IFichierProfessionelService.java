package com.dena.service;

import java.util.List;


import com.dena.entities.FichierProfessionel;



public interface IFichierProfessionelService {

		public FichierProfessionel save(FichierProfessionel ex) ;
		public List<FichierProfessionel> findAll() ;
		public FichierProfessionel findById(long id) ;
		public void delete(long id) ;
		FichierProfessionel update(long id, FichierProfessionel abonnement);

	}
	

