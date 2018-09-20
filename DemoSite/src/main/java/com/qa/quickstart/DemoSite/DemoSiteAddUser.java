package com.qa.quickstart.DemoSite;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoSiteAddUser {
	
	@FindBy ( xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")
	private WebElement userNameBox;
	
	@FindBy ( xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")
	private WebElement passWordBox;
	
	@FindBy ( xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")
	private WebElement saveButton;
	
	@FindBy ( xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
	private WebElement goToLoginPage;
	
	public void createUser(String username, String password) {
		userNameBox.sendKeys(username);
		passWordBox.sendKeys(password);
		saveButton.click();
		goToLoginPage.click();
		
	}

}
