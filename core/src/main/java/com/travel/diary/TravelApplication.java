package com.travel.diary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.travel.diary")
@EntityScan(basePackages = "com.travel.diary.entity")
public class TravelApplication {
	public static void main(String[] args) {
		SpringApplication.run(TravelApplication.class);
	}
}
