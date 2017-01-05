package com.jfsaaved.model;

public class Rectangle {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Rectangle Setter has been called.");
		throw(new RuntimeException());
	}
	
	public String setNameAndReturn(String name) {
		this.name = name;
		System.out.println("Rectangle Setter and Return has been called.");
		
		return name + " RETURNED!";
	}


}
