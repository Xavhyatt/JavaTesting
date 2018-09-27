package com.qa.quickstart.AdvancedAutomatedTestingExam;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PetClinicAddNewPet {
	
	@FindBy ( xpath = "//*[@id=\"name\"]")
	private WebElement petName;
	
	@FindBy (xpath = "/html/body/app-root/app-pet-add/div/div/form/div[4]/input")
	private WebElement birthDate;
	
	@FindBy (xpath = "//*[@id=\"type\"]")
	private WebElement type;
	
	@FindBy (xpath = "//*[@id=\"type\"]/option[1]")
	private WebElement typeCat;
	
	@FindBy (xpath = "/html/body/app-root/app-pet-add/div/div/form/div[6]/div/button[2]")
	private WebElement addPetButton;
	
	@FindBy (xpath = "/html/body/app-root/app-pet-add/div/div/form/div[6]/div/button[1]")
	private WebElement backButton;
	
	public void addNewPet(String name, String birth) throws InterruptedException {
		Thread.sleep(1000);
		petName.sendKeys(name);
		birthDate.sendKeys(birth);
		type.click();
		typeCat.click();
		addPetButton.click();
		backButton.click();
	}

}
