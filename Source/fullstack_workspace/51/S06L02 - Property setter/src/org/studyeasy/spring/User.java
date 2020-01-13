package org.studyeasy.spring;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class User {

	public static void main(String[] args) {
		 
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
	
         Insurance status = context.getBean("myInsurance", Insurance.class);
         System.out.println(status.showStatus());
         context.close();
	}

}
