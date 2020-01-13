package org.studyeasy.spring;

public class bikeInsurance implements Insurance {

	private String name;
	private int insuranceID;
    private int validity;
	public bikeInsurance(String name, int insuranceID) {
		this.name = name;
		this.insuranceID = insuranceID;
	}
	public bikeInsurance(){
		this.name = "User";
		this.insuranceID = 000;
	}
	public void setValidity(int validity) {
		this.validity = validity;
	}

	@Override
	public String toString() {
		return "bikeInsurance [name=" + name + ", insuranceID=" + insuranceID + ", validity=" + validity + "]";
	}
	@Override
	public String showStatus() {
		
		return "Hi "+name+", Your Bike is Insured. Your Insurance ID is "+insuranceID;
	}
}
