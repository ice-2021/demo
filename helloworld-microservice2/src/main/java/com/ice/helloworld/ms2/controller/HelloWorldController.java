package com.ice.helloworld.ms2.controller;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	private Logger logger = Logger.getLogger(HelloWorldController.class.getName());
	@GetMapping("/helloworld2/service2")
	public ResponseEntity<String> getGreeting(@RequestParam("name") String name) {
		logger.info("Entry into Service2....");
		return new ResponseEntity<String>("Welcome to ICE 2021 " + name, HttpStatus.OK);
	}

}
