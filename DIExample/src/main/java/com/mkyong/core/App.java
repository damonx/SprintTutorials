package com.mkyong.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mkyong.output.OutputHelper;

public class App {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("construtorDI.xml" );
		OutputHelper output = (OutputHelper) context.getBean("OutputHelper");
		output.generateOutput();
		
		@SuppressWarnings("resource")
		ApplicationContext context1 = new ClassPathXmlApplicationContext( "setterDI.xml" );
		OutputHelper output1 = (OutputHelper) context1.getBean("OutputHelper");
		output1.generateOutput();
	}
}
