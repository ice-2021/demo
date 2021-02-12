package com.ice.helloworld.ms.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ice.helloworld.ms.service.HelloworldService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HystrixController {

	private Logger logger = Logger.getLogger(HystrixController.class.getName());

	@Autowired
	private HelloworldService helloworldService;

	@GetMapping("/helloworld/hystrix/service")
	@HystrixCommand(fallbackMethod = "fallbackService2")
	public ResponseEntity<String> getGreeting(@RequestParam("name") String name) {
		logger.info("Calling Service2...........");
		return new ResponseEntity<String>(helloworldService.callService2(name), HttpStatus.OK);
	}

	public ResponseEntity<String> fallbackService2(String name) {
		return new ResponseEntity<String>("Service2 Down. Fallback called..", HttpStatus.OK);
	}

}
