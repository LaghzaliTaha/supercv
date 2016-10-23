package com.dena.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dena.entities.Portfolio ;

public interface IPortfolioRepository extends JpaRepository<Portfolio, Long>{

	List <Portfolio> findByTitrePortfolio(String titreportfolio);
	List <Portfolio> findByDescription(String description);
	

}
