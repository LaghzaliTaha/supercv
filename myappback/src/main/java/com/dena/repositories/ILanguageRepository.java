package com.dena.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dena.entities.Language;

public interface ILanguageRepository extends JpaRepository<Language, Long> {
	

}
