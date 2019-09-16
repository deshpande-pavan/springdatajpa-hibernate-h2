package com.springdatajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdatajpa.model.Users;
import com.springdatajpa.model.UsersLog;
import com.springdatajpa.repository.UsersLogRepository;

@RestController
@RequestMapping("/users/log")
public class UsersLogController {

	@Autowired
	private UsersLogRepository userLogRepo;

	@GetMapping("/all")
	public List<UsersLog> getAll() {
		return userLogRepo.findAll();
	}

	@GetMapping("/update/{name}")
	public List<UsersLog> update(@PathVariable final String name) {
		Users user = new Users();
		user.setName(name);
		user.setSalary(10002);
		user.setTeamName("devops");

		UsersLog log = new UsersLog();
		log.setUser(user);
		log.setLog("Hi Youtube");

		UsersLog log1 = new UsersLog();
		log1.setUser(user);
		log1.setLog("hello youtube");

		userLogRepo.save(log);
		userLogRepo.save(log1);

		return userLogRepo.findAll();

	}
}
