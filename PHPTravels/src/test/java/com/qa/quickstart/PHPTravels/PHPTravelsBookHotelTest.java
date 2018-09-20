package com.qa.quickstart.PHPTravels;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PHPTravelsBookHotelTest {
	
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
		Thread.sleep(10000);
		report.flush();
		driver.quit();
	}
	
	
	@Test
	public void bookHotel() {
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\Reports\\PHPTravelsHotelBookTestReport.html", true);
		test = report.startTest("PHPTravels Booking a Hotel Test");
		
		String dest = "London";
		String arrive = "20/09/2018";
		String leave = "23/09/2018";
		
		test.log(LogStatus.INFO, "Browser Launched");
		driver.get("https://www.phptravels.net/");
		
		test.log(LogStatus.INFO, "Search Parameters Entered");
		PHPTravelsHome homePage = PageFactory.initElements(driver, PHPTravelsHome.class);
		homePage.searchDestination(driver, dest, arrive,leave);
		
		test.log(LogStatus.INFO, "Hotel Selected");
		PHPTravelsHotelSearchResults searchResPage = PageFactory.initElements(driver, PHPTravelsHotelSearchResults.class);
		searchResPage.goToHotelDetails();
		
		test.log(LogStatus.INFO, "Hotel Dates chosen");
		PHPTravelsHotelInfo hotelInfoPage = PageFactory.initElements(driver, PHPTravelsHotelInfo.class);
		hotelInfoPage.selectHotelDetails(driver, arrive, leave);

	}
}
