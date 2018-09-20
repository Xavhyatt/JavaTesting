package com.qa.quickstart.CookieClicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CookieClickerPage {
	
	@FindBy(id = "cookies")
	private WebElement money;
	
	@FindBy(id ="bigCookie")
	private WebElement cookie;
	
	@FindBy(id ="product0")
	private WebElement cursorUpgrade;
	
	@FindBy(id = "product1")
	private WebElement grandmaUpgrade;
	
	@FindBy(id = "product2")
	private WebElement farmUpgrade;
	
	@FindBy(id = "product3")
	private WebElement mineUpgrade;
	
	@FindBy(id = "product4")
	private WebElement factoryUpgrade;
	
	@FindBy(id = "product5")
	private WebElement sixUpgrade;
	
	@FindBy(id = "product6")
	private WebElement sevenUpgrade;
	
	@FindBy(id = "product7")
	private WebElement eightUpgrade;
	
	@FindBy(id = "product8")
	private WebElement nineUpgrade;
	
	@FindBy(id = "upgrade0")
	private WebElement storeUpgrade;
	
	
	
	public void cookieClick() {
		cookie.click();
	}
	
	public void cursorUpgrade() {
		if (cursorUpgrade.getAttribute("class").equals("product unlocked enabled")) {
		cursorUpgrade.click();
		}
	}
	
	public void grandmaUpgrade() {
		if (grandmaUpgrade.getAttribute("class").equals("product unlocked enabled")) {
		grandmaUpgrade.click();
		}
	}
	public void farmUpgrade() {
		if (farmUpgrade.getAttribute("class").equals("product unlocked enabled")) {
		farmUpgrade.click();
		}
	}
	
	public void factoryUpgrade() {
		if (factoryUpgrade.getAttribute("class").equals("product unlocked enabled")) {
		factoryUpgrade.click();
		}
	}
	public void sixUpgrade() {
		if (sixUpgrade.getAttribute("class").equals("product unlocked enabled")) {
		sixUpgrade.click();
		}
	}
	public void sevenUpgrade() {
		if (sevenUpgrade.getAttribute("class").equals("product unlocked enabled")) {
		sevenUpgrade.click();
		}
	}
	public void eightUpgrade() {
		if (eightUpgrade.getAttribute("class").equals("product unlocked enabled")) {
		eightUpgrade.click();
		}
	}
	public void nineUpgrade() {
		if (nineUpgrade.getAttribute("class").equals("product unlocked enabled")) {
		nineUpgrade.click();
		}
	}
	public void storeUpgrade() {
		if (storeUpgrade.getAttribute("class").equals("crate upgrade enabled")) {
		storeUpgrade.click();
		}
	}
}

	
	







