package com.mkyong.core;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	private Collection<String> collection;

	@BeforeClass
	public static void oneTimeSetUp() {
		// one-time initialization code
		System.out.println("@BeforeClass - oneTimeSetUp");
	}

	@AfterClass
	public static void oneTimeTearDown() {
		// one-time cleanup code
		System.out.println("@AfterClass - oneTimeTearDown");
	}

	@Before
	public void setUp() {
		collection = new ArrayList<String>();
		System.out.println("@Before - setUp");
	}

	@After
	public void tearDown() {
		collection.clear();
		System.out.println("@After - tearDown");
	}

	@Test
	public void testEmptyCollection() {
		assertThat(collection).isEmpty();
		assertThat(collection).hasSize(0);
		System.out.println("@Test - testEmptyCollection");
	}

	@Test
	public void testOneItemCollection() {
		collection.add("itemA");
		assertThat(collection).hasSize(1);
		System.out.println("@Test - testOneItemCollection");
	}

	@Test(expected = ArithmeticException.class)
	public void divisionWithException() {
		int i = 1 / 0;
		System.out.println(i);
	}
	
	@Ignore("Not Ready to Run")  
	@Test
	public void divisionWithException1() {  
	  System.out.println("Method is not ready yet");
	}  
    
	
	@Test(timeout = 5000)  
	public void infinity() {  
		while (true);  
	}  

}
