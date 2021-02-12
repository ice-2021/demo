package com.ice.helloworld.ms.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ice.helloworld.ms.feign.service.HelloworldFeignService2;

@Service
public class HelloworldServiceImpl implements HelloworldService {
	
	private Logger logger = Logger.getLogger(HelloworldServiceImpl.class.getName());

	@Autowired
	private HelloworldFeignService2 helloworldFeignService2;

	@Override
	public String callService2(String name) {
		logger.info("Service1 calling Service2.....");
		return helloworldFeignService2.callService2(name);
	}
}
