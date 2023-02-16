package com.hz.uaa.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hz.base.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Table(name = "sys_permission")
@Entity
@EqualsAndHashCode(callSuper = false)
public class Permission extends BaseEntity {

	private static final long serialVersionUID = -5152929456917504452L;

	@Column(name = "name", columnDefinition = "varchar(64) COMMENT '菜单名称'")
	private String name;

	@Column(name = "url", columnDefinition = "varchar(128) COMMENT '菜单Url'")
	private String url;

	@Column(name = "pid", columnDefinition = "varchar(36) COMMENT '上级权限ID'")
	private String pid;

	@Column(name = "description", columnDefinition = "varchar(128) COMMENT '描述'")
	private String description;

	@Column(name = "type", columnDefinition = "int  COMMENT '菜单类型：0（目录）、1（视图）、2（按钮）、3（数据） '")
	private Integer type; // 0:目录,1:view,3:数据,2,按钮

	@JsonIgnore
	@ManyToMany(mappedBy = "permissions", fetch = FetchType.LAZY)
	private List<Role> roles;

	@Column(name = "icon", columnDefinition = "varchar(32) COMMENT '菜单图标'")
	private String icon;

	@Column(name = "perms", columnDefinition = "varchar(128) COMMENT '权限标识'")
	private String perms;

	@Column(length = 4)
	private Integer orderNum = 100;

	@Transient
	private List<Permission> children;

}
