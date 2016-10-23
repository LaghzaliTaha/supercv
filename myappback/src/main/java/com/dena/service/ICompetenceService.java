package com.dena.service;



import java.util.List;

import com.dena.entities.Abonnement;
import com.dena.entities.Audio;
import com.dena.entities.Competence;

public interface ICompetenceService {


		public Competence save(Competence ex) ;
		public List<Competence> findAll() ;
		public Competence findById(long id) ;
		public void delete(long id) ;
		public Competence update(long id,Competence competence);
		

	}

