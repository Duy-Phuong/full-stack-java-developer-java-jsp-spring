package org.studyeasy.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class BikeInsurance implements Insurance {
   
	@Autowired
	 public BikeInsurance(Offers offer123) {
			
			System.out.println(offer123.getOffer());
		}
		
	@Override
	public String showStatus() {
		
		return "Your Bike is Insured";
	}

}
