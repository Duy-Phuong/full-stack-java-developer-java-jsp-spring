package org.studyeasy.spring;


import java.util.Set;

public class bikeInsurance implements Insurance {

	public bikeInsurance(Set<String> members){
		System.out.println("List of members under insurance");
		for (String member : members) {
			System.out.println(member);
		}
	}
	@Override
	public String showStatus() {
		
		return "Your Bike is Insured";
	}
	
}
