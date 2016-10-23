package com.dena.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dena.entities.Paiement;
import java.util.Date;
import java.util.List;

public interface IPaiementRepository extends JpaRepository<Paiement, Long>{
	List<Paiement> findByDatePaiement(Date datepaiement);
	List<Paiement> findByExpiration(Date expiration);
}
