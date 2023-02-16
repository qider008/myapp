package com.hz.uaa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hz.uaa.dao.PermissionDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class PermissionService {

	@SuppressWarnings("unused")
	@Autowired
	private PermissionDao permissionDao;

	@SuppressWarnings("unused")
	@Autowired
	private UserService userService;

	@Autowired
	@PersistenceContext
	private EntityManager em;

}
