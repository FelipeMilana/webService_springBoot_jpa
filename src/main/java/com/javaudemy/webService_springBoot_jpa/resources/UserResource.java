package com.javaudemy.webService_springBoot_jpa.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaudemy.webService_springBoot_jpa.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Felipe", "felipe@gmail.com", "33069465", "12345");
		return ResponseEntity.ok().body(u);
	}
}
