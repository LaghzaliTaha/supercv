package com.dena.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dena.entities.ThemeCarte;
import com.dena.repositories.IThemeCarteRepository;
import com.dena.service.IThemeCarteService;


@Service
@Transactional
public class ThemeCarteVisiteService  implements IThemeCarteService{

	@Autowired
	private IThemeCarteRepository themeCarteRepository ;
	
	

	@Override
	public ThemeCarte save(ThemeCarte themeCarte ) {
		// TODO Auto-generated method stub
		return themeCarteRepository.save(themeCarte);
	}

	@Override
	public List<ThemeCarte> findAll() {
		// TODO Auto-generated method stub
		return themeCarteRepository.findAll();
	}

	@Override
	public  ThemeCarte findById(long id) {
		// TODO Auto-generated method stub
		return themeCarteRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		themeCarteRepository.delete(id);
		
	}

	

	public IThemeCarteRepository getThemeCarteRepository() {
		return themeCarteRepository;
	}

	public void setThemeCarteRepository(IThemeCarteRepository themeCarteRepository) {
		this.themeCarteRepository = themeCarteRepository;
	}

	@Override
	public  ThemeCarte update(long id, ThemeCarte themeCarte) {
		ThemeCarte x=themeCarteRepository.findOne(id);
		return themeCarteRepository.save(x);
	}

	@Override
	public List<ThemeCarte> findByNomThemeCarte(String nomthemecarte) {
		// TODO Auto-generated method stub
		return themeCarteRepository.findByNomThemeCarte(nomthemecarte);
	}
	
}