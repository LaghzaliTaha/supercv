package com.dena.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dena.entities.Lien;
import com.dena.repositories.ILienRepository;
import com.dena.service.ILienService;

@Service
@Transactional
public class LienService implements ILienService {
	


			@Autowired
			private ILienRepository lienRepository ;
			
			

			@Override
			public Lien save(Lien mail) {
				// TODO Auto-generated method stub
				return lienRepository.save(mail);
			}

			@Override
			public List<Lien> findAll() {
				// TODO Auto-generated method stub
				return lienRepository.findAll();
			}

			@Override
			public Lien findById(long id) {
				// TODO Auto-generated method stub
				return lienRepository.findOne(id);
			}

			@Override
			public void delete(long id) {
				// TODO Auto-generated method stub
				lienRepository.delete(id);
				
			}

			public ILienRepository getiLienRepository() {
				return lienRepository;
			}

			public void setiMailRepository(ILienRepository iLienRepository) {
				this.lienRepository = iLienRepository;
			}

			@Override
			public Lien update(long id,Lien lien) {
				Lien x=lienRepository.findOne(id);
				x.setLogo(lien.getLogo());
				x.setUrl(lien.getUrl());
				x.setContact(lien.getContact());
				return lienRepository.save(x);
			}
			
		}





