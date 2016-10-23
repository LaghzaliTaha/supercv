package com.dena.service.Impl;

import com.dena.service.IInformationPersonnelService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.dena.repositories.IInformationPersonnelRepository;
import com.dena.entities.Image;
import com.dena.entities.InformationPersonnel;



@Service
@Transactional


public class InformationPersonnelService implements IInformationPersonnelService{
	
	@Autowired
	private IInformationPersonnelRepository informationPersonnelRepository ;
	
	

	@Override
	public InformationPersonnel save(InformationPersonnel informationPersonnel) {
		// TODO Auto-generated method stub
		return informationPersonnelRepository.save(informationPersonnel);
	}

	@Override
	public List<InformationPersonnel> findAll() {
		// TODO Auto-generated method stub
		return informationPersonnelRepository.findAll();
	}

	@Override
	public InformationPersonnel findById(long id) {
		// TODO Auto-generated method stub
		return informationPersonnelRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		informationPersonnelRepository.delete(id);
		
	}

	

	public IInformationPersonnelRepository getInformationPersonnelRepository() {
		return informationPersonnelRepository;
	}

	public void setImageRepository(IInformationPersonnelRepository imageRepository) {
		this.informationPersonnelRepository = imageRepository;
	}
	
	@Override
	public InformationPersonnel update(long id,InformationPersonnel infoperso) {
		InformationPersonnel x=informationPersonnelRepository.findOne(id);
		x.setMotCles(infoperso.getMotCles());
		x.setPresentation(infoperso.getPresentation());
		x.setTitreCV(infoperso.getTitreCV());
		return informationPersonnelRepository.save(x);
	}
	
	}




