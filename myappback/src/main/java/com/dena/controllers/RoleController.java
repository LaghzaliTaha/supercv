package com.dena.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dena.entities.Role;
import com.dena.service.IRoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private IRoleService roleService ;
	@RequestMapping(value="/find/typerole/{typerole}",method=RequestMethod.GET)
	public List<Role> findByTypeRole(@PathVariable String typerole) {
		return roleService.findByTypeRole(typerole);
	}
	@RequestMapping(method=RequestMethod.POST)
	public Role save(@RequestBody Role role) {
		return roleService.save(role);
	}
	@RequestMapping(method=RequestMethod.GET)
	public List<Role> findAll() {
		return roleService.findAll();
	}
	@RequestMapping(value="/find/{id}",method=RequestMethod.GET)
	public Role findById(@PathVariable long id) {
		return roleService.findById(id);
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		roleService.delete(id);
	}
	 @RequestMapping( value="/update/{id}",method=RequestMethod.PUT)
	public Role update(@ PathVariable long id,@RequestBody Role role) {
		return roleService.update(id,role);
	}

	

}