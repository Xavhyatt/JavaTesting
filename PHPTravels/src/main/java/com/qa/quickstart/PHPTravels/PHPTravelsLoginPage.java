package com.qa.quickstart.PHPTravels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PHPTravelsLoginPage {
	
	@FindBy (xpath= "//*[@id=\"loginfrm\"]/div[1]/div[5]/div/div[1]/input")
	private WebElement emailBox;
	
	@FindBy (xpath= "//*[@id=\"loginfrm\"]/div[1]/div[5]/div/div[2]/input")
	private WebElement passwordBox;
	
	@FindBy (xpath = "//*[@id=\"loginfrm\"]/button")
	private WebElement loginButton;
	
	public void login() throws InterruptedException {
		emailBox.sendKeys("TestName@hotmail.com");
		passwordBox.sendKeys("test123");
		Thread.sleep(2000);
		loginButton.click();
	}

}
