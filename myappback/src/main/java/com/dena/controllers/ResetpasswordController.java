package com.dena.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dena.entities.Membre;
import com.dena.service.IMembreService;

@RestController
public class ResetpasswordController {
	@Autowired
	private IMembreService membreService ;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@RequestMapping(value = "/resetpassword/{resetPasswordToken}", method = RequestMethod.GET)
	  public ResponseEntity<Membre> resetPassword( @PathVariable String resetPasswordToken) {
	  
	    Membre userToUpdate = membreService.findByResetPasswordToken(resetPasswordToken).get(0);
	    if(userToUpdate!=null&&userToUpdate.getResetPasswordExpires().after(new Date()))
	    {
	    	return new ResponseEntity<>(userToUpdate, HttpStatus.OK);
	    }
	   return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	@RequestMapping(value = "/changepassword/{token}/{password}", method = RequestMethod.GET)
	public ResponseEntity<Membre> changePassword(@PathVariable String token,@PathVariable String password){
	    Membre userToUpdate = membreService.findByResetPasswordToken(token).get(0);
	    String  hashPassword=passwordEncoder.encode(password);
	    userToUpdate.setPassword(hashPassword);
	    membreService.save(userToUpdate);

		
		return new ResponseEntity<>( HttpStatus.OK);
		
	}
	
	

}
