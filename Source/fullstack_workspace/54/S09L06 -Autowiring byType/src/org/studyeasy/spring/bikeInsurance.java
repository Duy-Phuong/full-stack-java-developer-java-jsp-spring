package org.studyeasy.spring;

public class bikeInsurance {
    private Offers currentOffer;
    private Conditions currentCondition;
	
	public String showStatus() {
		
		return "Your Bike is Insured";
	}

	public Offers getCurrentOffer() {
		return currentOffer;
	}


	public void setCurrentCondition(Conditions currentCondition) {
		this.currentCondition = currentCondition;
	}

	public Conditions getCurrentCondition() {
		return currentCondition;
	}

	public void setCurrentOffer(Offers currentOffer) {
		this.currentOffer = currentOffer;
	}

}
