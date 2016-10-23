package com.dena.service;

import java.util.List;

import com.dena.entities.ThemeCarte;

public interface IThemeCarteService {
	public ThemeCarte save(ThemeCarte themeCarte) ;
	public List<ThemeCarte> findAll() ;
	public ThemeCarte findById(long id) ;
	public void delete(long id) ;
	public ThemeCarte update(long id,ThemeCarte themeCarte);
	public List<ThemeCarte> findByNomThemeCarte(String nomthemecarte);
}
