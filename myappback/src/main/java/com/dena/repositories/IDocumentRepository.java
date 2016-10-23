package com.dena.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dena.entities.Document;

public interface IDocumentRepository extends JpaRepository<Document, Long>  {

}