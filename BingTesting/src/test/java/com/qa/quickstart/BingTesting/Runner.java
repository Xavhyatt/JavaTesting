package com.qa.quickstart.BingTesting;

import org.junit.runner.RunWith;
import com.relevantcodes.extentreports.ExtentReports;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Admin\\Desktop\\Java Testing\\JavaTesting\\BingTesting\\src\\test\\java\\parameter.feature" )

public class Runner {
	
	public static ExtentReports report = new ExtentReports(Constants.getReportfilepath() + Constants.getReportfilename(), true);
	
	public static int counter = 0;
	
	public static void main(String[]args) {
		
	}
}
