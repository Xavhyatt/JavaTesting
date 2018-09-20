package com.qa.quickstart.TeaTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeaHome {
	
	@FindBy (xpath ="//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a")
	private WebElement menu;
	
	@FindBy (xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a")
	private WebElement checkOut;
	
	
	
	public void goToMenu() {
		menu.click();
	}
	
	public void goToCheckOut(){
		checkOut.click();
	}

}
