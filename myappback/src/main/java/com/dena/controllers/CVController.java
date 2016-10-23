package com.dena.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dena.entities.CV;
import com.dena.entities.Competence;
import com.dena.entities.Experience;
import com.dena.entities.Formation;
import com.dena.entities.InformationPersonnel;
import com.dena.entities.ItemCompetence;
import com.dena.entities.Language;
import com.dena.entities.Lien;
import com.dena.entities.Loisir;
import com.dena.entities.Membre;
import com.dena.entities.ThemeCV;
import com.dena.service.ICVService;
import com.dena.service.IInformationPersonnelService;
import com.dena.service.ILanguageService;
import com.dena.service.IMembreService;
import com.dena.service.IThemeCVService;


@RestController
@RequestMapping("CV")
public class CVController {
	
	@Autowired
	private ICVService cvService ;

	@Autowired
	private IMembreService membreService ;

	@Autowired
	private IThemeCVService themeCVService ;
	@Autowired
	private IInformationPersonnelService informationPersonnelService;
	@Autowired
	private ILanguageService languageService;
	
	
	
	public ICVService getCvService() {
		return cvService;
	}
	public void setCvService(ICVService cvService) {
		this.cvService = cvService;
	}
	@RequestMapping(value="/{idmembre}/{idtheme}",method=RequestMethod.POST)
	public Long save(@PathVariable long idmembre ,@PathVariable long idtheme) {
		CV cv=new CV("Nom","Prenom","img/icone-profil.jpeg",new Date(),"Ville","Code Postal","Pays",false,"SituationProfessionel","Sitiation familial");
		
		Membre mb=membreService.findById(idmembre);
		ThemeCV themeCV=themeCVService.findById(idtheme);
	System.out.println(themeCV);
		cv.setMembre(mb);
		cv.setThemeCV(themeCV);
		CV x= cvService.save(cv);
		InformationPersonnel informationPersonnel=new InformationPersonnel("Presenter vous en quelque Ligne", null, "Titre Du Cv");
		informationPersonnel.setCv(x);
		informationPersonnelService.save(informationPersonnel);
		
		 return x.getIdCV();
	}
	@RequestMapping(method=RequestMethod.GET,headers="Accept=application/json")
	public List<CV> findAll() {
		return cvService.findAll();
	}
	@RequestMapping(value="/find/{id}",method=RequestMethod.GET)
	public CV findById(@PathVariable long id) {
		return cvService.findById(id);
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		cvService.delete(id);
	}
	 @RequestMapping( value="/update/{id}",method=RequestMethod.PUT)
	public CV update(@ PathVariable long id,@RequestBody CV cv) {
		return cvService.update(id,cv);
	}
	 @RequestMapping(value="/find/Experiences/{idMembre}/{idCv}",method=RequestMethod.GET)
		public List<Experience> findExperiences(@ PathVariable long idMembre,@ PathVariable long idCv) {
			return cvService.findExperiences(idMembre,idCv);
		}
	 @RequestMapping(value="/find/Formations/{idMembre}/{idCv}",method=RequestMethod.GET)
		public List<Formation> findFormations(@ PathVariable long idMembre,@ PathVariable long idCv) {
			return cvService.findFormations(idMembre, idCv);
		}
	 @RequestMapping(value="/find/Languages/{idMembre}/{idCv}",method=RequestMethod.GET)
		public List<Language> findLanguages(@ PathVariable long idMembre,@ PathVariable long idCv) {
			return cvService.findLanguages(idMembre, idCv);
		}
	 @RequestMapping(value="/find/Loisirs/{idMembre}/{idCv}",method=RequestMethod.GET)
		public List<Loisir> findLoisirs(@ PathVariable long idMembre,@ PathVariable long idCv) {
			return cvService.findLoisirs(idMembre, idCv);
		}
	 @RequestMapping(value="/find/Liens/{idMembre}/{idCv}",method=RequestMethod.GET)
		public List<Lien> findLiens(@ PathVariable long idMembre,@ PathVariable long idCv) {
			return cvService.findLiens(idMembre, idCv);
		}
	 @RequestMapping(value="/find/InformationPersonnel/{idMembre}/{idCv}",method=RequestMethod.GET)
		public InformationPersonnel findInformationPersonnel(@ PathVariable long idMembre,@ PathVariable long idCv) {
			return cvService.findInformationPersonnel(idMembre, idCv);
		}
	 @RequestMapping(value="/find/infoCV/{idCv}",method=RequestMethod.GET)
		public CV infoCV(@ PathVariable long idCv) {
		 CV x=cvService.findById(idCv);
			x.setLiens(null);
			x.setMembre(null);
		
			return x;
		}
	 @RequestMapping(value="/find/Competences/{idMembre}/{idCv}",method=RequestMethod.GET)
		public List<Competence> findCompetences(@ PathVariable long idMembre,@ PathVariable long idCv) {
			return cvService.findCompetences(idMembre, idCv);
		}
	 @RequestMapping(value="/update/photoProfil/{idCv}",method=RequestMethod.PUT)
	 public void updatePhotoProfil(@PathVariable Long idCv,@RequestBody String photo) {
		 CV cv= cvService.findById(idCv);
		 cv.setPhoto(photo);
		 cvService.save(cv);
			 
		}

}
