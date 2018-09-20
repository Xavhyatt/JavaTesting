package com.qa.quickstart.DemoSite;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoSiteLogin {
	
	@FindBy ( xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")
	
	
	
	private WebElement userNameLogin;
	
	@FindBy ( xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")
	private WebElement passWordLogin;
	
	@FindBy ( xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")
	private WebElement loginButton;
	
	
	public void login(String username, String password) {
		userNameLogin.sendKeys(username);
		passWordLogin.sendKeys(password);
		loginButton.click();
	}

}
