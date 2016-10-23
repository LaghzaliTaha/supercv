package com.dena.service.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dena.entities.CV;
import com.dena.entities.Diaporama;
import com.dena.repositories.IDiaporamaRepository;
import com.dena.service.IDiaporamaService;

@Service
@Transactional
public class DiaporamaService implements IDiaporamaService{

	@Autowired
	private IDiaporamaRepository diaporamaRepository ;
	
	

	@Override
	public Diaporama save(Diaporama ex) {
		// TODO Auto-generated method stub
		return diaporamaRepository.save(ex);
	}

	@Override
	public List<Diaporama> findAll() {
		// TODO Auto-generated method stub
		return diaporamaRepository.findAll();
	}

	@Override
	public Diaporama findById(long id) {
		// TODO Auto-generated method stub
		return diaporamaRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		diaporamaRepository.delete(id);
		
	}
	public IDiaporamaRepository getDiaporamaRepository() {
		return diaporamaRepository;
	}

	public void setDiaporamaRepository(IDiaporamaRepository diaporamaRepository) {
		this.diaporamaRepository = diaporamaRepository;
	}
	
	@Override
	public Diaporama update(long id,Diaporama diaporama) {
		Diaporama x=diaporamaRepository.findOne(id);
		x.setUrl(diaporama.getUrl());
		x.setPortfolio(diaporama.getPortfolio());	
		return diaporamaRepository.save(x);
	}
}

