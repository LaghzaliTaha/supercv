package com.dena.service.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dena.entities.ThemeCV;
import com.dena.repositories.IThemeCVRepository;
import com.dena.service.IThemeCVService;


@Service
@Transactional


public class ThemeCVService implements IThemeCVService{



		@Autowired
		private IThemeCVRepository themeCVRepository ;
		
		

		@Override
		public ThemeCV save(ThemeCV ex) {
			// TODO Auto-generated method stub
			return themeCVRepository.save(ex);
		}

		@Override
		public List<ThemeCV> findAll() {
			// TODO Auto-generated method stub
			return themeCVRepository.findAll();
		}

		@Override
		public ThemeCV findById(long id) {
			// TODO Auto-generated method stub
			return themeCVRepository.findOne(id);
		}

		@Override
		public void delete(long id) {
			// TODO Auto-generated method stub
			themeCVRepository.delete(id);
			
		}
		public IThemeCVRepository getExperienceRepository() {
			return themeCVRepository;
		}

		public void setExperienceRepository(IThemeCVRepository experienceRepository) {
			this.themeCVRepository = experienceRepository;
		}
		
		@Override
		public ThemeCV update(long id,ThemeCV themecv) {
			ThemeCV x=themeCVRepository.findOne(id);
			x.setNomType(themecv.getNomType());
			x.setCv(themecv.getCv());
			return themeCVRepository.save(x);
		}
	}

