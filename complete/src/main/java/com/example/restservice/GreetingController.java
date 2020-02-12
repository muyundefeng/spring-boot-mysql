package com.example.restservice;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	UserDao userDao;

	@RequestMapping("/")
	public void index(HttpServletResponse response) throws IOException {
		//return "forward:/public/all.html";
		response.sendRedirect("/all.html");
	}

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@PostMapping("/add")
	public String addUser(@RequestParam(value = "name") String name, @RequestParam(value = "email") String email, HttpServletResponse response) throws IOException {
		User user = new User();
		user.setEmail(email);
		user.setName(name);

		userDao.save(user);
		response.sendRedirect("/index.html");
		return "saved";
	}

	@GetMapping("/getAllUser")
	public @ResponseBody Iterable<User> getAllUser(){
		return userDao.findAll();
	}

//	@CrossOrigin(origins = "http://localhost:9000")
//	@GetMapping("/greeting")
//	public Greeting greeting(@RequestParam(required=false, defaultValue="World") String name) {
//		System.out.println("==== in greeting ====");
//		return new Greeting(counter.incrementAndGet(), String.format(template, name));
//	}
//
//	@GetMapping("/greeting-javaconfig")
//	public Greeting greetingWithJavaconfig(@RequestParam(required=false, defaultValue="World") String name) {
//		System.out.println("==== in greeting ====");
//		return new Greeting(counter.incrementAndGet(), String.format(template, name));
//	}
}
