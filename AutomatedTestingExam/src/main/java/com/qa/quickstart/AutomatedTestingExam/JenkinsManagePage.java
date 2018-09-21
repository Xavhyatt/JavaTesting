package com.qa.quickstart.AutomatedTestingExam;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class JenkinsManagePage {
	
	@FindBy(xpath="//*[@id=\"management-links\"]/tbody/tr[16]/td[2]/div[1]/a")
	private WebElement manageUsers;
	
	
	
	
	public void goToManageUsers(WebDriver driver) {
		Actions action = new Actions(driver);
		
		for (int i = 0 ; i<7 ; i++) {
			action.sendKeys(Keys.ARROW_DOWN).perform();
		}
		manageUsers.click();
		
	}

}
