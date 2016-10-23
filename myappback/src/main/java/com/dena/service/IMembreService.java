package com.dena.service;

import java.util.List;

import com.dena.entities.CV;
import com.dena.entities.Membre;

public interface IMembreService {
	public Membre save(Membre membre) ;
	public List<Membre> findAll() ;
	public Membre findById(long id) ;
	public void delete(long id) ;
	public Membre update(long id,Membre membre);
	public List<Membre> findBySexe(Boolean sexe);
	public List<Membre> findByCivilite(String civilite);
	public Membre findByEmail(String email);
	public List<Membre> findByResetPasswordToken(String resetpasswordtoken);
	Membre findByUserName(String username);
	List<CV> findCVMembre( Long idMembre);


}

