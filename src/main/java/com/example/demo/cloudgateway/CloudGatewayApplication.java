package com.example.demo.cloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;

@SpringBootApplication
@EnableEurekaClient
public class CloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayApplication.class, args);
		System.out.println("Gateway Sucefully...");
	}
	
	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomiser()
	{
		return factory->factory.configureDefault(
				id->new Resilience4JConfigBuilder(id)
					.circuitBreakerConfig(
							CircuitBreakerConfig.ofDefaults()
							).build()
					
				);
		
	}
	

}
