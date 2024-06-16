package com.fullProjectOverview.fullProjectOverview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullProjectOverview.fullProjectOverview.service.MyInterfaceServiceClass;

@RestController
public class MyMethodController {

	@Autowired
	MyInterfaceServiceClass myInterfaceServiceClass;

	@GetMapping("/my-method")
	public void handleMyMethod() {
		myInterfaceServiceClass.myMethodService();
	}
}
