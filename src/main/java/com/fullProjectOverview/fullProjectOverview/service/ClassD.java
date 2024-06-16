package com.fullProjectOverview.fullProjectOverview.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("ClassD")
public class ClassD implements MyInterface {

	@Override
	public void myMethod() {
		// TODO Auto-generated method stub
		System.err.println("classD");

	}

}
