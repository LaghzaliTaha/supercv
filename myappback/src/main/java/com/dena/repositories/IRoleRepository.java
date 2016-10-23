package com.dena.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dena.entities.Role;
import java.lang.String;
import java.util.List;

public interface IRoleRepository extends JpaRepository<Role, Long> {
	List<Role> findByTypeRole(String typerole);
}
