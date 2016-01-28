package com.mkyong.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
@RequestMapping("/")
public class WelcomeController{

	@RequestMapping(method = RequestMethod.GET)
	protected ModelAndView welcomePage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("from welcome controller");
		
		return new ModelAndView("WelcomePage");
	}

}