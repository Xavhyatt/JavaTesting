package com.qa.quickstart.AdvancedAutomatedTestingExam;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

public class PetClinicSpecificOwner {
	
	@FindBy (xpath = "/html/body/app-root/app-owner-detail/div/div/table[2]/tbody/tr/app-pet-list[1]/table/tbody/tr/td[1]/dl/button[2]")
	private WebElement deletePet1;

	@FindBy (xpath ="/html/body/app-root/app-owner-detail/div/div/table[2]/tbody")
	private WebElement petTable;
	
	@FindBy (xpath = "/html/body/app-root/app-owner-detail/div/div/button[2]")
	private WebElement editOwnerButton;
	
	@FindBy (xpath = "/html/body/app-root/app-owner-detail/div/div")
	private WebElement ownerInfo;
	
	@FindBy (xpath = "/html/body/app-root/app-owner-detail/div/div/button[3]")
	private WebElement addPet;
	
	
	
	public void deletePet1() {
		deletePet1.click();
	}
	
	public boolean checkPetTable(String petName) {
		if (petTable.getText().contains(petName)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void goToEditOwner() {
		editOwnerButton.click();
	}
	
	public boolean checkInfoUpdate(String update) throws InterruptedException {
		Thread.sleep(1000);
		if ( ownerInfo.getText().contains(update)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void addNewPet() {
		addPet.click();
	}
	
	
}
