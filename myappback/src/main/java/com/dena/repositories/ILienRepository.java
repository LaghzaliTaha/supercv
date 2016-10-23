package com.dena.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dena.entities.Lien ;

public interface ILienRepository extends JpaRepository<Lien, Long> {


}
