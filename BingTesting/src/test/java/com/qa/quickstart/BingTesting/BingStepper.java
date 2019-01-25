package com.qa.quickstart.BingTesting;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BingStepper {
	
	ExtentReports report;
	ExtentTest test;
	final private  String driverType = "webdriver.chrome.driver";
	final private String fileLoc = "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe";
	WebDriver driver = null;
	String searchTerm = "";
	String searchTerm1 ="";
	
	@Before
	public void setUp() {
		Runner.counter++;
		report = Runner.report;
		test = report.startTest("BingTesting" + Runner.counter);
		System.setProperty(driverType, fileLoc);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
		report.endTest(test);
		report.flush();
	}
	
	
	
	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String arg1) {
		driver.get(arg1);
		test.log(LogStatus.INFO, "Opened the Bing Homepage");
	    }

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) throws InterruptedException  {
		
		BingPage bingPage = PageFactory.initElements(driver, BingPage.class);
		bingPage.searchFor(arg1);
		test.log(LogStatus.INFO, "Search term inputted and submitted");
		searchTerm = arg1;
		Thread.sleep(1000);
	}

	@Then("^I am taken to a list of data for that search$")
	public void i_am_taken_to_a_list_of_data_for_that_search()  {
		
		/*WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(Constants.getUrl1())));*/
		
		
		
		
		String c_url = driver.getCurrentUrl();
	/*	for (int i = 0; i< searchTerm.length(); i++) {
			searchTerm1 = searchTerm.replace(" ", "+");
				
		}*/
		if (c_url.contains(searchTerm1)) {
			test.log(LogStatus.PASS, "Search Successful");
			HelperMethods.screenshot(driver);
			test.log(LogStatus.PASS, "Screen Shot: " + test.addScreenCapture(HelperMethods.destination1));
		} else {
			test.log(LogStatus.FAIL, "Search Unsuccessful");
			HelperMethods.screenshot(driver);
			test.log(LogStatus.FAIL, "Screen Shot: " + test.addScreenCapture(HelperMethods.destination1));

		}

		System.out.println(c_url);
		System.out.println(searchTerm1);
		assertTrue(c_url.contains(searchTerm1));
	  
	}


}
