package com.hz.security.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.hz.uaa.entity.Role;
import com.hz.uaa.entity.User;
import com.hz.uaa.service.UserService;

@Component
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userService.findByUsername(username);
		Set<GrantedAuthority> sets = null;
		if (user != null) {
			sets = user.getRole().stream().map(Role::getRole).map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
		}

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), sets);
	}

}
