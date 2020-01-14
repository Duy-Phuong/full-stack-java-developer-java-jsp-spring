package org.studyeasy.spring;

import org.springframework.stereotype.Component;

@Component("myInsurance")
public class BikeInsurance implements Insurance{
    
	@Override
	public String showStatus() {
		
		return "Your Bike is Insured";
	}

}
