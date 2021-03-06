package com.rs.fer.updateuser;

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

import com.bezkoder.spring.datajpa.model.User;
import com.bezkoder.spring.datajpa.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserRepository userRepository;

	@PostMapping("/users")
	public ResponseEntity<User> Registration(@RequestBody User user) {
		try {
			User _user = userRepository
					.save(new User(user.getUserId(), user.getFirstName(),user.getMiddleName(),user.getLastName(),user.getEmail(),user.getUsername(),user.getPassword(),user.getMobile()));
			return new ResponseEntity<>(_user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
//	@PostMapping("/users")
//	public ResponseEntity<User> login(@RequestBody User user) {
//		try {
//			User _user = userRepository
//					.save(new User(user.getUsername(), user.getPassword()));
//
//			return new ResponseEntity<>(user, HttpStatus.CREATED);
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	
	/*@PutMapping("/user/{id}")
	public ResponseEntity<Tutorial> login(@PathVariable("id") int id, @RequestBody User user) {
		Optional<User> userData = userRepository.findById(id);

		    if (userData.isPresent()) {
			User _user = userData.get();
			_user.setUsername(user.getUsername());
			_user.setPassword(user.getPassword());
			
			return new ResponseEntity<>(userRepository.login(user),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}*/
	
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable("userId") int userId, @RequestBody User user) {
		Optional<User> userData = userRepository.findById(userId);

		if (userData.isPresent()) {
			User _user = userData.get();
			_user.setUserId(_user.getUserId());
			_user.setFirstName(_user.getFirstName());
			_user.setMiddleName(_user.getMiddleName());
			_user.setLastName(_user.getLastName());
			_user.setEmail(_user.getEmail());
			_user.setMobile(_user.getMobile());
			_user.setAdress(_user.getAdress());
			return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}


