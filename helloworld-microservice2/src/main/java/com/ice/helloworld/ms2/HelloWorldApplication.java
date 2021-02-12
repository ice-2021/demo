package com.ice.helloworld.ms2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

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
