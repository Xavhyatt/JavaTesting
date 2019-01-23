package com.qa.quickstart.PHPTravels;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PHPTravelsHotelInfo {
	
	@FindBy ( xpath = "//*[@id=\"body-section\"]/div[4]/div[2]/div/div[2]/form/div[1]/div/input")
	private WebElement checkInBox;
	
	@FindBy ( xpath = "/html/body/div[8]/div[1]/table/tbody/tr[5]/td[4]")
	private WebElement checkInDate;
	
	@FindBy ( xpath = "//*[@id=\"body-section\"]/div[4]/div[2]/div/div[2]/form/div[2]/div/input")
	private WebElement checkOutBox;
	
	@FindBy (xpath ="/html/body/div[9]/div[1]/table/tbody/tr[5]/td[7]")
	private WebElement checkOutDate;
	
	@FindBy (id = "adults")
	private WebElement adultsDropBox;
	
	@FindBy (id = "child")
	private WebElement childDropBox;
	
	@FindBy (xpath = "//*[@id=\"body-section\"]/div[4]/div[2]/div/div[2]/form/div[5]/input[3]")
	private WebElement modifyButton;
	
	@FindBy (xpath = "//*[@id=\"ROOMS\"]/div/button")
	private WebElement bookNowButton;
	
	
	public void selectHotelDetails(WebDriver driver, String arrive, String leave) {
		Actions action = new Actions(driver);
		
		//Navigate to arrive date 
		
			action.moveToElement(checkInBox).click().perform();
			action.keyDown(Keys.LEFT_CONTROL).sendKeys(Keys.chord("A")).keyUp(Keys.LEFT_CONTROL).sendKeys(Keys.DELETE).perform();
			action.sendKeys(arrive).sendKeys(Keys.TAB).perform();
			/*WebElement dateWait = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[8]")));
			driver.findElement(By.xpath("/html/body/div[8]/div[1]/table/tbody/tr[4]/td[4]")).click();*/
			
			
		//Navigate to leave date
			action.moveToElement(checkOutBox).click().perform();
			//action.keyDown(Keys.LEFT_CONTROL).sendKeys(Keys.chord("A")).keyUp(Keys.LEFT_CONTROL).sendKeys(Keys.DELETE).perform();
			action.sendKeys(leave).sendKeys(Keys.TAB).perform();
			//driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/tbody/tr[4]/td[6]")).click();;
			
			
		//Number of Adults
			action.moveToElement(adultsDropBox).click().perform();
			driver.findElement(By.xpath("//*[@id=\"adults\"]/option[3]")).click();
			
			
		//Modify Room Req. Submit
			checkOutBox.submit();
			//action.moveToElement(modifyButton).click().perform();
		
		//Select Room
			//make screen scroll down
			for (int i =0; i<30; i++) {
			action.sendKeys(Keys.TAB).perform();
			}
			driver.findElement(By.xpath("//*[@id=\"ROOMS\"]/div/table/tbody/tr[1]/td/div[2]/div[2]/div/div[3]/div/label/div")).click();
			action.moveToElement(bookNowButton).click().perform();
			
	}

}
