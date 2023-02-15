package com.hz.security.entity;

import java.time.Instant;

import com.hz.base.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "sys_client")
@org.hibernate.annotations.Table(appliesTo = "sys_client", comment = "RegisteredClient domain object")
@Data
@EqualsAndHashCode(callSuper = false)
public class Client extends BaseEntity {

	private static final long serialVersionUID = -8199398846065530004L;

	private String clientId;

	private Instant clientIdIssuedAt;

	private String clientSecret;

	private Instant clientSecretExpiresAt;

	private String clientName;

	@Column(length = 1000)
	private String clientAuthenticationMethods;

	@Column(length = 1000)
	private String authorizationGrantTypes;

	@Column(length = 1000)
	private String redirectUris;

	@Column(length = 1000)
	private String scopes;

	@Column(length = 2000, columnDefinition = "text")
	private String clientSettings;

	@Column(length = 2000, columnDefinition = "text")
	private String tokenSettings;
}
