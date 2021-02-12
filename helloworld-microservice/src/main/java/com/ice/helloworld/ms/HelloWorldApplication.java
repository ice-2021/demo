package com.ice.helloworld.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}
	
	@Bean 
	public Sampler defaultSampler(){
		return Sampler.ALWAYS_SAMPLE;
	}

}
