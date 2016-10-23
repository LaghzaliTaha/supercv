package com.dena.service;

import java.util.List;

import com.dena.entities.Portfolio;

public interface IPortfolioService {
	public Portfolio save(Portfolio portfolio) ;
	public List<Portfolio> findAll() ;
	public Portfolio findById(long id) ;
	public void delete(long id) ;
	public Portfolio update(long id,Portfolio portfolio);
	public List <Portfolio> findByTitrePortfolio(String titreportfolio);
	public List <Portfolio> findByDescription(String description);

}