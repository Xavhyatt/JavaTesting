package com.qa.quickstart.AutomatedTestingExam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class JenkinsUsersPage {
	
	@FindBy (xpath ="//*[@id=\"tasks\"]/div[3]/a[2]")
	private WebElement createUser;
	
	@FindBy (xpath = "//*[@id=\"people\"]/tbody/tr[2]/td[2]/a")
	private WebElement user1;
	
	@FindBy (xpath = "//*[@id=\"people\"]/tbody/tr[3]/td[2]/a")
	private WebElement user2;

	@FindBy (xpath = "//*[@id=\"people\"]/tbody/tr[4]/td[2]/a")
	private WebElement user3;

	@FindBy (xpath = "//*[@id=\"people\"]/tbody/tr[5]/td[2]/a")
	private WebElement user4;

	@FindBy (xpath = "//*[@id=\"people\"]/tbody/tr[6]/td[2]/a")
	private WebElement user5;
	
	@FindBy (xpath = "//*[@id=\"people\"]/tbody/tr[7]/td[2]/a")
	private WebElement user6;
	
	@FindBy (id="people")
	private WebElement tableOfUsers;
	

	
	
	public void goToCreateUser() {
		createUser.click();
	}
	
	
	public boolean confirmUserCreation(WebDriver driver, String username) {
		
		String tableText = tableOfUsers.getText();
		
		if (tableText.contains(username)) {
			return true;
		}
		
	return false;
				
	}

	
	
	public void goToViewProfile(WebDriver driver, String username) {
		
		if(user1.getText().equals(username)) {
			user1.click();
		}
		
		else if(user2.getText().equals(username)) {
			user2.click();
		}
		else if(user3.getText().equals(username)) {
			user3.click();
		}
		else if(user4.getText().equals(username)) {
			user4.click();
		}
		else if(user5.getText().equals(username)) {
			user5.click();
		}
		else if(user6.getText().equals(username)) {
			user6.click();
		}
	}
}
