package com.dena.service;

import java.util.List;

import com.dena.entities.CarteVisite;

public interface ICarteVisiteService {
	public CarteVisite save(CarteVisite carteVisite) ;
	public List<CarteVisite> findAll() ;
	public CarteVisite findById(long id) ;
	public void delete(long id) ;
	public CarteVisite update(long id,CarteVisite carteVisite);
	

	public List<CarteVisite> findBySiteWeb(String siteweb);

	public List<CarteVisite> findByTel(Integer tel);

}
