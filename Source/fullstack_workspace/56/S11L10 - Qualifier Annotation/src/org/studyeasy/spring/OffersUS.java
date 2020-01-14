package org.studyeasy.spring;

import org.springframework.stereotype.Component;

@Component("offersUS")
public class OffersUS implements Offers {

	@Override
	public String getOffer() {
		
		return "Get 15% off on next purcharse (US)";
	}

}
