package com.dena.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dena.entities.Diaporama;
import com.dena.entities.Document;
import com.dena.service.IDocumentService;
import com.dena.repositories.IDocumentRepository;


@Service
@Transactional
public class DocumentService implements IDocumentService{

	@Autowired
	private IDocumentRepository documentRepository ;
	
	

	@Override
	public Document save(Document ex) {
		// TODO Auto-generated method stub
		return documentRepository.save(ex);
	}

	@Override
	public List<Document> findAll() {
		// TODO Auto-generated method stub
		return documentRepository.findAll();
	}

	@Override
	public Document findById(long id) {
		// TODO Auto-generated method stub
		return documentRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		documentRepository.delete(id);
		
	}
	public IDocumentRepository getDocumentRepository() {
		return documentRepository;
	}

	public void setDocumentRepository(IDocumentRepository documentRepository) {
		this.documentRepository = documentRepository;
	}
	
	@Override
	public Document update(long id,Document document) {
		Document x=documentRepository.findOne(id);
		x.setEmplacement(document.getEmplacement());
		x.setPortfolio(document.getPortfolio());	
		return documentRepository.save(x);
	}
}


