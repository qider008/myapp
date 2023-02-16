package com.hz.uaa.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.hz.uaa.dao.RoleDao;
import com.hz.uaa.entity.Role;

@Service
public class RoleService {

	@Autowired
	RoleDao roleDao;

	@Autowired
	UserService userService;

	@Autowired
	PermissionService permissionService;

	@SuppressWarnings("unused")
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@SuppressWarnings("unused")
	@Autowired
	private JdbcTemplate jdbctemplate;

	public Role save(Role entity) {
		if (StringUtils.isNotBlank(entity.getId())) {
			Role role = this.findById(entity.getId());
			entity.setPermissions(role.getPermissions());
		}
		return roleDao.save(entity);
	}

	public Role findByName(String name) {
		return roleDao.findByName(name);
	}

	public Role findByRole(String role) {
		return roleDao.findByRole(role);
	}

	public Role findById(String id) {
		return roleDao.findById(id).get();
	}
}
