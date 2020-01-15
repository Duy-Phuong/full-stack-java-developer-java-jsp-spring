package org.studyeasy.spring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public ModelAndView helloWorld(@RequestAttribute Information userInfo) {

		ModelAndView model = new ModelAndView("hello");
		model.addObject("firstName", userInfo.getFirstName());
		model.addObject("lastName", userInfo.getLastName());
		model.addObject("gender", userInfo.getGender());
		model.addObject("country", userInfo.getCountry());
		return model;
	}

	@RequestMapping("/")
	public ModelAndView homepage() {
		ModelAndView model = new ModelAndView("index", "info", new Information());
		Map<String, String> gender = new HashMap<String, String>();
		gender.put("Male", "Male");
		gender.put("Female", "Female");
		model.addObject("gender", gender);

		return model;
	}
}
