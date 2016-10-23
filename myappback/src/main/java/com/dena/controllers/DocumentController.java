package com.dena.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dena.entities.Document ;
import com.dena.service.IDocumentService;
import com.dena.service.Impl.DocumentService;

@RestController
@RequestMapping("document")
public class DocumentController {

	@Autowired
	private IDocumentService documentService ;

	public IDocumentService getDocumentService() {
		return documentService;
	}

	public void setIDocumentService(DocumentService documentService) {
		this.documentService = documentService;
	}

	@RequestMapping(
			method = {RequestMethod.GET,RequestMethod.POST}, 
			produces = { "application/json" }
			)
	public List<Document> findAll(HttpServletResponse response) throws IOException{
		List<Document> document = null;
		try
		{
			document = documentService.findAll();
		}
		catch(Exception e)
		{
			response.sendError(404);
		}
		return document ;
	}
} 

