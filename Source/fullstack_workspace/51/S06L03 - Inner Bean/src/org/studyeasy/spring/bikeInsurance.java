package org.studyeasy.spring;

public class bikeInsurance implements Insurance {
    private Offers CurrentOffer;
	
	@Override
	public String showStatus() {
		
		return "Your Bike is Insured";
	}

	public Offers getCurrentOffer() {
		return CurrentOffer;
	}

	public void setCurrentOffer(Offers currentOffer) {
		CurrentOffer = currentOffer;
	}

}
