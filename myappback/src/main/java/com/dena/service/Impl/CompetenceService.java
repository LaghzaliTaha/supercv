package com.dena.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dena.entities.Competence;
import com.dena.repositories.ICompetenceRepository;
import com.dena.service.ICompetenceService ;

@Service
@Transactional
public class CompetenceService implements ICompetenceService{
	@Autowired
	private ICompetenceRepository competenceRepository ;
	@Override
	public Competence save(Competence ex) {
		// TODO Auto-generated method stub
		return competenceRepository.save(ex);
	}

	@Override
	public List<Competence> findAll() {
		// TODO Auto-generated method stub
		return competenceRepository.findAll();
	}

	@Override
	public Competence findById(long id) {
		// TODO Auto-generated method stub
		return competenceRepository.getOne(id);
	}

	@Override
	public void delete(long id) {
		competenceRepository.delete(id);
		
	}

	@Override
	public Competence update(long id, Competence competence) {
		// TODO Auto-generated method stub
		Competence x=competenceRepository.findOne(id);
		x.setDomaineCompetence(competence.getDomaineCompetence());
		return competenceRepository.save(x);
	}

}
