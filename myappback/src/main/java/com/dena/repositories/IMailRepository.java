package com.dena.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dena.entities.Mail;
import java.lang.String;
import java.util.List;
import java.util.Date;

public interface IMailRepository extends JpaRepository<Mail, Long> {
	List<Mail> findByContenu(String contenu);
	List<Mail> findByDateEnvoi(Date dateenvoi);
	List<Mail> findByEmail(String email);

}
