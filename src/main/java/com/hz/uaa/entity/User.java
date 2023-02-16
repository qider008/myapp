package com.hz.uaa.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hz.base.entity.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Table(name = "sys_user")
@Entity
@EqualsAndHashCode(callSuper = false)
@ToString(exclude = { "role" })
public class User extends BaseEntity {

	private static final long serialVersionUID = 3288699218097614487L;

	@Column(name = "username", unique = true, columnDefinition = "varchar(64) COMMENT '用户名' ", nullable = false)
	private String username;

	@Column(name = "phone", unique = true, columnDefinition = "varchar(64) COMMENT '手机号码' ", nullable = false)
	private String phone;

	@JsonIgnore
	@NotBlank(message = "密码不能为空")
	@Column(name = "password", columnDefinition = "varchar(80) COMMENT '用户密码' ", nullable = false)
	private String password;

	@JsonIgnore
	@ManyToMany(targetEntity = Role.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "sys_user_role", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Set<Role> role;

	@OneToOne(cascade = CascadeType.REFRESH)
	@JsonIgnore
	@JoinColumn(name = "info_id", referencedColumnName = "id")
	private UserInfo userInfo;
}
