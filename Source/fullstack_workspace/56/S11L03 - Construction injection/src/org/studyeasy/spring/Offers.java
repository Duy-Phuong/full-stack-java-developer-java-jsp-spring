package org.studyeasy.spring;

import org.springframework.stereotype.Component;

@Component("offer")
public class Offers {
	public String getOffer(){
		return "Get 10% off on your next purchase";
	}
}
