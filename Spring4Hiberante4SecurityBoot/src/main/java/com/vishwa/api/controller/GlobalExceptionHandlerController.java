package com.vishwa.api.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

/**
 * The Class GlobalExceptionHandlerController
 * @author vishwa
 */
@ControllerAdvice
public class GlobalExceptionHandlerController {

	private static Logger logger = Logger.getLogger(GlobalExceptionHandlerController.class);

	/**
	 * This Method is used to handle the exception in case of any error occurred
	 * and defined custom error code.
	 * 
	 * Provides handling for standard Spring MVC exceptions.
	 * 
	 * @param ex
	 *            the target exception
	 * @param request
	 *            the current request
	 */
	/*@ExceptionHandler(value = {NoSuchRequestHandlingMethodException.class, HttpRequestMethodNotSupportedException.class, HttpMediaTypeNotSupportedException.class,
			HttpMediaTypeNotAcceptableException.class, MissingServletRequestParameterException.class, ConversionNotSupportedException.class, TypeMismatchException.class,
			HttpMessageNotReadableException.class, HttpMessageNotWritableException.class, Exception.class })
	public ResponseEntity<Object> handleException(Exception ex) {
		HttpStatus status;
		if (ex instanceof NoSuchRequestHandlingMethodException) {
			status = HttpStatus.NOT_FOUND;
		} else if (ex instanceof HttpRequestMethodNotSupportedException) {
			status = HttpStatus.METHOD_NOT_ALLOWED;
		} else if (ex instanceof HttpMediaTypeNotSupportedException) {
			status = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
		} else if (ex instanceof HttpMediaTypeNotAcceptableException) {
			status = HttpStatus.NOT_ACCEPTABLE;
		} else if (ex instanceof HttpMessageNotWritableException || ex instanceof ConversionNotSupportedException) {
			status = HttpStatus.UNPROCESSABLE_ENTITY;
		} else if (ex instanceof TypeMismatchException || ex instanceof HttpMessageNotReadableException || ex instanceof MissingServletRequestParameterException
				|| ex instanceof ServletRequestBindingException) {
			status = HttpStatus.BAD_REQUEST;
		} else {
			logger.warn(" handleException() Unknown exception type: " + ex.getClass().getName());
			status = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<Object>("Invaild request", status);
	}*/
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllException(Exception ex) {
		logger.info("handleAllException called::::::::");
		return new ResponseEntity<Object>("Invaild request", HttpStatus.BAD_REQUEST);

	}
}
