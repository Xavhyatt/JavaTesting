package com.qa.quickstart.ShoppingWebsite;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ShoppingWebsiteTest {
	WebDriver driver;
	private String url= "http://automationpractice.com/index.php";
	final private String driverType = "webdriver.chrome.driver";
	final private String fileLoc = "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe";
	
	@Before
	public void setup() {
		System.setProperty(driverType, fileLoc);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void websiteTest() {
		driver.get(url);
		driver.findElement(By.id("search_query_top")).click();
		driver.findElement(By.id("search_query_top")).sendKeys("dress");
		driver.findElement(By.id("search_query_top")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[3]/div/div[2]/h5/a")).click();
		assertEquals("Head does not match","Printed Summer Dress",driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/h1")).getText());

		
	}
	
	

}
