package com.qa.quickstart.AutomatedTestingExam;

import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Admin\\Desktop\\Eclipse workspace\\AutomatedTestingExam\\src\\test\\java\\AutomatedTestingExam.feature" )


public class Runner {
	
	public static ExtentReports report = new ExtentReports(Constants.getReportfilepath()+Constants.getReportfilename());
	
	public static int counter = 0;
	
	public static void main(String[]args) {
		
		
	
	}
	
}

