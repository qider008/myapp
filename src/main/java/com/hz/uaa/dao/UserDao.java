package com.hz.uaa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hz.uaa.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, String>, JpaSpecificationExecutor<User>, JpaRepository<User, String> {

	User findByUsername(String username);

	User findByPhone(String phone);
}
