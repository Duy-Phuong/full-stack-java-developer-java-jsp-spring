package org.studyeasy.spring;

public class carInsurance implements Insurance {

	@Override
	public String showStatus() {
		
		return "Your Car is Insured";
	}

}
