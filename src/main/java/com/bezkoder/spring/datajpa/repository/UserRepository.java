package com.bezkoder.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.datajpa.model.User;

public interface UserRepository  extends JpaRepository<User, Integer> {
	
	List<User> findByusername(String  username);
	List<User> findBypassword(String  password);
	List<User> findByemail(String  email);
	List<User> findByUserId(int userId);
}
