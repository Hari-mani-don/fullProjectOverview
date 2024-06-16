package com.fullProjectOverview.fullProjectOverview.configure;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fullProjectOverview.fullProjectOverview.service.MyInterface;

@Configuration
public class ConfigureClass {

	
	@Autowired
	ApplicationContext context;

	@Value("${myInterfaceBean.className}")
	String className;
	
	
	@Bean
	public MyInterface myInterface() throws BeansException, ClassNotFoundException {
	return (MyInterface) context.getBean(Class.forName(className));
	}
}
