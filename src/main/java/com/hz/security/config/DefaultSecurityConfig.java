package com.hz.security.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import com.hz.security.service.MyUserDetailsService;

@EnableWebSecurity
@Configuration(proxyBeanMethods = false)
public class DefaultSecurityConfig {

	@Autowired
	MyUserDetailsService userDetailsService;

	// @formatter:off
		@Bean
		SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
			http
				.authorizeHttpRequests(authorize ->
					authorize.anyRequest().authenticated()
				)
				.cors()
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.oauth2ResourceServer().jwt()
				.and().and()
				.formLogin(withDefaults());
			return http.build();
		}
	// @formatter:on
}
