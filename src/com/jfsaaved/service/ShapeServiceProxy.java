package com.jfsaaved.service;

import com.jfsaaved.aspect.LoggingAspect;
import com.jfsaaved.model.Circle;

public class ShapeServiceProxy extends ShapeService {
	
	public Circle getCircle() {
		new LoggingAspect().newLoggingAdvice();
		return super.getCircle();
	}

}
