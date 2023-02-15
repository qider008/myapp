package com.hz.base.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@MappedSuperclass
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@EqualsAndHashCode(callSuper = false)
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 2030469276667529289L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	@Column(name = "id", length = 36)
	@Comment("id主键")
	protected String id;

	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "create_time")
	@CreatedDate
	@Comment("创建时间")
	protected Date createTime;

	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "update_time")
	@LastModifiedDate
	@Comment("更新时间")
	protected Date updateTime;

	@CreatedBy
	@Comment("创建人")
	protected String createBy;

	@LastModifiedBy
	@Column(name = "update_by", length = 36)
	@Comment("更新人")
	protected String updateBy;

	@Column(name = "status", length = 2)
	@ColumnDefault("0")
	@Comment("删除标识：0否 1是")
	private Integer status = 0;
}
