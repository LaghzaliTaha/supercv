package com.dena.service.Impl;

import com.dena.service.IFichierProfessionelService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dena.entities.FichierProfessionel;
import com.dena.repositories.IFichierProfessionelRepository;


@Service
@Transactional

public class FichierProfessionelService implements IFichierProfessionelService{

	

		@Autowired
		private IFichierProfessionelRepository fichierProfessionelRepository ;
		
		

		@Override
		public FichierProfessionel save(FichierProfessionel fichierprofessionel) {
			// TODO Auto-generated method stub
			return fichierProfessionelRepository.save(fichierprofessionel);
		}

		@Override
		public List<FichierProfessionel> findAll() {
			// TODO Auto-generated method stub
			return fichierProfessionelRepository.findAll();
		}

		@Override
		public FichierProfessionel findById(long id) {
			// TODO Auto-generated method stub
			return fichierProfessionelRepository.findOne(id);
		}

		@Override
		public void delete(long id) {
			// TODO Auto-generated method stub
			fichierProfessionelRepository.delete(id);
			
		}

		

		public IFichierProfessionelRepository getAbonnementRepository() {
			return fichierProfessionelRepository;
		}

		public void setAbonnementRepository(IFichierProfessionelRepository fichierProfessionelRepository) {
			this.fichierProfessionelRepository = fichierProfessionelRepository;
		}

		
		@Override
		public FichierProfessionel update(long id,FichierProfessionel fichierprofessionel) {
			    FichierProfessionel x=fichierProfessionelRepository.findOne(id);
			    x.setCv(fichierprofessionel.getCv());
			    x.setEmplacement(fichierprofessionel.getEmplacement());
			    x.setNomFichier(fichierprofessionel.getNomFichier());
			 
			 
			return fichierProfessionelRepository.save(x);
		}
	
}
