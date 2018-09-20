package com.qa.quickstart.Taxes;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class ParameterisedTaxTest {
	
	

	
	@Parameters
	public static List<Double[]> data() {
		return Arrays.asList(new Double[][] {{0.0,0.0},{0.0,14999.0},{1500.0,15000.0},
			{1999.9,19999.0},{3000.0,20000.0},{4499.85,29999.0},{6000.0,30000.0},
			{8999.80,44999.0},{11250.0,45000.0}});
		
		}
	
	private double Input1;
	private double Expected;

	public ParameterisedTaxTest(double expected, double salary) {
		Input1 = salary;
		Expected = expected;
	}

	@Test
	public void testm2() {
		Tax tax2 = new Tax();
		
		assertEquals("Actual taxed amount does not equal expected taxed amount",Expected, tax2.method2(Input1),0.01);
		
	}
				
				
				
	}