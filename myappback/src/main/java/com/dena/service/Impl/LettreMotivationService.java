package com.dena.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dena.entities.LettreMotivation;
import com.dena.repositories.ILettreMotivationRepository;
import com.dena.service.ILettreMotivationService;

@Service
@Transactional
public class LettreMotivationService implements ILettreMotivationService{

	@Autowired
	private ILettreMotivationRepository lettreMotivationRepository ;
	
	

	@Override
	public LettreMotivation save(LettreMotivation lettreMotivation) {
		// TODO Auto-generated method stub
		return lettreMotivationRepository.save(lettreMotivation);
	}

	@Override
	public List<LettreMotivation> findAll() {
		// TODO Auto-generated method stub
		return lettreMotivationRepository.findAll();
	}

	@Override
	public LettreMotivation findById(long id) {
		// TODO Auto-generated method stub
		return lettreMotivationRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		lettreMotivationRepository.delete(id);
		
	}

	



	public ILettreMotivationRepository getLettreMotivationRepository() {
		return lettreMotivationRepository;
	}

	public void setLettreMotivationRepository(ILettreMotivationRepository lettreMotivationRepository) {
		this.lettreMotivationRepository = lettreMotivationRepository;
	}

	@Override
	public LettreMotivation update(long id,LettreMotivation lettreMotivation) {
		LettreMotivation x=lettreMotivationRepository.findOne(id);
		x.setDomaine(lettreMotivation.getDomaine());
		x.setNomEmployeur(lettreMotivation.getNomEmployeur());
		x.setNomEntreprise(lettreMotivation.getNomEntreprise());
		x.setPost(lettreMotivation.getPost());
		x.setStatusEntreprise(lettreMotivation.getStatusEntreprise());
		x.setTypeCandidature(lettreMotivation.getTypeCandidature());
		x.setTypeContrat(lettreMotivation.getTypeContrat());
		x.setVillePost(lettreMotivation.getVillePost());
		return lettreMotivationRepository.save(x);
	}

	@Override
	public List<LettreMotivation> findByDomaine(String domaine) {
		// TODO Auto-generated method stub
		return lettreMotivationRepository.findByDomaine(domaine);
	}

	@Override
	public List<LettreMotivation> findByTypeContrat(String typecontrat) {
		// TODO Auto-generated method stub
		return lettreMotivationRepository.findByTypeContrat(typecontrat);
	}

	@Override
	public List<LettreMotivation> findByPost(String post) {
		// TODO Auto-generated method stub
		return lettreMotivationRepository.findByPost(post);
	}

	@Override
	public List<LettreMotivation> findByNomEntreprise(String nomentreprise) {
		// TODO Auto-generated method stub
		return lettreMotivationRepository.findByNomEntreprise(nomentreprise);
	}
	
}