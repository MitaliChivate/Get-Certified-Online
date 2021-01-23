package com.cg;

import java.util.Collections;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableJpaAuditing
@SpringBootApplication
public class PaymentMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentMicroserviceApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				   .select()
				   .paths(PathSelectors.any())
				   .apis(RequestHandlerSelectors.basePackage("com.cg"))
				   .build()
				   .apiInfo(myApiInfo());
	}
	
	private ApiInfo myApiInfo() {
		Contact contact=new Contact("Tejaswi Midgule","/stock","tmidgule98@gmail.com");
		ApiInfo apiInfo=new ApiInfo("Spring With Swagger Api","Api Creation","1.0","Free to use",contact,
				"API licence","/limits",Collections.emptyList());
		
		return apiInfo;
	}

}
