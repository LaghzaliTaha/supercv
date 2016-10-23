package com.dena.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dena.entities.Membre;
import com.dena.security.SmtpMailSender;
import com.dena.service.IMembreService;

@RestController
public class MailSecurityController {
	
	@Autowired
	private SmtpMailSender smtpMailSender;
	@Autowired
	private IMembreService membreService ;
	

	@RequestMapping(value="/send-mail/{email:[_'.@a-z0-9-]+}",method=RequestMethod.GET)
	public void sendMail(@PathVariable String email) throws MessagingException {
	
		Membre membre = membreService.findByEmail(email);
		String secureToken = UUID.randomUUID().toString();
	      membre.setResetPasswordToken(secureToken);
	      /*
	       Give token one hour expiration delay
	      */
	      Date currentDate = new Date();
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(currentDate);
	      calendar.add(Calendar.HOUR_OF_DAY, 1); 
	      Date expirationDate = calendar.getTime();
	      membre.setResetPasswordExpires(expirationDate);
	      membreService.save(membre);
	      String text = "You are receiving this because you (or someone else) have requested the reset of the password for your account.\n\n"
	    		  + "Please click on the following link, or paste into your browser to complete the reset password process :\n\n"
                  +"<a href=\"http://localhost:63342/angulr_2.0.1/src/index.html#/resetpassword/"+secureToken+"\">\n" +
                  "This is a link</a>\n" 
	    		  + "\n\n If you did not request this, please ignore this email and your password will remain unchanged.";
			smtpMailSender.send(email, "Test mail from Spring", text);

		
		
		
	}
	
	

}
