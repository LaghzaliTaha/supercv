package com.dena.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dena.entities.CarteVisite;
import com.dena.repositories.ICarteVisiteRepository;
import com.dena.service.ICarteVisiteService;

@Service
@Transactional
public class CarteVisiteService implements ICarteVisiteService{

	@Autowired
	private ICarteVisiteRepository carteVisiteRepository ;
	
	

	@Override
	public CarteVisite save(CarteVisite carteVisite) {
		// TODO Auto-generated method stub
		return carteVisiteRepository.save(carteVisite);
	}

	@Override
	public List<CarteVisite> findAll() {
		// TODO Auto-generated method stub
		return carteVisiteRepository.findAll();
	}

	@Override
	public CarteVisite findById(long id) {
		// TODO Auto-generated method stub
		return carteVisiteRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		carteVisiteRepository.delete(id);
		
	}

	


	public ICarteVisiteRepository getCarteVisiteRepository() {
		return carteVisiteRepository;
	}

	public void setCarteVisiteRepository(ICarteVisiteRepository carteVisiteRepository) {
		this.carteVisiteRepository = carteVisiteRepository;
	}

	@Override
	public CarteVisite update(long id,CarteVisite carteVisite) {
		CarteVisite x=carteVisiteRepository.findOne(id);
		x.setAdresse(carteVisite.getAdresse());
		x.setSiteWeb(carteVisite.getSiteWeb());
		x.setTel(carteVisite.getTel());
		return carteVisiteRepository.save(x);
	}

	


	@Override
	public List<CarteVisite> findBySiteWeb(String siteweb) {
		// TODO Auto-generated method stub
		return carteVisiteRepository.findBySiteWeb(siteweb);
	}

	@Override
	public List<CarteVisite> findByTel(Integer tel) {
		// TODO Auto-generated method stub
		return carteVisiteRepository.findByTel(tel);
	}
	
}

