package com.fullProjectOverview.fullProjectOverview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyInterfaceServiceClass {

	@Autowired
	MyInterface myInterface;
	public void myMethodService() {
		myInterface.myMethod();
	}

}
