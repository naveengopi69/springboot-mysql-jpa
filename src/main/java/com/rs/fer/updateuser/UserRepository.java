package com.rs.fer.updateuser;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.datajpa.model.User;

public interface UserRepository  extends JpaRepository<User, Integer> {

	
	List<User> findByUsernameAndPassword(String  username ,String  password);

	
}
