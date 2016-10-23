package com.dena.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dena.entities.CV;
import com.dena.entities.Competence;
import com.dena.entities.Experience;
import com.dena.entities.Formation;
import com.dena.entities.InformationPersonnel;
import com.dena.entities.Language;
import com.dena.entities.Lien;
import com.dena.entities.Loisir;
import com.dena.entities.ThemeCV;
import com.dena.repositories.ICVRepository;
import com.dena.service.ICVService;


@Service
@Transactional
public class CVService implements ICVService{

	@Autowired
	private ICVRepository cvRepository ;
	
	

	@Override
	public CV save(CV ex) {
		// TODO Auto-generated method stub
		return cvRepository.save(ex);
	}

	@Override
	public List<CV> findAll() {
		// TODO Auto-generated method stub
		return cvRepository.findAll();
	}

	@Override
	public CV findById(long id) {
		// TODO Auto-generated method stub
		return cvRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		cvRepository.delete(id);
		
	}
	public ICVRepository getExperienceRepository() {
		return cvRepository;
	}

	public void setExperienceRepository(ICVRepository experienceRepository) {
		this.cvRepository = experienceRepository;
	}
	

	
	@Override
	public CV update(long id,CV cv) {
		CV x=cvRepository.findOne(id);
		x.setPhoto(cv.getPhoto());
		x.setDateNaissance(cv.getDateNaissance());
		x.setVille(cv.getVille());
		x.setCodePostal(cv.getCodePostal());
		x.setPays(cv.getPays());
		x.setPermis(cv.getPermis());
		x.setSituationProfessionnel(cv.getSituationProfessionnel());
		x.setSituationFamilial(cv.getSituationFamilial());
		x.setNom(cv.getNom());
		x.setPrenom(cv.getPrenom());
		x.setThemeCVs( cv.getThemeCVs());
		return cvRepository.save(x);
	}

	@Override
	public List<Experience> findExperiences(long idMembre,long idCv) {
		return cvRepository.findExperiences(idMembre,idCv);
	}
	

	@Override
	public List<Formation> findFormations(Long idMembre, Long idCv) {
		// TODO Auto-generated method stub
		return cvRepository.findFormations(idMembre, idCv);
	}

	@Override
	public List<Loisir> findLoisirs(Long idMembre, Long idCv) {
		// TODO Auto-generated method stub
		return cvRepository.findLoisirs(idMembre, idCv);
	}

	@Override
	public List<Lien> findLiens(Long idMembre, Long idCv) {
		// TODO Auto-generated method stub
		return cvRepository.findLiens(idMembre, idCv);
	}

	@Override
	public InformationPersonnel findInformationPersonnel(Long idMembre, Long idCv) {
		// TODO Auto-generated method stub
		return cvRepository.findInformationPersonnel(idMembre, idCv);
	}

	

	@Override
	public List<Competence> findCompetences(long idMembre, long idCv) {
		// TODO Auto-generated method stub
		return cvRepository.findCompetences(idMembre, idCv);
	}

	@Override
	public List<Language> findLanguages(Long idMembre, Long idCv) {
		// TODO Auto-generated method stub
		return cvRepository.findLanguages(idMembre, idCv);
	}


}


