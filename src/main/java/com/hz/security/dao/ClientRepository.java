package com.hz.security.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hz.security.entity.Client;

public interface ClientRepository extends JpaRepository<Client, String> {
	Optional<Client> findByClientId(String clientId);
}
