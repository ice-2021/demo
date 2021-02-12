package com.ice.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

@EnableEurekaClient
@SpringBootApplication
public class ApiGatewayFiltersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayFiltersApplication.class, args);
	}

	@Bean
	KeyResolver userKeyResolver() {
		return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("name"));
	}

	@Bean
	public GlobalFilter globalFilter() {
		return (exchange, chain) -> {
			System.out.println("Pre Global filter" + exchange.getRequest().getQueryParams().get("name"));
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				System.out.println("Post Global filter");
			}));
		};
	}

}
