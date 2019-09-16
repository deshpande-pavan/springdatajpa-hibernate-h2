package com.springdatajpa.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdatajpa.model.UserContact;
import com.springdatajpa.model.Users;
import com.springdatajpa.model.UsersLog;
import com.springdatajpa.repository.UsersContactRepository;

@RestController
@RequestMapping("/rest/userscontact")
public class UsersContactController {

	@Autowired
	private UsersContactRepository userContactRepo;

	@GetMapping("/all")
	public List<UserContact> getList() {
		return userContactRepo.findAll();
	}

	@GetMapping("/update/{name}")
	public List<UserContact> update(@PathVariable final String name) {
		UserContact userContact = new UserContact();
		Users user = new Users();

		UsersLog log = new UsersLog();
		log.setLog("Hi Youtube");

		UsersLog log1 = new UsersLog();
		log1.setLog("Hi Youtube");
		
		userContact.setPhoneNo((long) 987129);
		
		user.setName(name);
		user.setSalary(20000);
		user.setTeamName("development");
		
		user.setUserslogs(Arrays.asList(log,log1));
		userContact.setUser(user);
		userContactRepo.save(userContact);
		return userContactRepo.findAll();

	}
}
