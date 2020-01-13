package org.studyeasy.spring;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("offers")
@Scope("prototype")
public class Offers {
	private String offer = new String("No current offers");

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}
}
