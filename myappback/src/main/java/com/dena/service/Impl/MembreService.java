package com.dena.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dena.entities.CV;
import com.dena.entities.Membre;
import com.dena.repositories.IMembreRepository;
import com.dena.service.IMembreService;


@Service
@Transactional
public class MembreService implements IMembreService{

	@Autowired
	private IMembreRepository membreRepository ;
	
	

	@Override
	public Membre save(Membre membre) {
		// TODO Auto-generated method stub
		return membreRepository.save(membre);
	}

	@Override
	public List<Membre> findAll() {
		// TODO Auto-generated method stub
		return membreRepository.findAll();
	}

	@Override
	public Membre findById(long id) {
		// TODO Auto-generated method stub
		return membreRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		membreRepository.delete(id);
		
	}

	public IMembreRepository getMembreRepository() {
		return membreRepository;
	}

	public void setMembreRepository(IMembreRepository membreRepository) {
		this.membreRepository = membreRepository;
	}

	@Override
	public Membre update(long id,Membre membre) {
		Membre x=membreRepository.findOne(id);
		x.setCivilite(membre.getCivilite());
		x.setEmail(membre.getEmail());
		x.setPassword(membre.getPassword());
		x.setSexe(membre.getSexe());
		return membreRepository.save(x);
	}

	@Override
	public List<Membre> findBySexe(Boolean sexe) {
		// TODO Auto-generated method stub
		return membreRepository.findBySexe(sexe);
	}



	@Override
	public List<Membre> findByCivilite(String civilite) {
		// TODO Auto-generated method stub
		return membreRepository.findByCivilite(civilite);
	}

	@Override
	public Membre findByEmail(String email) {
		// TODO Auto-generated method stub
		return membreRepository.findByEmail(email);
	}

	@Override
	public List<Membre> findByResetPasswordToken(String resetpasswordtoken) {
		// TODO Auto-generated method stub
		return membreRepository.findByResetPasswordToken(resetpasswordtoken);
	}

	@Override
	public Membre findByUserName(String username) {
		// TODO Auto-generated method stub
		return membreRepository.findByUserName(username);
	}

	@Override
	public List<CV> findCVMembre(Long idMembre) {
		// TODO Auto-generated method stub
		return membreRepository.findCVMembre(idMembre);
	}
	
}

