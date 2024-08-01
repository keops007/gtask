package com.run.gtask;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GtaskApplication {

	@Value("${spring.profiles.active}")
	private String activeProfile;

	public static void main(String[] args) {
		SpringApplication.run(GtaskApplication.class, args);
	}

	@PostConstruct
	public void init() {
		System.out.println("Active Profile: " + activeProfile);
	}
}

