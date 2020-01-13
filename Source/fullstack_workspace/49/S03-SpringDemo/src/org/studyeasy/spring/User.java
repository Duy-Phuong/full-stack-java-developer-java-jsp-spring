package org.studyeasy.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class User {

	public static void main(String[] args) {
		
	
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("/org/studyeasy/spring/Beans.xml");
         Insurance status = context.getBean("myInsurance", Insurance.class);
         System.out.println(status.showStatus());
         context.close();
	}

}
