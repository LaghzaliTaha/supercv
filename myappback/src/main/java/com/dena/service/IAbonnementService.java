 package com.dena.service;

import java.util.List;

import com.dena.entities.Abonnement;

public interface IAbonnementService {
	public Abonnement save(Abonnement abonnement) ;
	public List<Abonnement> findAll() ;
	public Abonnement findById(long id) ;
	public void delete(long id) ;
	public Abonnement update(long id,Abonnement abonnement);
	List<Abonnement> findByTypeAbonnement(Integer typeabonnement);
}
