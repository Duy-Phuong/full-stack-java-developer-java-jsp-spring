package org.studyeasy.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class AppConfig {

	@Bean("myInsurance")
	public BikeInsurance insurance(){
		return new BikeInsurance();
	}
	
}
