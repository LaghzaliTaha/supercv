package com.dena.service;


import java.util.List;


import com.dena.entities.Formation;

public interface IFormationService {

         	public Formation save(Formation ex) ;
			public List<Formation> findAll() ;
			public Formation findById(long id) ;
			public void delete(long id) ;
			public Formation update(long id, Formation formation);

		}

