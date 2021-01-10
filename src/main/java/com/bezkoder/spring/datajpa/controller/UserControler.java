package com.bezkoder.spring.datajpa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.datajpa.model.Tutorial;
import com.bezkoder.spring.datajpa.model.User;
import com.bezkoder.spring.datajpa.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserControler {
	@Autowired
	UserRepository userRepository;

	@PostMapping("/users")
	public ResponseEntity<User> Registration(@RequestBody User user) {
		try {
			User _user = userRepository.save(new User(user.getUserId(), user.getFirstName(), user.getMiddleName(),
					user.getLastName(), user.getEmail(), user.getUsername(), user.getPassword(), user.getMobile()));
			return new ResponseEntity<>(_user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<User> login(@PathVariable("userid") int userid, @RequestBody User user) {
		Optional<User> userData = userRepository.findById(userid);

		if (userData.isPresent()) {
			User _user = userData.get();
			_user.setUsername(user.getUsername());
			_user.setPassword(user.getPassword());

			return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<User> ResetPassword(@PathVariable("userid") int userid, String currentPassword,
			String newPassword, @RequestBody User user) {
		Optional<User> userData = userRepository.findById(userid);
		if (userData.isPresent()) {
			User _user = userData.get();
			_user.setUserId(user.getUserId());
			_user.setCurrentPassword(user.getCurrentPassword());
			_user.setNewPassword(user.getNewPassword());
			

			return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
