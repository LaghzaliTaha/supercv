package com.dena.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dena.entities.ThemeCarte;
import java.lang.String;
import java.util.List;

public interface IThemeCarteRepository  extends JpaRepository<ThemeCarte, Long>{
	List<ThemeCarte> findByNomThemeCarte(String nomthemecarte);
}
