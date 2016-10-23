package com.dena.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dena.entities.Mail;
import com.dena.repositories.IMailRepository;
import com.dena.service.IMailService;

@Service
@Transactional
public class MailService implements IMailService{

	@Autowired
	private IMailRepository mailRepository ;
	
	

	@Override
	public Mail save(Mail mail) {
		// TODO Auto-generated method stub
		return mailRepository.save(mail);
	}

	@Override
	public List<Mail> findAll() {
		// TODO Auto-generated method stub
		return mailRepository.findAll();
	}

	@Override
	public Mail findById(long id) {
		// TODO Auto-generated method stub
		return mailRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		mailRepository.delete(id);
		
	}

	public IMailRepository getiMailRepository() {
		return mailRepository;
	}

	public void setiMailRepository(IMailRepository iMailRepository) {
		this.mailRepository = iMailRepository;
	}

	@Override
	public Mail update(long id,Mail mail) {
		Mail x=mailRepository.findOne(id);
		x.setContenu(mail.getContenu());
		x.setDateEnvoi(mail.getDateEnvoi());
		x.setEmail(mail.getEmail());
		return mailRepository.save(x);
	}

	@Override
	public List<Mail> findByContenu(String contenu) {
		
		return mailRepository.findByContenu(contenu);
	}

	@Override
	public List<Mail> findByDateEnvoi(Date dateenvoi) {
		// TODO Auto-generated method stub
		return mailRepository.findByDateEnvoi(dateenvoi);
	}

	@Override
	public List<Mail> findByEmail(String email) {
		// TODO Auto-generated method stub
		return mailRepository.findByEmail(email);
	}
	
}
