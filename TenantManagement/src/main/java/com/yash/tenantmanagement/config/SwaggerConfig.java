package com.yash.tenantmanagement.config;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SwaggerConfig {

	//Swagger Documentation
		@Bean
		public Docket api() {
			return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.any())
					.paths(PathSelectors.any())
					.build()
					.apiInfo(apiEndPointsInfo());
		}
		
		@Bean
		public ApiInfo apiEndPointsInfo() {
			return new ApiInfoBuilder()
					.title("Tenant Management System")
					.description("A tenant management system is software designed to help property managers efficiently")
					.contact(new Contact())
					.version("1.0.0")
					.build();
		}
}
