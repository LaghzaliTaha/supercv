package com.dena.service;

import java.util.List;

import com.dena.entities.Competence;
import com.dena.entities.InformationPersonnel;

public interface IInformationPersonnelService {
	
                    public InformationPersonnel save(InformationPersonnel ex) ;
					public List<InformationPersonnel> findAll() ;
					public InformationPersonnel findById(long id) ;
					public void delete(long id) ;
					public InformationPersonnel update(long id,InformationPersonnel informationPersonnel);
			}


