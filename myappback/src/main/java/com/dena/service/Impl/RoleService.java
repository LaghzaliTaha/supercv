package com.dena.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dena.entities.Role;
import com.dena.repositories.IRoleRepository;
import com.dena.service.IRoleService;


@Service
@Transactional
public class RoleService implements IRoleService{

	@Autowired
	private IRoleRepository roleRepository ;
	
	

	@Override
	public Role save(Role role ) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public  Role findById(long id) {
		// TODO Auto-generated method stub
		return roleRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		roleRepository.delete(id);
		
	}

	





	

	

	public IRoleRepository getRoleRepository() {
		return roleRepository;
	}

	public void setRoleRepository(IRoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public  Role update(long id, Role role) {
		Role x=roleRepository.findOne(id);
		x.setTypeRole(role.getTypeRole());
		return roleRepository.save(x);
	}

	@Override
	public List<Role> findByTypeRole(String typerole) {
		// TODO Auto-generated method stub
		return roleRepository.findByTypeRole(typerole);
	}
	
}