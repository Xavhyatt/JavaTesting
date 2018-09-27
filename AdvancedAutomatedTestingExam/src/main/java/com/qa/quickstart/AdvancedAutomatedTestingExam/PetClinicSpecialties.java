package com.qa.quickstart.AdvancedAutomatedTestingExam;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PetClinicSpecialties {
	
	@FindBy(xpath = "/html/body/app-root/app-specialty-list/div/div/h2")
	private WebElement specialtiesHeader;
	
	
	
	
	
	public boolean checkSpecialties() {
		if (specialtiesHeader.getText().contains("Specialties")){
			return true;
		} else {
		return false;
		}
		
	}





}
