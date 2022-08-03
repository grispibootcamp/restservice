package com.grispi.bootcamp.restservice.controller;

import com.grispi.bootcamp.restservice.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	private static final List<Greeting> greetings = new ArrayList();

	@GetMapping("/greetings")
	public List<Greeting> list(@RequestParam(value = "name", defaultValue = "World") String name) {

		return greetings;
	}

	@PostMapping("/greetings")
	public Greeting create(@RequestParam(value = "name", defaultValue = "World") String name) {

		Greeting g = new Greeting(counter.incrementAndGet(), String.format(template, name));

		greetings.add(g);

		return g;
	}

	@GetMapping("/")
	public String hello(@RequestParam(value = "xyz") String xyz) {

		return "Hello World: " + removeEmptySpacesAndMakeStringLowercase(xyz);
	}

	@PostMapping("/")
	public String post(@RequestBody String xyz) {
		return "Hello World: " + xyz;
	}

	private String removeEmptySpacesAndMakeStringLowercase(String initial) {
		return initial.replace(" ", "").toLowerCase(Locale.ROOT);
	}
}