package com.hz.uaa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hz.uaa.entity.Permission;

public interface PermissionDao extends JpaSpecificationExecutor<Permission>, PagingAndSortingRepository<Permission, String>, JpaRepository<Permission, String> {

	List<Permission> findByName(String name);

	List<Permission> findByPid(String pid);
}
