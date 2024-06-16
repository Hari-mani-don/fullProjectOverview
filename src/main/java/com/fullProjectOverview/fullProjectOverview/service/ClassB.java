package com.fullProjectOverview.fullProjectOverview.service;

import org.springframework.stereotype.Component;

@Component("ClassB")
public class ClassB implements MyInterface {

	@Override
	public void myMethod() {
		// TODO Auto-generated method stub
		System.err.println("classB");

	}

}
