package com.qa.quickstart.PHPTravels;


import static org.junit.Assert.*;

import javax.sound.midi.Soundbank;

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

public class PHPTravelsCreateUserTest {
	
	public ExtentReports report;
	public ExtentTest test;
	WebDriver driver = null;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Admin\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		driver = new ChromeDriver();
		report = new ExtentReports(Constants.getReportfilepath()+Constants.getReportfilename(), true);
		driver.manage().window().maximize();
	}
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		report.flush();
		driver.quit();
	}
	
	
	@Test
	public void createUserTest() throws InterruptedException {
		test = report.startTest("Create User Test");
		
		test.log(LogStatus.INFO, "Open PHPTravels Homepage");
		driver.get("https://www.phptravels.net/");
		
		test.log(LogStatus.INFO, "Go to Sign Up Page");
		PHPTravelsHome homePage = PageFactory.initElements(driver, PHPTravelsHome.class);
		homePage.goToSignUp(driver);
		
		test.log(LogStatus.INFO, "Create an Account");
		PHPTravelsSignUp signUpPage = PageFactory.initElements(driver, PHPTravelsSignUp.class);
		signUpPage.signUpCompletion();
		signUpPage.goToLogin(driver);
		
		test.log(LogStatus.INFO, "Log in Attempt");
		PHPTravelsLoginPage loginPage = PageFactory.initElements(driver, PHPTravelsLoginPage.class);
		loginPage.login();
		
		WebElement checkElement = driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[2]/div[2]/div/div[1]/ul/li[2]/a"));
		checkElement.click();
		
		checkElement = driver.findElement(By.xpath("//*[@id=\"profilefrm\"]/div/div[1]/div[2]/div[1]/div[2]/input"));
		System.out.println(checkElement.getText());
		
		if(checkElement.getText().contains("Test")) {
			//report as pass
			test.log(LogStatus.PASS, "Login Successful");
		} else {
			//report as fail
			test.log(LogStatus.FAIL, "Login Unsuccessful");
		}
		report.endTest(test);
		System.out.println(checkElement.getText());
		
		
		assertEquals("Login unsuccessful"," Test ", checkElement.getText());
		
	}
	

}
