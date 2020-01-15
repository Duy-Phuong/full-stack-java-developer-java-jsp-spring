package org.studyeasy.spring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public ModelAndView helloWorld(HttpServletRequest request){
		String name = request.getParameter("name");
		List<String> courses = getList();
		Date date = new Date();
		
		ModelAndView model = new ModelAndView("hello");
		model.addObject("name",name);
		model.addObject("courses",courses);
		model.addObject("date",date);
		return model;
	}
	
	@RequestMapping("/")
	public String homepage(){
		return "index";
	}
	
	
	
	private List<String> getList() {

		List<String> list = new ArrayList<String>();
		list.add("Course on Spring Framework");
		list.add("JSP, Servlets and JSTL");
		list.add("JAVA for Beginners");
		list.add("Test and Improve your JAVA Skills");
		list.add("JSF 2.2");
		list.add("Multithreading,Java Generics,Collections and Lamda Exp");
		list.add("Course On CodeIgniter");

		return list;

	}
}
