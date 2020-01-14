package org.studyeasy.spring;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class User {

	public static void main(String[] args) {		
	
		FileSystemXmlApplicationContext context = 
				new FileSystemXmlApplicationContext("BeanScope.xml");
		
		Offers offer1 = context.getBean("offers",Offers.class);
		Offers offer2 = context.getBean("offers",Offers.class);
		
		offer1.setOffer("Get 10% OFF this month");
		System.out.println("Offer 1 : "+offer1.getOffer());
		System.out.println("Offer 2 : "+offer2.getOffer());
	
        context.close();
	}

}
