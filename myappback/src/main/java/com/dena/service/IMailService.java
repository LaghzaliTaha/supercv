package com.dena.service;

import java.util.Date;
import java.util.List;

import com.dena.entities.Mail;

public interface IMailService {
	public Mail save(Mail mail) ;
	public List<Mail> findAll() ;
	public Mail findById(long id) ;
	public void delete(long id) ;
	public Mail update(long id,Mail mail);
	public List<Mail> findByContenu(String contenu);
	public List<Mail> findByDateEnvoi(Date dateenvoi);
	public List<Mail> findByEmail(String email);
}
