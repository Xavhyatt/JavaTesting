package com.qa.quickstart.SelTest;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class sel1 {
	WebDriver driver;
	private String url = "https://www.google.com/";
	final private String driverType = "webdriver.chrome.driver";
	final private String fileLoc = "C:\\\\Users\\\\Admin\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe";

	
	@Before
	public void setup() {
	System.setProperty(driverType,fileLoc);
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void methodTest() {
		driver.get(url);
	    driver.get("https://www.google.co.uk/search?q=steam&rlz=1C1CHBF_en-GBGB814GB814&oq=steam&aqs=chrome..69i57j0l5.1431j0j7&sourceid=chrome&ie=UTF-8");
	    driver.findElement(By.linkText("Welcome to Steam")).click();
	    driver.findElement(By.id("store_nav_search_term")).click();
	    driver.findElement(By.id("store_nav_search_term")).clear();
	    driver.findElement(By.id("store_nav_search_term")).sendKeys("f1");
	    driver.findElement(By.id("store_nav_search_term")).sendKeys(Keys.ENTER);
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Search'])[1]/following::span[1]")).click();
	    assertEquals("F1 2018 on Steam", driver.getTitle());
	  }

		
	
	
	}

