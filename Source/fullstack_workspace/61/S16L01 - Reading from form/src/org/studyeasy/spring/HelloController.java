package org.studyeasy.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String helloWorld(){
		return "hello";
	}
	
	@RequestMapping("/")
	public String homepage(){
		return "index";
	}
}
