package com.dena.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dena.entities.Abonnement;
import com.dena.repositories.IAbonnementRepository;
import com.dena.service.IAbonnementService;

@Service
@Transactional
public class AbonnementService implements IAbonnementService{

	@Autowired
	private IAbonnementRepository abonnementRepository ;
	
	

	@Override
	public Abonnement save(Abonnement abonnement) {
		// TODO Auto-generated method stub
		return abonnementRepository.save(abonnement);
	}

	@Override
	public List<Abonnement> findAll() {
		// TODO Auto-generated method stub
		return abonnementRepository.findAll();
	}

	@Override
	public Abonnement findById(long id) {
		// TODO Auto-generated method stub
		return abonnementRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		abonnementRepository.delete(id);
		
	}

	

	public IAbonnementRepository getAbonnementRepository() {
		return abonnementRepository;
	}

	public void setAbonnementRepository(IAbonnementRepository abonnementRepository) {
		this.abonnementRepository = abonnementRepository;
	}

	@Override
	public Abonnement update(long id,Abonnement abonnement) {
		Abonnement x=abonnementRepository.findOne(id);
		x.setTypeAbonnement(abonnement.getTypeAbonnement());
		return abonnementRepository.save(x);
	}

	@Override
	public List<Abonnement> findByTypeAbonnement(Integer typeabonnement) {
		// TODO Auto-generated method stub
		return abonnementRepository.findByTypeAbonnement(typeabonnement);
	}
	
}
