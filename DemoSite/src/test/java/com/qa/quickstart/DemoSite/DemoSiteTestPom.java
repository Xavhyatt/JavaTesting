package com.qa.quickstart.DemoSite;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DemoSiteTestPom {
	
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
	public void createUser() {
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\Reports\\DemoSiteReport.html", true);
		test = report.startTest("Demo Site Test Report");
		
		//add note to test
		test.log(LogStatus.INFO, "Browser Launched");
		
		String usernamet = "xav1";
		String passwordt = "pass";
		driver.get("http://thedemosite.co.uk/index.php");
		DemoSiteHome page = PageFactory.initElements(driver, DemoSiteHome.class);
		page.goToAddUser();
		DemoSiteAddUser createPage = PageFactory.initElements(driver, DemoSiteAddUser.class);
		createPage.createUser(usernamet, passwordt);
		DemoSiteLogin loginPage = PageFactory.initElements(driver, DemoSiteLogin.class);
		loginPage.login(usernamet, passwordt);
		WebElement checkElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		
		if(checkElement.getText().equals("**Successful Login**")) {
			//report as pass
			test.log(LogStatus.PASS, "Login Successful");
		} else {
			test.log(LogStatus.FAIL, "Login Unsuccessful");
		}
		report.endTest(test);
		
		assertEquals("Login not successful", "**Successful Login**", checkElement.getText());
	}

}
