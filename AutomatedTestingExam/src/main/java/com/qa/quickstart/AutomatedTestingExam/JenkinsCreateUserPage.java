package com.qa.quickstart.AutomatedTestingExam;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsCreateUserPage {

	@FindBy (id = "username")
	private WebElement userNameBox;
	
	@FindBy (xpath ="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[2]/td[2]/input")
	private WebElement passwordBox;
	
	@FindBy (xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[3]/td[2]/input")
	private WebElement confirmPasswordBox;
	
	@FindBy (xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[4]/td[2]/input")
	private WebElement fullNameBox;
	
	@FindBy (xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[5]/td[2]/input")
	private WebElement emailBox;
	
	@FindBy (id ="yui-gen3-button")
	private WebElement createUserButton;
	
	
	public void userDetails(String username, String password, String confirmPassword, String fullname, String email) {
		userNameBox.sendKeys(username);
		passwordBox.sendKeys(password);
		confirmPasswordBox.sendKeys(confirmPassword);
		fullNameBox.sendKeys(fullname);
		emailBox.sendKeys(email);
	}
	
	public void createUser() {
		createUserButton.click();
	}
	
	
	
	
}
