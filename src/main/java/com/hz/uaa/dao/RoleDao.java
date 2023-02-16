package com.hz.uaa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.hz.uaa.entity.Role;

public interface RoleDao extends JpaSpecificationExecutor<Role>, JpaRepository<Role, String> {

	Role findByName(String name);

	@Query("select o from Role o where o.role = ?1")
	Role findByRole(String role);
}
