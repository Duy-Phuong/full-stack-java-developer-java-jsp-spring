package org.studyeasy.spring;

import org.springframework.stereotype.Component;

@Component("Offer")
public class Offers {
	public String getOffer(){
		return "Get 10% off on your next purchase";
	}
}
