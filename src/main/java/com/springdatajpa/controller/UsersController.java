package com.springdatajpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdatajpa.model.Users;
import com.springdatajpa.repository.UserJpaRepository;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UserJpaRepository userRepository;

	@GetMapping("/all")
	public List<Users> findAll() {
		return userRepository.findAll();
	}

	@GetMapping("/{name}")
	public List<Users> findByName(@PathVariable String name) {
		Optional<List<Users>> optionalList = userRepository.findByName(name);
		return optionalList
//				.orElse(new ArrayList<Users>())
				.orElseThrow(() -> new RuntimeException("User not found"));

	}

	@PostMapping("/load")
	public List<Users> load(@RequestBody final Users user) {
		userRepository.save(user);
		return userRepository.findAll();
	}

	@PutMapping("/id/{id}/{name}")
	public Users update(@PathVariable("id") final Long id, @PathVariable("name") final String name) {
		Optional<Users> user = userRepository.findById(id);
		Users user1 = null;
		if (user.isPresent()) {
			user1 = user.get();
			user1.setName(name);
		}
		return userRepository.save(user1);
	}
}
