package com.dena.controllers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dena.entities.CV;
import com.dena.entities.Membre;
import com.dena.entities.Role;
import com.dena.entities.ThemeCV;
import com.dena.service.IMembreService;


@RestController
@RequestMapping("/membre")
public class  MembreController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private IMembreService membreService ;
	@RequestMapping(value="/find/sexe/{sexe}",method=RequestMethod.GET)
	public List<Membre> findBySexe(@PathVariable Boolean sexe) {
		return membreService.findBySexe(sexe);
	}
	
	@RequestMapping(value="/find/civilite/{civilite}",method=RequestMethod.GET)
	public List<Membre> findByCivilite(@PathVariable String civilite) {
		return membreService.findByCivilite(civilite);
	}
	@RequestMapping(value="/find/cvs/{idMembre}",method=RequestMethod.GET)
	public Map<Long, List<ThemeCV>> findCVMembre(@PathVariable Long idMembre) {
		Map<Long, List<ThemeCV>> tmc=new HashMap<>();
		for (CV item :membreService.findCVMembre(idMembre))
		{
			tmc.put(item.getIdCV(), (List<ThemeCV>) item.getThemeCVs());
		}
		return tmc;
	}
	@RequestMapping(value="/find/email/{email:[_'.@a-z0-9-]+}",method=RequestMethod.GET)
	public Membre findByEmail(@PathVariable String email) {
		return membreService.findByEmail(email);
	}
	@RequestMapping(value="/ifEmailExiste/{email:[_'.@a-z0-9-]+}",method=RequestMethod.GET)
	public Map<String, Object> ifEmailExiste(@PathVariable String email) {
		Membre x= membreService.findByEmail(email);
		if(x!=null){
			Map<String, Object> map=new HashMap<>();
			map.put("value", x.getEmail());
			return map;}
		else
			return null;
	}
	
	@RequestMapping(value="/ifUseNameExiste/{username:[_'.@a-z0-9-]+}",method=RequestMethod.GET)
	public Map<String, Object> ifUseNameExist(@PathVariable String username) {
		Membre x= membreService.findByUserName(username);
		if(x!=null){
			Map<String, Object> map=new HashMap<>();
			map.put("value", x.getUserName());
			return map;}
		else
			return null;
	}
	
	public IMembreService getMembreService() {
		return membreService;
	}
	public void setMembreService(IMembreService membreService) {
		this.membreService = membreService;
	}
	  @RequestMapping(method=RequestMethod.POST)
	   public Membre save(@RequestBody Membre membre) {
		Membre x = membreService.findByEmail(membre.getEmail()) ; 
		if(x != null)
		 return null ; 
		 else
		 {
	    membre.setPassword(passwordEncoder.encode(membre.getPassword()));
	  
		return membreService.save(membre);}
	   }
	@RequestMapping(method=RequestMethod.GET,headers="Accept=application/json")
	public List<Membre> findAll() {
		return membreService.findAll();
	}
	@RequestMapping(value="/find/{id}",method=RequestMethod.GET)
	public Membre findById(@PathVariable long id) {
		return membreService.findById(id);
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		membreService.delete(id);
	}
	 @RequestMapping( value="/update/{id}",method=RequestMethod.PUT)
	public Membre update(@ PathVariable long id,@RequestBody Membre membre) {
		return membreService.update(id,membre);
	}
	 //retrouver le username et les roles du member loged
	@RequestMapping(value="/getLogedUser")
	public Map<String, Object> getLogedUser(HttpSession httpSession){
		SecurityContext securityContext=(SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
		String userName=securityContext.getAuthentication().getName();
		List<String> roles=new ArrayList<>();
		long id;
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(userName);
		boolean b = m.find();
		if(b)
			id =membreService.findByEmail(userName).getIdMembre();
			
		else
			 id =membreService.findByUserName(userName).getIdMembre();
			
		
		for(GrantedAuthority grantedAuthority :securityContext.getAuthentication().getAuthorities())
		roles.add(grantedAuthority.getAuthority());
		Map<String, Object> params=new HashMap<>();
		params.put("id", id);
		params.put("userName", userName);
		params.put("roles", roles);
		return params;
		
	}



}
