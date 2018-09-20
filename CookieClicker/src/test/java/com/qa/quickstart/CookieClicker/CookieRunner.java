package com.qa.quickstart.CookieClicker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class CookieRunner {

	
	
	WebDriver driver = null;
	boolean running = true;
	
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Testing\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test
	public void cookieGo() throws InterruptedException {
		driver.get("http://orteil.dashnet.org/cookieclicker/");
		int i = 0;
		while (running) {
			CookieClickerPage cookieClickerPage = PageFactory.initElements(driver, CookieClickerPage.class);
			cookieClickerPage.cookieClick();
		
			if (i%10 == 0) {
			cookieClickerPage.cursorUpgrade();
			cookieClickerPage.grandmaUpgrade();
			cookieClickerPage.farmUpgrade();
			cookieClickerPage.factoryUpgrade();
			cookieClickerPage.sixUpgrade();
			cookieClickerPage.sevenUpgrade();
			cookieClickerPage.eightUpgrade();
			cookieClickerPage.nineUpgrade();
			//cookieClickerPage.storeUpgrade();
			}
			i++;
		}
	}
}
