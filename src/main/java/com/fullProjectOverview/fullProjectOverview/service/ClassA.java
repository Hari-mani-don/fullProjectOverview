package com.fullProjectOverview.fullProjectOverview.service;

import org.springframework.stereotype.Component;

@Component("ClassA")
public class ClassA implements MyInterface {

	@Override
	public void myMethod() {
		System.err.println("classA");
	}

}
