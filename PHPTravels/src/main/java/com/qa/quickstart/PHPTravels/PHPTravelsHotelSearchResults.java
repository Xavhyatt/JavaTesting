package com.qa.quickstart.PHPTravels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PHPTravelsHotelSearchResults {
	
	@FindBy( xpath = "//*[@id=\"body-section\"]/div[5]/div/div[3]/div[1]/div/table/tbody/tr/td/div[3]/a/button")
	private WebElement detailsButton;
	
	
	public void goToHotelDetails(){
		detailsButton.click();
	}

}
