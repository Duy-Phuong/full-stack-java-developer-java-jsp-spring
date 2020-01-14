  package org.studyeasy.spring;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class User {

	public static void main(String[] args) {		
	
		FileSystemXmlApplicationContext context = 
				new FileSystemXmlApplicationContext("Beans.xml");
         Insurance status = context.getBean("myInsurance", Insurance.class);
         System.out.println(status.showStatus());
         System.out.println(status.getCurrentOffer());
         context.close();
	}

} 
