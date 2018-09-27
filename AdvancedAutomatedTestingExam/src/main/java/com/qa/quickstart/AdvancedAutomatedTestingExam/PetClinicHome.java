package com.qa.quickstart.AdvancedAutomatedTestingExam;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PetClinicHome {
	
	@FindBy (xpath = "/html/body/app-root/div[1]/nav/div/ul/li[5]/a")
	private WebElement goToSpecialties;
	
	@FindBy (xpath ="/html/body/app-root/div[1]/nav/div/ul/li[2]/a")
	private WebElement ownersDropDown;
	
	@FindBy (xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[2]/a/span[2]")
	private WebElement goToAddOwner;
	
	@FindBy (xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[1]/a")
	private WebElement goToAllOwners;

	
	
	
	public void goToSpecialties() {
		goToSpecialties.click();
	}

	public void goToOwners() {
		ownersDropDown.click();
		goToAddOwner.click();
	}
	
	public void goToAllOwners() {
		ownersDropDown.click();
		goToAllOwners.click();
	}
	
	
}
