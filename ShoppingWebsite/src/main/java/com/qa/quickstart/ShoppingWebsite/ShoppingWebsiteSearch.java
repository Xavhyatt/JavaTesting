package com.qa.quickstart.ShoppingWebsite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingWebsiteSearch {
	
	@FindBy (xpath = "//*[@id=\"center_column\"]/h1/span[1]")
	private WebElement searchResult;
	
	
	public String searchResult() {
		String result = searchResult.getText();
		return result;
	}

}
