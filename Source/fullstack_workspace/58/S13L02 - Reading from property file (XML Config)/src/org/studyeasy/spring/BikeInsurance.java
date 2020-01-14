package org.studyeasy.spring;



public class BikeInsurance implements Insurance {

    public String currentOffer;
	
	@Override
	public String showStatus() {
		
		return "Your Bike is Insured";
	}

	public String getCurrentOffer() {
		return currentOffer;
	}

	public void setCurrentOffer(String currentOffer) {
		this.currentOffer = currentOffer;
	}
  
}


