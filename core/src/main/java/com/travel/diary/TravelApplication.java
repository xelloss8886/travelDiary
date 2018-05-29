package com.travel.diary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.travel.diary")
public class TravelApplication {
	public static void main(String[] args) {
		SpringApplication.run(TravelApplication.class);
	}
}
