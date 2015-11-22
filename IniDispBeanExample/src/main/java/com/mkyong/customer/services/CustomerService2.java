package com.mkyong.customer.services;


public class CustomerService2 {
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void initIt() throws Exception {
		System.out.println("Init method2 after properties are set : " + message);
	}

	public void cleanUp() throws Exception {
		System.out.println("Spring Container is destroy2! Customer clean up");
	}

}
