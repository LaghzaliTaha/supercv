package com.dena.service;

import java.util.List;

import com.dena.entities.Competence;
import com.dena.entities.Document;

public interface IDocumentService {
	
	public Document save(Document ex) ;
	public List<Document> findAll() ;
	public Document findById(long id) ;
	public void delete(long id) ;
	public Document update(long id,Document competence);

}