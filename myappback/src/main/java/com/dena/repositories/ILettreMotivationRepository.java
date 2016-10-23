package com.dena.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dena.entities.LettreMotivation;
import java.lang.String;
import java.util.List;

public interface ILettreMotivationRepository extends JpaRepository<LettreMotivation, Long> {
	List<LettreMotivation> findByDomaine(String domaine);

	List<LettreMotivation> findByTypeContrat(String typecontrat);

	List<LettreMotivation> findByPost(String post);

	List<LettreMotivation> findByNomEntreprise(String nomentreprise);
}
