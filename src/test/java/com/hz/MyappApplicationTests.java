package com.hz;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hz.uaa.entity.Role;
import com.hz.uaa.entity.User;
import com.hz.uaa.service.RoleService;
import com.hz.uaa.service.UserService;

@SpringBootTest
class MyappApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	void contextLoads() {
		Role role = new Role();
		role.setName("管理员");
		role.setRole("admin");

		role = roleService.save(role);

		User user = new User();
		user.setUsername("admin");
		user.setPassword(passwordEncoder.encode("123456"));
		user.setPhone("13976120021");
		user.setRole(Set.of(role));
		userService.save(user);
	}

}
