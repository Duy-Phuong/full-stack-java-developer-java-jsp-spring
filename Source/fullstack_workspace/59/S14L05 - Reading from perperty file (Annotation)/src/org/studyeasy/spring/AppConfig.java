package org.studyeasy.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:org/studyeasy/resourses/OffersList.properties")
public class AppConfig {
	@Bean
	public static PropertySourcesPlaceholderConfigurer  
	PropertySourcesPlaceholderConfigurer(){
		
		return new PropertySourcesPlaceholderConfigurer();
	}
	
    @Bean
    public Offer currentOffer(){
    	return new Offer();
    }
	
	@Bean("myInsurance")
	public BikeInsurance insurance(){
		
		return new BikeInsurance(currentOffer());
	}
	
}
