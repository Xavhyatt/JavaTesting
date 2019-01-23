package com.qa.quickstart.TeaTesting;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Stepper {
	public ExtentReports report;
	public ExtentTest test;
	final private String driverType = "webdriver.chrome.driver";
	final private String fileLoc = "C:\\\\Users\\\\Admin\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe";
	WebDriver driver = null;
	
	@Before
	public void setUp() {
		Runner.counter++;
		report = Runner.report;
		test = report.startTest("TeaTesting" + Runner.counter);
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
	
	@Given("^the correct web address$")
	public void the_correct_web_address() {
		driver.get(Constants.getUrl1());
		test.log(LogStatus.INFO, "Opened the Tea Tasting Homepage");
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() {
		TeaHome teaHome = PageFactory.initElements(driver, TeaHome.class);
		teaHome.goToMenu();
		test.log(LogStatus.INFO, "Attempt to Nav to Menu page using Navbar");  
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() {
		WebElement MenuTitle = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914921\"]/div/h1"));
		if(MenuTitle.getText().equals("Menu")) {
			test.log(LogStatus.PASS, "On the Menu Page");
		} else {
			test.log(LogStatus.FAIL, "Incorrect Page");
		}
		assertTrue(MenuTitle.getText().equals("Menu"));
	   
	    
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() {
		TeaHome teaHome = PageFactory.initElements(driver, TeaHome.class);
		teaHome.goToCheckOut();
		test.log(LogStatus.INFO, "Attempt to Nav to CheckOut page using Navbar");
	
	  
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page()  {
		WebElement payWith = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000451989411\"]/div/p/span/strong"));
		if(payWith.getText().equals("Pay with Credit Card or Log In")) {
			test.log(LogStatus.PASS, "On the Checkout Page");
		} else {
			test.log(LogStatus.FAIL, "Incorrect Page");
		}
		
		assertTrue(payWith.getText().equals("Pay with Credit Card or Log In"));
	    // Write code here that turns the phrase above into concrete actions
	    
	}


}
