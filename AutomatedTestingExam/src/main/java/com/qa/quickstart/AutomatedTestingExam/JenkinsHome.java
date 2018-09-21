package com.qa.quickstart.AutomatedTestingExam;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsHome {
	
	@FindBy(xpath="//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement manageJenkins;
	
	public void goToManageJenkins() {
		manageJenkins.click();
	}
	
	
	
	
}
