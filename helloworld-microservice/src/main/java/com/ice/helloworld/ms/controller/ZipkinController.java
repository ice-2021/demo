package com.ice.helloworld.ms.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ice.helloworld.ms.feign.service.HelloworldFeignService2;

@RestController
public class ZipkinController {
	private Logger logger = Logger.getLogger(ZipkinController.class.getName());
	
	@Autowired
	private HelloworldFeignService2 service2;

	@GetMapping("/helloworld/zipkin")
	public ResponseEntity<String> getGreeting(@RequestParam("name") String name) {
		logger.info("Service1 calling Service2.....");
		return new ResponseEntity<String>(service2.callService2(name), HttpStatus.OK);
	}
}
