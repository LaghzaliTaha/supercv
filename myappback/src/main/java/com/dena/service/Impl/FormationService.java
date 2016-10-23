package com.dena.service.Impl;

import com.dena.service.IFormationService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dena.entities.FichierProfessionel;
import com.dena.entities.Formation;
import com.dena.repositories.IFormationRepository;


@Service
@Transactional

public class FormationService implements IFormationService{

       @Autowired
		private IFormationRepository formationRepository ;
		
		

		@Override
		public Formation save(Formation formation) {
			// TODO Auto-generated method stub
			return formationRepository.save(formation);
		}

		@Override
		public List<Formation> findAll() {
			// TODO Auto-generated method stub
			return formationRepository.findAll();
		}

		@Override
		public Formation findById(long id) {
			// TODO Auto-generated method stub
			return formationRepository.findOne(id);
		}

		@Override
		public void delete(long id) {
			// TODO Auto-generated method stub
			formationRepository.delete(id);
			
		}

		

		public IFormationRepository getAbonnementRepository() {
			return formationRepository;
		}

		public void setAbonnementRepository(IFormationRepository formationRepository) {
			this.formationRepository = formationRepository;
		}
		
		@Override
		public Formation update(long id,Formation formation) {
			    Formation x=formationRepository.findOne(id);
			    x.setDateDebut(formation.getDateDebut());
			    x.setDateFin(formation.getDateFin());
			    x.setEtablissement(formation.getEtablissement());
			    x.setSpecialities(formation.getSpecialities());
			    x.setNomFormation(formation.getNomFormation());
			return formationRepository.save(x);
		}
		}
	

