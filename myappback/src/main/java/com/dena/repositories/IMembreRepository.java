package com.dena.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dena.entities.CV;
import com.dena.entities.Membre;

public interface IMembreRepository extends JpaRepository<Membre, Long>{ 
	List<Membre> findBySexe(Boolean sexe);
	List<Membre> findByCivilite(String civilite);

	Membre findByEmail(String email);

	
	List<Membre> findByResetPasswordToken(String resetpasswordtoken);
	Membre findByUserName(String username);
	@Query(value = "from CV   where  membre.idMembre=:id_membre ")
	List<CV> findCVMembre(@Param("id_membre") Long idMembre);
	
	
	
	

}
