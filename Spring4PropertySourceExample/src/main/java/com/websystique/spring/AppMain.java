package com.websystique.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.websystique.spring.service.FileService;

public class AppMain {
	
	public static void main(String args[]){
		//AbstractApplicationContext  context = new AnnotationConfigApplicationContext(AppConfig.class);
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
		FileService service = (FileService) context.getBean("fileService");
		
		service.readValues();
		context.close();
	}
	
}
