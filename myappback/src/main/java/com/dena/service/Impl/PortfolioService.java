package com.dena.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dena.entities.Portfolio;
import com.dena.repositories.IPortfolioRepository;
import com.dena.service.IPortfolioService;


@Service
@Transactional
public class PortfolioService implements IPortfolioService {
	

	
	

		@Autowired
		private IPortfolioRepository portfolioRepository ;
		
		

		@Override
		public Portfolio save(Portfolio portfolio ) {
			// TODO Auto-generated method stub
			return portfolioRepository.save(portfolio);
		}

		@Override
		public List<Portfolio> findAll() {
			// TODO Auto-generated method stub
			return portfolioRepository.findAll();
		}

		@Override
		public  Portfolio findById(long id) {
			// TODO Auto-generated method stub
			return portfolioRepository.findOne(id);
		}

		@Override
		public void delete(long id) {
			// TODO Auto-generated method stub
			portfolioRepository.delete(id);
			
		}

		public IPortfolioRepository getPortfolioRepository() {
			return portfolioRepository;
		}

		public void setPaiementRepository(IPortfolioRepository paiementRepository) {
			this.portfolioRepository = paiementRepository;
		}

		@Override
		public  Portfolio update(long id, Portfolio portfolio) {
			Portfolio x=portfolioRepository.findOne(id);
			x.setAudios(portfolio.getAudios());
			x.setDescription(portfolio.getDescription());
			x.setDiaporamas(portfolio.getDiaporamas());
			x.setDocuments(portfolio.getDocuments());
			x.setImages(portfolio.getImages());
			x.setTitrePortfolio(portfolio.getTitrePortfolio());
			x.setVideos(portfolio.getVideos());
			return portfolioRepository.save(x);
		}
		
		
		
		
		
		@Override
		public List <Portfolio> findByTitrePortfolio(String titreportfolio) {
			// TODO Auto-generated method stub
			return portfolioRepository.findByTitrePortfolio(titreportfolio);
		}
		
		@Override
		public List <Portfolio> findByDescription(String description) {
		// TODO Auto-generated method stub
		return portfolioRepository.findByDescription(description);
	}
	}

