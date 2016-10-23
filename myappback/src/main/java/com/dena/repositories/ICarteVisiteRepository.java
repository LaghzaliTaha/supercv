package com.dena.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dena.entities.CarteVisite;
import java.lang.String;
import java.util.List;
import java.lang.Integer;

public interface ICarteVisiteRepository extends JpaRepository<CarteVisite, Long> {
	

	List<CarteVisite> findBySiteWeb(String siteweb);

	List<CarteVisite> findByTel(Integer tel);
}
