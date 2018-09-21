package com.qa.quickstart.AutomatedTestingExam;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsConfigurePage {
	
	@FindBy(xpath="//*[@id=\"main-panel\"]/form/table/tbody/tr[17]/td[3]/input")
	private WebElement emailBox;
	
	@FindBy (id ="yui-gen5-button")
	private WebElement saveButton;
	
	
	public void changeEmail(String email) {
		for (int i =0 ; i<100; i++) {
			emailBox.sendKeys(Keys.BACK_SPACE);
		}
		emailBox.sendKeys(email);
	}
	
	public void saveChanges() {
		saveButton.click();
	}
	
	public boolean confirmEmailChange(String email) {
		
		if(emailBox.getAttribute("value").equals(email)) {
			return true;
		}
		return false;
	}

}
