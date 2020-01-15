package org.studyeasy.spring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String helloWorld(@RequestAttribute Information userInfo,ModelMap model) {

		
		model.addAttribute("firstName", userInfo.getFirstName());
		model.addAttribute("lastName", userInfo.getLastName());
		model.addAttribute("gender", userInfo.getGender());
		return "hello";
	}

	@RequestMapping("/")
	public String homepage(Model model) {
		
	    model.addAttribute("info", new Information());
		Map<String, String> gender = new HashMap<String, String>();
		gender.put("Male", "Male");
		gender.put("Female", "Female");
	    model.addAttribute("gender", gender);

		return "index";
	}
}
