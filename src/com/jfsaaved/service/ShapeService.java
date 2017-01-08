package com.jfsaaved.service;

import com.jfsaaved.aspect.Loggable;
import com.jfsaaved.model.Circle;
import com.jfsaaved.model.Rectangle;
import com.jfsaaved.model.Triangle;

public class ShapeService {

	private Circle circle;
	private Triangle triangle;
	private Rectangle rectangle;
	
	@Loggable
	public Circle getCircle() {
		System.out.println("Circle getter called");
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
	public Rectangle getRectangle() {
		return rectangle;
	}
	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	
}
