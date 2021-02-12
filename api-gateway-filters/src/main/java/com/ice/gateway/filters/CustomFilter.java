package com.ice.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {
	public CustomFilter() {
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(Config config) {
		//Custom Pre Filter. Suppose we can extract JWT and perform Authentication
		return (exchange, chain) -> {
			System.out.println("CustomFilter Pre Filter --> " + exchange.getRequest().getQueryParams().get("name"));
			//Custom Post Filter.Suppose we can call error response handler based on error code.
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				System.out.println("CustomFilter Post Filter.");
			}));
		};
	}

	public static class Config {
		
	}
}