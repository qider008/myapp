package com.hz.uaa.entity;

import com.hz.base.entity.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Table(name = "sys_user")
@Entity
@EqualsAndHashCode(callSuper = false)
public class UserInfo extends BaseEntity {

	private static final long serialVersionUID = -7034032933224749281L;

	private Integer age;

	private String address;

	private String tel;

	private String email;

}
