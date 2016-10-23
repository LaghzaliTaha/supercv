package com.dena.service;

import java.util.List;

import com.dena.entities.Language;

public interface ILanguageService {
	public Language save(Language ex) ;
	public List<Language> findAll() ;
	public Language findById(long id) ;
	public void delete(long id) ;
	public Language update(long id,Language language);

}
