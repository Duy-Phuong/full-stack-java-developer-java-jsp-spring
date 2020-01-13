package org.studyeasy.spring;

import java.util.Map;

public class bikeInsurance implements Insurance {

	private Map<String,String> members;

	@Override
	public String showStatus() {
		
		return "Your Bike is Insured";
	}

	public Map<String, String> getMembers() {
		return members;
	}

	public void setMembers(Map<String, String> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "bikeInsurance [members=" + members + "]";
	}
	
}
