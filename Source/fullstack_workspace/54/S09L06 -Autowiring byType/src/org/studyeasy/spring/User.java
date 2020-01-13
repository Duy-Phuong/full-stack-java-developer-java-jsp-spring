package org.studyeasy.spring;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class User {

	public static void main(String[] args) {

		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("Beans.xml");
		bikeInsurance status = context.getBean("myInsurance", bikeInsurance.class);
		System.out.println(status.showStatus());
		System.out.println("Current Offer : " 
							+ status.getCurrentOffer().getOffer());
		System.out.println("Terms and Condition : " 
		                    + status.getCurrentCondition().getCondition());
		context.close();
	}

}
