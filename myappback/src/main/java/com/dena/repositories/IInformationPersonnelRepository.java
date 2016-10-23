package com.dena.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dena.entities.InformationPersonnel;;

public interface IInformationPersonnelRepository extends JpaRepository<InformationPersonnel, Long> {

}
