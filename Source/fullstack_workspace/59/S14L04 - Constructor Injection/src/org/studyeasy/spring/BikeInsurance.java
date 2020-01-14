package org.studyeasy.spring;



public class BikeInsurance implements Insurance {
  
  Offer offer;

	public Offer getOffer() {
	return offer;
}

	public BikeInsurance(Offer offer) {
	
	this.offer = offer;
}

	@Override
	public String showStatus() {
		
		return "Your Bike is Insured";
	}
	
}
