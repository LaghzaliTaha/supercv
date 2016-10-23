package com.dena.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dena.entities.CV;
import com.dena.entities.Competence;
import com.dena.entities.Experience;
import com.dena.entities.Formation;
import com.dena.entities.InformationPersonnel;
import com.dena.entities.Language;
import com.dena.entities.Lien;
import com.dena.entities.Loisir;

public interface ICVRepository extends JpaRepository<CV, Long>  {
	
	@Query(value = "  from Experience where  cv.idCV=:id_cv and cv.membre.idMembre=:id_membre ")
	public List<Experience> findExperiences(@Param("id_membre") Long idMembre,@Param("id_cv") Long idCv);
	@Query(value = "  from Formation where cv.idCV=:id_cv and cv.membre.idMembre=:id_membre ")
	public List<Formation> findFormations(@Param("id_membre") Long idMembre,@Param("id_cv") Long idCv);
	@Query(value = "  from Loisir where cv.idCV=:id_cv and cv.membre.idMembre=:id_membre ")
	public List<Loisir> findLoisirs(@Param("id_membre") Long idMembre,@Param("id_cv") Long idCv);
	@Query(value = "  from Lien where cv.idCV=:id_cv and cv.membre.idMembre=:id_membre ")
	public List<Lien> findLiens(@Param("id_membre") Long idMembre,@Param("id_cv") Long idCv);
	@Query(value = "  from InformationPersonnel where cv.idCV=:id_cv and cv.membre.idMembre=:id_membre ")
	public InformationPersonnel findInformationPersonnel(@Param("id_membre") Long idMembre,@Param("id_cv") Long idCv);
	@Query(value = "  from Competence where cv.idCV=:id_cv and  cv.membre.idMembre=:id_membre ")
	public List<Competence> findCompetences(@Param("id_membre") Long idMembre,@Param("id_cv") Long idCv);
	@Query(value = "  from Language where cv.idCV=:id_cv and cv.membre.idMembre=:id_membre ")
	public List<Language> findLanguages(@Param("id_membre") Long idMembre,@Param("id_cv") Long idCv);
}
