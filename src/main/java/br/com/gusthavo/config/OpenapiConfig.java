package br.com.gusthavo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenapiConfig {
	
	@Bean
	OpenAPI customOpenApi() {
		return new OpenAPI().info(new Info()
				.title("RestAPI-Spring3-Revisão")
				.version("v1")
				.description("API que retorna clientes cadastrados")
				.termsOfService("https://www.baeldung.com/spring-rest-openapi-documentation")
				.license(new License().name("Apache 2.0")
						.url("https://www.baeldung.com/spring-rest-openapi-documentation")));
	}
}
