package com.qa.quickstart.ShoppingWebsite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingWebsiteHome {
	
	@FindBy ( id = "search_query_top")
	private WebElement searchBox;
	
	@FindBy ( xpath = "//*[@id=\"searchbox\"]/button")
	private WebElement searchSubmit;
	
	public void searchClothes(String text) {
		
		searchBox.sendKeys("dress");
		searchSubmit.submit();
		
	}

}
