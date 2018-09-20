package com.qa.quickstart.TeaTesting;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Admin\\Desktop\\Eclipse workspace\\TeaTesting\\src\\test\\java\\TeaTesting.feature")

public class Runner {
	
	public static ExtentReports report = new ExtentReports(Constants.getReportfilepath() + Constants.getReportfilename(), true);
	
	public static int counter = 0;
	
	public static void main(String[]args) {
		
	}
}
