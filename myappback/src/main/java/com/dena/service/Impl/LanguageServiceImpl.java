package com.dena.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dena.entities.Language;
import com.dena.repositories.ILanguageRepository;
import com.dena.service.ILanguageService;
@Service
@Transactional
public class LanguageServiceImpl implements ILanguageService{
	@Autowired
	private ILanguageRepository languageRepository ;
	public ILanguageRepository getLanguageRepository() {
		return languageRepository;
	}

	public void setLanguageRepository(ILanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public Language save(Language ex) {
		// TODO Auto-generated method stub
		return languageRepository.save(ex);
	}

	@Override
	public List<Language> findAll() {
		// TODO Auto-generated method stub
		return languageRepository.findAll();
	}

	@Override
	public Language findById(long id) {
		// TODO Auto-generated method stub
		return languageRepository.getOne(id);
	}

	@Override
	public void delete(long id) {
		languageRepository.delete(id);
		
	}

	@Override
	public Language update(long id, Language language) {
		// TODO Auto-generated method stub
		Language x=languageRepository.findOne(id);
		x.setLevel(language.getLevel());
		x.setLogo(language.getLogo());
		x.setNomLanguage(language.getNomLanguage());
		
		return languageRepository.save(x);
	}

}
