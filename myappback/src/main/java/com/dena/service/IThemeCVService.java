package com.dena.service;


import java.util.List;

import com.dena.entities.ThemeCV;;
public interface IThemeCVService {



		public ThemeCV save(ThemeCV themeCV) ;
		public List<ThemeCV> findAll() ;
		public ThemeCV findById(long id) ;
		public void delete(long id) ;
		public ThemeCV update(long id,ThemeCV themeCarte);
	}

