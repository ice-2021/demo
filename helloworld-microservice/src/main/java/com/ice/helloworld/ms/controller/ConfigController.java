package com.ice.helloworld.ms.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigController {
	@Value("${welcome.msg}")
	String msg;

	@GetMapping("/helloworld/config/getGreeting")
	public ResponseEntity<String> getGreetingFromConfig(@RequestParam("name") String name) {
		return new ResponseEntity<String>(msg  +" "+ name, HttpStatus.OK);
	}

	@PostMapping("/helloworld/config/showGreeting")
	public ResponseEntity<String> showGreetingFromConfig(@RequestBody HashMap<String, String> requestBody) {
		return new ResponseEntity<String>("Welcome to ICE 2021 " + requestBody.get("name"), HttpStatus.OK);
	}
}
