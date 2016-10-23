package com.dena.service;

import java.util.List;

import com.dena.entities.Role;

public interface IRoleService {
	public Role save(Role role) ;
	public List<Role> findAll() ;
	public Role findById(long id) ;
	public void delete(long id) ;
	public Role update(long id,Role role);
	public List<Role> findByTypeRole(String typerole);

}
