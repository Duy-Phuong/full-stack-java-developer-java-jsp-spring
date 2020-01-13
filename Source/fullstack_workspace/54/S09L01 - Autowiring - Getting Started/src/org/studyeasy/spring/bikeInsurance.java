package org.studyeasy.spring;

public class bikeInsurance implements Insurance {
   
    
	public bikeInsurance(Offers offer) {
		
		System.out.println(offer.getOffer());
	}
	
	@Override
	public String showStatus() {
		
		return "Your Bike is Insured";
	}

}
