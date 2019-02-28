package com.springmvc.anno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HelloWorldController {

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getMessage(ModelAndView model) {
		model.addObject("greeting","Hello World from Spring MVC Annotatino.");
		model.setViewName("welcome");
		return model;
	}
	
}
