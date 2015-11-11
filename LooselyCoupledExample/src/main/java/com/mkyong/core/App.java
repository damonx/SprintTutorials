package com.mkyong.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mkyong.output.OutputHelper;

public class App {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "Spring-Common.xml" });

		OutputHelper output = (OutputHelper) context.getBean("OutputHelper");
		output.generateOutput();

	}
}
