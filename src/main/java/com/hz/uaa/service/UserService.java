package com.hz.uaa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hz.uaa.dao.UserDao;
import com.hz.uaa.entity.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	@Lazy
	RoleService roleService;

	@Autowired
	@Lazy
	PermissionService permissionService;

	@Transactional
	public User save(User entity) {
		return userDao.save(entity);
	}

	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
