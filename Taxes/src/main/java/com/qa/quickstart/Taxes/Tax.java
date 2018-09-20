package com.qa.quickstart.Taxes;

public class Tax {
	
	
	
	public int method1(double input1) {
		int tax = 0;
		
		if (input1>=15000 & input1 <=19999) {
			tax = 10;
		}
		if (input1 >= 20000 & input1 <=29999) {
			tax = 15;
		}
		if (input1 >= 30000 & input1 <=44999) {
			tax=20;
		}
		if (input1>=45000) {
			tax=25;
		}
		
		return tax;
	}
	
	public double method2(double input1) {
		
		double tax1 = method1(input1);
		
		double taxAmount = input1 * (tax1/100);
				
		return taxAmount;
		
		
	}
}
