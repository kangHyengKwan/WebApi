package com.example.sandbox.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class Swagger2Config {

  private static final ApiInfo API_INFO = new ApiInfo(
      "Web API", 
      "This is Web API", 
      "1.0.0",
      "http://localhost:8080/api", 
       new Contact("KangHK", "https://github.com/kangHyengKwan", null),
      "Apache License, Version 2.0", 
      "http://www.apache.org/licenses/LICENSE-2.0");

  @Bean
  public Docket swaggerSpringMvcPlugin() {
      return new Docket(DocumentationType.SWAGGER_2)
              .groupName("web-api")
              .select()
              .build()
              .apiInfo(API_INFO);
  }

}