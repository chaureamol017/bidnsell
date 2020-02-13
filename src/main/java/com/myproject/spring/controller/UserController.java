package com.myproject.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.spring.model.User;
import com.myproject.spring.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userServiceObj;

	@GetMapping("/api/user/{id}")
	public ResponseEntity<User> get(@PathVariable("id") String id) {
		User user = userServiceObj.get(id);

		return ResponseEntity.ok().body(user);
	}

	@GetMapping("/api/user")
	public ResponseEntity<List<User>> getAll() {
		List<User> list = userServiceObj.getAll();

		return ResponseEntity.ok().body(list);
	}

	@PostMapping("/api/user")
	public ResponseEntity<?> save(@RequestBody User user) {
		String id = userServiceObj.save(user);

		return ResponseEntity.ok().body("User created with id: " + id);
	}

	@PutMapping("/api/user/{id}")
	public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody User user) {
		userServiceObj.update(user, id);

		return ResponseEntity.ok().body("User has been updated");
	}

	@DeleteMapping("/api/user/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id) {
		userServiceObj.delete(id);

		return ResponseEntity.ok().body("User has been deleted");
	}
}