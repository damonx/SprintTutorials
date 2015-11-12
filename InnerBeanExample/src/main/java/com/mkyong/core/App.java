package com.mkyong.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mkyong.common.Customer;

public class App {
	public static void main( String[] args )
    {
    	ApplicationContext context = 
    	  new ClassPathXmlApplicationContext("Spring-Customer.xml");

    	Customer cust = (Customer)context.getBean("CustomerBean");
    	System.out.println(cust);
     
    }
}
