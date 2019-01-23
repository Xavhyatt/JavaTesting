package com.qa.quickstart.AdvancedAutomatedTestingExam;



import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Admin\\Desktop\\Java Testing\\JavaTesting\\AdvancedAutomatedTestingExam\\src\\test\\java" )


public class Runner {
	
	public static ExtentReports report = new ExtentReports(Constants.reportFilepath+Constants.reportFileName);
	
	public static int counter = 0;
	
	public static void main(String[]args) {
		
		
	
	}
	
}

