package com.myprojects.spring.examples.SpringMVCRestWS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.myprojects.spring.examples.SpringMVCRestWS")
public class SpringMvcRestWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcRestWsApplication.class, args);
	}
}
