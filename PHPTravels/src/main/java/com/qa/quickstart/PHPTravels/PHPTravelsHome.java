package com.qa.quickstart.PHPTravels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PHPTravelsHome {
	
	
	@FindBy ( xpath = "//*[@id=\"li_myaccount\"]/a")
	private List<WebElement> listOfWebElements;
	
	@FindBy ( xpath = "//*[@id=\"li_myaccount\"]/ul/li[2]/a")
	private WebElement signUp;
	
	@FindBy ( xpath = "//*[@id=\"li_myaccount\"]/ul/li[1]/a")
	private WebElement login;
	
	@FindBy ( xpath = "//*[@id=\"body-section\"]/section/div[2]/div/div[2]/ul/li[1]/a/i")
	private WebElement hotelTab;
	
	@FindBy ( id = "s2id_autogen8" )
	private WebElement hotelLocation;
	
	@FindBy (xpath = "//*[@id=\"hotels\"]/form/div[5]/button")
	private WebElement searchButton;
	
	
	
	public void goToSignUp(WebDriver driver) {
		Actions action = new Actions(driver);
		List<WebElement> listOfWebElements = driver.findElements(By.xpath("//*[@id=\"li_myaccount\"]/a"));
		
		for (WebElement element : listOfWebElements) {
			if (element.getText().equals("MY ACCOUNT")) {
				action.click(element).perform();
				action.sendKeys(Keys.TAB).perform();
				action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
				
			
			}
		}
		
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"li_myaccount\"]/ul/li[2]/a"))).click().perform();
	}
	
	
	public void goToLogin() {
		for (WebElement element : listOfWebElements) {
			if (element.getText().equals("MY ACCOUNT")) {
				element.click();
			}
		login.click();
	}
	}
	
	public void searchDestination(WebDriver driver, String dest, String arrive, String leave) {
		
		//Input Location
		Actions action = new Actions(driver);
		action.moveToElement(hotelLocation);
		action.click();
		action.sendKeys(dest).perform();
		
		
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"select2-drop\"]/ul/li/div")));
		action.sendKeys(Keys.ENTER).perform();
		
		//Navigate to arrive date 
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(arrive);
		
		//Navigate to leave date
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(leave);
		
		//Search Submit
		//action.moveToElement(searchButton).click().perform();
		hotelLocation.submit();
		
	
	
		
	}
	

}
