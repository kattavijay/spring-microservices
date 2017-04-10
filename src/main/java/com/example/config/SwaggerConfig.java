package com.example.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.google.common.base.Predicate;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = "com.example.services")
public class SwaggerConfig {

	@Bean
	public Docket restfulApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("service-api")
				.select()
				.paths(paths())
				.build()
				.apiInfo(apiInfo());
	}

	private Predicate<String> paths() {
		return or(
				regex("/add.*"),regex("/g.*"),regex("/us.*"));
	}

	private ApiInfo apiInfo() {

		return new ApiInfo(
				"User Data ",
				"User data Interface",
				"1.0",
				"http://javamix.net/blog",
				"katta.vijayk@gmail.com",
				"Licence",
				"http://javamix.net/blog"
				);
	}

}