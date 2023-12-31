package com.example.productmono;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;



@SpringBootApplication
@ComponentScan("com")
@EnableJpaRepositories("com")
@EntityScan("com")
@EnableEurekaClient
@OpenAPIDefinition
public class UserDashboardMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDashboardMicroserviceApplication.class, args);
	}
	@Bean("webclient")
	@LoadBalanced
	public WebClient.Builder getWebClient(){
		return WebClient.builder();
	}

}
