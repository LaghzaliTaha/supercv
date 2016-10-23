package com.dena.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.dena.entities.CV;
import com.dena.entities.Competence;
import com.dena.entities.Experience;
import com.dena.entities.Formation;
import com.dena.entities.InformationPersonnel;
import com.dena.entities.Language;
import com.dena.entities.Lien;
import com.dena.entities.Loisir;



public interface ICVService {
	public CV save(CV ex) ;
	public List<CV> findAll() ;
	public CV findById(long id) ;
	public void delete(long id) ;
	public CV update(long id,CV competence);
	public List<Experience> findExperiences(long idMembre,long idCv);
	public List<Formation> findFormations(Long idMembre,Long idCv);
	public List<Loisir> findLoisirs(Long idMembre,Long idCv);
	public List<Lien> findLiens(Long idMembre,Long idCv);
	public InformationPersonnel findInformationPersonnel(Long idMembre,Long idCv);
	public List<Competence> findCompetences(long idMembre,long idCv);
	public List<Language> findLanguages(Long idMembre,Long idCv);




}
