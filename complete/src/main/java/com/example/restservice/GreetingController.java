package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	UserDao userDao;

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@PostMapping("/add")
	public String addUser(@RequestParam(value = "name") String name, @RequestParam(value = "email") String email){
		User user = new User();
		user.setEmail(email);
		user.setName(name);

		userDao.save(user);

		return "saved";
	}

	@GetMapping("/getAllUser")
	public @ResponseBody Iterable<User> getAllUser(){
		return userDao.findAll();
	}
}
