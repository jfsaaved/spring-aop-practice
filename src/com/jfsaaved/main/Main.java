package com.jfsaaved.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jfsaaved.service.FactoryService;
import com.jfsaaved.service.ShapeService;

public class Main {
	

	private static ApplicationContext context;

	public static void main(String[] args) {
		/*
		context = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService = context.getBean("shapeService", ShapeService.class);
		shapeService.getCircle().setName("Circle - Dummy Name");
		//shapeService.getRectangle().setNameAndReturn("Rectangle - Dummy Name");
		System.out.println(shapeService.getCircle().getName());
		//System.out.println(shapeService.getTriangle().getName());*/
		
		/*
		 * Does not uses spring.xml below
		 * Using custom Factory Service
		 */
		
		FactoryService factoryService = new FactoryService();
		ShapeService shapeService = (ShapeService) factoryService.getBean("shapeService");
		
		
		
		shapeService.getCircle();
		
	}

}
