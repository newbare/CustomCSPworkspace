package com.beingjavaguys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Home {
	String message = "Welcome to your 1st Maven Spring project !";

	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public ModelAndView showMessage() {
		System.out.println("from controller");
		return new ModelAndView("hello", "message", message);
	}
	
	@RequestMapping("/hello/{site:.+}")
	public ModelAndView showSiteName(@PathVariable("site") String site) {
		System.out.println("from controller");
		String message1="Welocome to the site::"+site;
		return new ModelAndView("site", "message", message1);
	}
}
