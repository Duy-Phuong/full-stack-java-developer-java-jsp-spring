package org.studyeasy.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myInsurance")
public class BikeInsurance implements Insurance {
   
	@Autowired
	 public BikeInsurance(Offers offer) {
			
			System.out.println(offer.getOffer());
		}	
	@Override
	public String showStatus() {
		
		return "Your Bike is Insured";
	}
}

