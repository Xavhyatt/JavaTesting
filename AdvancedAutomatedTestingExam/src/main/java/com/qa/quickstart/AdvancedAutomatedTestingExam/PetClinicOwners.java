package com.qa.quickstart.AdvancedAutomatedTestingExam;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PetClinicOwners {
	
	@FindBy (xpath = "/html/body/app-root/app-owner-list/div/div/div")
	private WebElement ownersTable;
	
	@FindBy (xpath ="/html/body/app-root/app-owner-list/div/div/div/table/tbody/tr[10]/td[1]/a")
	private WebElement goToCarlos;
	
	
	
	public boolean checkNewOwnerAdded() throws InterruptedException {
		// Add Explicit wait
		Thread.sleep(2000);
		if(ownersTable.getText().contains(Constants.firstName)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void goToCarlos() throws InterruptedException {
		Thread.sleep(2000);
		goToCarlos.click();
		}
	
	

}
