package com.dena.service.Impl;

import com.dena.service.ILoisirService;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.dena.entities.Loisir;
import com.dena.repositories.ILoisirRepository;


@Service
@Transactional
public class LoisirService implements ILoisirService {



		@Autowired
		private ILoisirRepository loisirRepository ;
		
		

		@Override
		public Loisir save(Loisir loisir) {
			// TODO Auto-generated method stub
			return loisirRepository.save(loisir);
		}

		@Override
		public List<Loisir> findAll() {
			// TODO Auto-generated method stub
			return loisirRepository.findAll();
		}

		@Override
		public Loisir findById(long id) {
			// TODO Auto-generated method stub
			return loisirRepository.findOne(id);
		}

		@Override
		public void delete(long id) {
			// TODO Auto-generated method stub
			loisirRepository.delete(id);
			
		}

		public ILoisirRepository getiMailRepository() {
			return loisirRepository;
		}

		public void setiMailRepository(ILoisirRepository iLienRepository) {
			this.loisirRepository = iLienRepository;
		}

		@Override
		public Loisir update(long id,Loisir loisir) {
			Loisir x=loisirRepository.findOne(id);
			x.setDetailles(loisir.getDetailles());
			x.setTypeLoisr(loisir.getTypeLoisr());
			return loisirRepository.save(x);
		}
		
	}


