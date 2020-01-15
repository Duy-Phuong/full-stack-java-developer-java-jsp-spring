package org.studyeasy.spring;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public ModelAndView helloWorld(@Valid Information userInfo,
			BindingResult result) {

		ModelAndView model = new ModelAndView("hello");
		model.addObject("firstName", userInfo.getFirstName());
		model.addObject("lastName", userInfo.getLastName());
		model.addObject("gender", userInfo.getGender());
		model.addObject("country", userInfo.getCountry());
		model.addObject("message", userInfo.getMessage());
		if(result.hasErrors()){
			System.out.println("Has Errors :(");
		}else{
			System.out.println("Good to Go!");
		}
		return model;
	}

	@RequestMapping("/")
	public ModelAndView homepage() {
		ModelAndView model = new ModelAndView("index", "info", new Information());
		Map<String, String> gender = new HashMap<String, String>();
		Map<String,String> country = new LinkedHashMap<String,String>();
		Map<String,String> visitedCountry = new LinkedHashMap<String,String>();
		gender.put("Male", "Male");
		gender.put("Female", "Female");
		
		country.put("India", "India");
		country.put("USA", "USA");
		country.put("Finland", "Finland");
		
		visitedCountry.put("China", "China");
		visitedCountry.put("Thailand", "Thailand");
		visitedCountry.put("Sweden", "Sweden");
		visitedCountry.put("Japan", "Japan");
		
		model.addObject("gender", gender);
        model.addObject("countries",country);
        model.addObject("visitedCountry", visitedCountry);
		return model;
	}
}




