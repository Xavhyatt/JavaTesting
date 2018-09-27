package com.qa.quickstart.AdvancedAutomatedTestingExam;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PetClinicAddOwner {
	
	@FindBy ( id = "firstName")
	private WebElement firstNameBox;
	
	@FindBy ( id = "lastName")
	private WebElement lastNameBox;
	
	@FindBy ( id = "address")
	private WebElement addressBox;
	
	@FindBy ( id = "city")
	private WebElement cityBox;
	
	@FindBy ( id = "telephone")
	private WebElement telephoneBox;
	
	@FindBy (xpath = "/html/body/app-root/app-owner-add/div/div/form/div[7]/div/button[2]")
	private WebElement addOwnerButton;
	
	
	public void createNewOwner() {
		firstNameBox.sendKeys(Constants.firstName);
		lastNameBox.sendKeys(Constants.lastName);
		addressBox.sendKeys(Constants.address);
		cityBox.sendKeys(Constants.city);
		telephoneBox.sendKeys(Constants.telephone);
		addOwnerButton.click();
	}
	
	
}
