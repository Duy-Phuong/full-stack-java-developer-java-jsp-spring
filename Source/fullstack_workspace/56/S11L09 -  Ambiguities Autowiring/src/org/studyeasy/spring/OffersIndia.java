package org.studyeasy.spring;

import org.springframework.stereotype.Component;

@Component
public class OffersIndia implements Offers{
	
	@Override
	public String getOffer(){
		return "Get 10% off on your next purchase";
	}
}
