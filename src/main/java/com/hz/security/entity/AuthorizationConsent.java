package com.hz.security.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sys_authorization_consent")
@IdClass(AuthorizationConsent.AuthorizationConsentId.class)
public class AuthorizationConsent {
	@Id
	private String registeredClientId;

	@Id
	private String principalName;

	@Column(length = 1000)
	private String authorities;

	public static class AuthorizationConsentId implements Serializable {
		private static final long serialVersionUID = 3705618682929495191L;

		private String registeredClientId;

		private String principalName;

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			AuthorizationConsentId that = (AuthorizationConsentId) o;
			return registeredClientId.equals(that.registeredClientId) && principalName.equals(that.principalName);
		}

		@Override
		public int hashCode() {
			return Objects.hash(registeredClientId, principalName);
		}
	}
}
