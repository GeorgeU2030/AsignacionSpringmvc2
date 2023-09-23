package com.project2.project2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.project2.project2.controller")
public class Project2Application {

	public static void main(String[] args) {
		SpringApplication.run(Project2Application.class, args);
	}

}
