package com.qa.quickstart.PHPTravels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PHPTravelsSignUp {
	
	@FindBy (xpath = "//*[@id=\"headersignupform\"]/div[3]/input" )
	private WebElement firstName;
	
	@FindBy (xpath = "//*[@id=\"headersignupform\"]/div[4]/input" )
	private WebElement lastName;
	
	@FindBy (xpath = "//*[@id=\"headersignupform\"]/div[5]/input" )
	private WebElement mobileNum;
	
	@FindBy (xpath = "//*[@id=\"headersignupform\"]/div[6]/input")
	private WebElement email;
	
	@FindBy (xpath = "//*[@id=\"headersignupform\"]/div[7]/input")
	private WebElement password;
	
	@FindBy (xpath = "//*[@id=\"headersignupform\"]/div[8]/input")
	private WebElement passwordConfirm;
	
	@FindBy (xpath = "//*[@id=\"headersignupform\"]/div[9]/button")
	private WebElement signUpButton;
	
	@FindBy (xpath = "//*[@id=\"li_myaccount\"]/a")
	private WebElement myAccountDrop;
	
	@FindBy (xpath = "//*[@id=\"li_myaccount\"]/ul/li[1]/a")
	private WebElement login;
	
	public void signUpCompletion() throws InterruptedException {
		firstName.sendKeys("Test");
		lastName.sendKeys("Name");
		mobileNum.sendKeys("0123456789");
		email.sendKeys("TestName@hotmail.com");
		password.sendKeys("test123");
		passwordConfirm.sendKeys("test123");
		signUpButton.click();
		Thread.sleep(2000);
				
	}
	
	public void goToLogin(WebDriver driver) throws InterruptedException {
		Actions action = new Actions(driver);
		List<WebElement> listOfWebElements = driver.findElements(By.xpath("//*[@id=\"li_myaccount\"]/a"));
		
		for (WebElement element : listOfWebElements) {
			if (element.getText().equals("MY ACCOUNT")) {
				action.click(element).perform();
				Thread.sleep(2000);
				action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
				Thread.sleep(2000);
				
			
			}
		}
	}
}
		



