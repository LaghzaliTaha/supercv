package com.dena.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dena.entities.Paiement;
import com.dena.repositories.IPaiementRepository;
import com.dena.service.IPaiementService;


@Service
@Transactional
public class PaiementService implements IPaiementService{

	@Autowired
	private IPaiementRepository paiementRepository ;
	
	

	@Override
	public Paiement save(Paiement paiement ) {
		// TODO Auto-generated method stub
		return paiementRepository.save(paiement);
	}

	@Override
	public List<Paiement> findAll() {
		// TODO Auto-generated method stub
		return paiementRepository.findAll();
	}

	@Override
	public  Paiement findById(long id) {
		// TODO Auto-generated method stub
		return paiementRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		paiementRepository.delete(id);
		
	}

	





	

	public IPaiementRepository getPaiementRepository() {
		return paiementRepository;
	}

	public void setPaiementRepository(IPaiementRepository paiementRepository) {
		this.paiementRepository = paiementRepository;
	}

	@Override
	public  Paiement update(long id, Paiement paiement) {
		Paiement x=paiementRepository.findOne(id);
		x.setCode(paiement.getCode());
		x.setDatePaiement(paiement.getDatePaiement());
		x.setExpiration(paiement.getExpiration());
		x.setNumeroCarte(paiement.getNumeroCarte());
		return paiementRepository.save(x);
	}

	@Override
	public List<Paiement> findByDatePaiement(Date datepaiement) {
		// TODO Auto-generated method stub
		return paiementRepository.findByDatePaiement(datepaiement);
	}

	@Override
	public List<Paiement> findByExpiration(Date expiration) {
		// TODO Auto-generated method stub
		return paiementRepository.findByExpiration(expiration);
	}
	
}
