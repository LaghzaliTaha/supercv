package com.dena.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dena.entities.Image;

public interface IImageRepository extends JpaRepository<Image, Long>{ 
	
}
