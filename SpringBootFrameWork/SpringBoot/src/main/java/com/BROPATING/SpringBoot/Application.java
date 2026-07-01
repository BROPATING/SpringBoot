package com.BROPATING.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
//		Dev obj = new Dev(new Car());  // or new Bike()
//		obj.race();

		ApplicationContext context = SpringApplication.run(Application.class, args);

//		Dev obj = (Dev) context.getBean("dev");
		Dev obj = context.getBean(Dev.class); // using @Primary in Car now  we define the @Qualifier in the dev for bike
		obj.race();
	}
}
