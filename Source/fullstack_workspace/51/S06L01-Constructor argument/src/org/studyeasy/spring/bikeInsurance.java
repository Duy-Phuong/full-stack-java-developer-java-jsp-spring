package org.studyeasy.spring;

public class bikeInsurance implements Insurance {
    private Offers offer;
	public bikeInsurance(Offers offer) {
		this.offer = offer;
		System.out.println(offer.getOffer());
	}
	
	public bikeInsurance(){
		
	}
	@Override
	public String showStatus() {
		
		return "Your Bike is Insured";
	}

}
