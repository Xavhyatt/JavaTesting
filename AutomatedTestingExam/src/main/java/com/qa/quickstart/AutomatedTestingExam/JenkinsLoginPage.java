package com.qa.quickstart.AutomatedTestingExam;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsLoginPage {
	
	@FindBy (id = "j_username")
	private WebElement userBox;
	
	@FindBy (xpath ="//*[@id=\"main-panel\"]/div/form/table/tbody/tr[2]/td[2]/input")
	private WebElement passwordBox;
	
	@FindBy (id = "yui-gen1-button")
	private WebElement logInButton;
	
	public void adminLogIn() {
		userBox.sendKeys("admin");
		passwordBox.sendKeys("218020f6da964c6a88d5f6008f6053e4");
		logInButton.click();
	}

}
