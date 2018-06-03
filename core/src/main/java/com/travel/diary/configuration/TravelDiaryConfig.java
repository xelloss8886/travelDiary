package com.travel.diary.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:travel.properties")
public class TravelDiaryConfig {

	@Value("${travel.file.directory}")
	private String destinationDir;

	@Bean
	public String destinationDir() {
		return destinationDir;
	}
}
