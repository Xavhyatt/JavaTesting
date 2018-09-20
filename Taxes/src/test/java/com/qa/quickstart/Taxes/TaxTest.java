package com.qa.quickstart.Taxes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TaxTest {
	
	@Test
	public void method1Test() {
		Tax tax = new Tax();
		
		assertEquals(0, tax.method1(0));
		assertEquals(0, tax.method1(14999));
		assertEquals(10, tax.method1(15000));
		assertEquals(10, tax.method1(19999));
		assertEquals(15, tax.method1(20000));
		assertEquals(15, tax.method1(29999));
		assertEquals(20, tax.method1(30000));
		assertEquals(20, tax.method1(44999));
		assertEquals(25, tax.method1(45000));

	}
	
	@Test
	public void method2Test() {
		Tax tax1 = new Tax();
		
		assertEquals(0, tax1.method2(0),0.01);
		assertEquals(0, tax1.method2(14999),0.01);
		assertEquals(1500, tax1.method2(15000),0.01);
		assertEquals(1999.9, tax1.method2(19999),0.01);
		assertEquals(3000, tax1.method2(20000),0.01);
		assertEquals(4499.85, tax1.method2(29999),0.01);
		assertEquals(6000, tax1.method2(30000),0.01);
		assertEquals(8999.80, tax1.method2(44999),0.01);
		assertEquals(11250, tax1.method2(45000),0.01);
		
		
		
	}

}
