package com.qa.quickstart.AdvancedAutomatedTestingExam;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PetClinicEditOwner {
	
	@FindBy (id ="address")
	private WebElement addressBox;
	
	@FindBy (xpath ="/html/body/app-root/app-owner-edit/div/div/form/div[7]/div/button[2]")
	private WebElement submitEditButton;
	
	
	
	public void changeAddress(String address) {
		addressBox.clear();
		addressBox.sendKeys(address);
	}
	
	public void confirmEdit() {
		submitEditButton.click();
	}

}
