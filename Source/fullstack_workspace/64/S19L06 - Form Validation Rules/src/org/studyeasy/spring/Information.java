package org.studyeasy.spring;

import java.util.Arrays;

import javax.validation.constraints.Size;


public class Information {
    @Size(min=2, max=20, message="Please Enter your First Name (Min 2 chars, Max 5 chars)")
	private String firstName;
	private String  lastName;
	private String  gender;
	private String  country;
	private String  message;
	private String  visitedCountry[];

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String[] getVisitedCountry() {
		return visitedCountry;
	}

	public void setVisitedCountry(String[] visitedCountry) {
		this.visitedCountry = visitedCountry;
	}

	@Override
	public String toString() {
		return "Information [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", country="
				+ country + ", message=" + message + ", visitedCountry=" + Arrays.toString(visitedCountry) + "]";
	}
	
}
