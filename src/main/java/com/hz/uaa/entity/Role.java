package com.hz.uaa.entity;

import java.util.HashSet;
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
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "sys_role")
@EqualsAndHashCode(callSuper = false)
public class Role extends BaseEntity {

	private static final long serialVersionUID = 131429083903378430L;

	@JsonIgnore
	@ManyToMany(targetEntity = Permission.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "sys_role_permission", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id", nullable = false))
	@OrderBy("orderNum DESC")
	private Set<Permission> permissions = new HashSet<>();

	@Column(name = "name", columnDefinition = "varchar(32) COMMENT '角色名称' ", unique = true)
	private String name;

	@Column(name = "role", columnDefinition = "varchar(32) COMMENT '角色标识' ", unique = true)
	private String role; // 角色标识 程序中判断使用,如"ROLE_ADMIN,"
}
