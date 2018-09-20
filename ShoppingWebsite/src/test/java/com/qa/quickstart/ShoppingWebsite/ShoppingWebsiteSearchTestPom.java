package com.qa.quickstart.ShoppingWebsite;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ShoppingWebsiteSearchTestPom {
	
	public ExtentReports report;
	public ExtentTest test;
	
	WebDriver driver = null;
	
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Testing\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		report.flush();
		driver.quit();
	}
	
	@Test
	public void searchTest() {
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\Reports\\ShoppingWebsiteSearchTestReport.html", true);
		test = report.startTest("Verify Search Function");
		
		String search = "dress";
		test.log(LogStatus.INFO, "Browser Launched");
		driver.get("http://automationpractice.com/index.php");
		ShoppingWebsiteHome homePage = PageFactory.initElements(driver, ShoppingWebsiteHome.class);
		homePage.searchClothes(search);
		ShoppingWebsiteSearch searchRes = PageFactory.initElements(driver, ShoppingWebsiteSearch.class);
		String result1 = searchRes.searchResult();
		int i = result1.length();
		String result2 = searchRes.searchResult().substring(1, i-1);
		
		if(result2.equalsIgnoreCase(search)) {
			//report test as pass
			test.log(LogStatus.PASS, "Search Result Successful");
		} else {
			//report test as fail
			test.log(LogStatus.FAIL, "Search Function Error");
		}
		
		report.endTest(test);
		assertTrue(search.equalsIgnoreCase(result2));
		
	}

}
