package com.dena.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dena.entities.Abonnement;
import java.lang.Integer;
import java.util.List;

public interface IAbonnementRepository extends JpaRepository<Abonnement, Long>{
	List<Abonnement> findByTypeAbonnement(Integer typeabonnement);
	
}
