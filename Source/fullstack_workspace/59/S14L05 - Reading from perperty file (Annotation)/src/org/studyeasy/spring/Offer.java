package org.studyeasy.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Offer {
	
   public String currentOffer = "No Offers";

public String getCurrentOffer() {
	return currentOffer;
}
@Autowired
	public void setCurrentOffer(@Value("${offers.USA}") String currentOffer) {
	this.currentOffer = currentOffer;
}
}
