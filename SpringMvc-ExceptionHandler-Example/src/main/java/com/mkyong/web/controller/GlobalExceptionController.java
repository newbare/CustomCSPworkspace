package com.mkyong.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.web.exception.CustomGenericException;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(CustomGenericException.class)
	public ModelAndView handleCustomException(CustomGenericException ex) {

		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());
		return model;
	}

	/*@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errMsg", "This is Exception.class");

		return model;

	}*/
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllException(Exception ex) {
		return new ResponseEntity<Object>("badd request", HttpStatus.BAD_REQUEST);

	}
	
}