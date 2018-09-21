package com.qa.quickstart.AutomatedTestingExam;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsPersonPage {
	
	@FindBy (xpath ="//*[@id=\"main-panel\"]/div[2]")
	private WebElement userId;
	
	@FindBy (xpath = "//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement configureButton;
		
	
	public boolean confirmPersonPage(String username) {
		
		if( userId.getText().contains(username)) {
			return true;
		}
		return false;
				
	}
	
	public void goToConfigurePage() {
		configureButton.click();
	}
	

}
