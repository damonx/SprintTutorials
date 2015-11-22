package com.mkyong.common;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mkyong.customer.services.CustomerService;
import com.mkyong.customer.services.CustomerService2;

public class App 
{
    public static void main( String[] args )
    {
    	ConfigurableApplicationContext context = 
    		new ClassPathXmlApplicationContext(new String[] {"Spring-Customer.xml"});
	
    	CustomerService cust = (CustomerService)context.getBean("customerService");
    	
    	System.out.println(cust);
    	
    	CustomerService2 cust2 = (CustomerService2)context.getBean("customerService2");
    	System.out.println(cust2);
    	
    	context.close();
    }
}
