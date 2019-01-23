package paint.paint;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PaintPage {
	
	@FindBy( id = "brush")
	private WebElement brush;
	
	@FindBy(id="catch")
	private WebElement canvas;
	
	@FindBy(id = "imgBrush")
	private WebElement brushType;
	
	@FindBy(xpath="//*[@id=\"moreBrush\"]/li[32]/div")
	private WebElement brush1;
	
	@FindBy(id = "edSize")
	private WebElement size;
	
	@FindBy (id="color")
	private WebElement color;
	
	@FindBy(xpath = "//*[@id=\"collorpicker_562\"]/div[1]/div")
	private WebElement colorPicker;
	
	@FindBy (xpath = "//*[@id=\"moreBrush\"]/li[17]/div")
	private WebElement brush2;
	
	@FindBy(xpath ="//*[@id=\"collorpicker_562\"]/div[5]/input")
	private WebElement hexClr;
	
	@FindBy (xpath ="//*[@id=\"collorpicker_562\"]/div[3]")
	private WebElement Clr;
	
	
	
	
	
	
	public void drawHead(Actions action, WebDriver driver) 	{
		//Paint Brush Select
		action.moveToElement(brush).click().perform();
		
		// Head
		action.moveToElement(canvas, 300, 300).clickAndHold()
		.moveByOffset(10, -80).moveByOffset(20, -20).moveByOffset(20, 20).moveByOffset(10, 80)
		.moveByOffset(15, -5).moveByOffset(15, 5)
		.moveByOffset(10, -80).moveByOffset(20, -20).moveByOffset(20, 20).moveByOffset(10, 80)
		.moveByOffset(-10, 150).moveByOffset(-65, 40)
		.moveByOffset(-65, -40).moveByOffset(-10, -150)
		.release().perform();
	}
	
	public void drawBody(Actions action, WebDriver driver) {
		// Body
		action.moveToElement(canvas, 450, 440).clickAndHold().moveByOffset(60, 80).moveByOffset(20, 50).moveByOffset(-10, 15)
		.moveByOffset(-5, 5).moveByOffset(-5, 5).moveByOffset(-100, 0)
		.moveByOffset(-10, -10).moveByOffset(10, -10).moveByOffset(40, 0)
		.release().perform();
		action.moveToElement(canvas, 435, 575).clickAndHold().moveByOffset(-12, -6).moveByOffset(-8, -8).moveByOffset(-4, -10)
		.moveByOffset(0, -6).moveByOffset(4, -6).moveByOffset(8, -10).moveByOffset(12, -6)		
		.release().perform();
		
		action.moveToElement(canvas, 410, 595).clickAndHold().moveByOffset(-90, 0).moveByOffset(-10, -10).moveByOffset(10, -10).moveByOffset(40, 0)
		.release().perform();
		action.moveToElement(canvas, 365, 575).clickAndHold().moveByOffset(-12, -6).moveByOffset(-8, -8).moveByOffset(-4, -10)
		.moveByOffset(0, -6).moveByOffset(4, -6).moveByOffset(8, -10).moveByOffset(12, -6)		
		.release().perform();
		
		action.moveToElement(canvas, 340, 555).clickAndHold().moveByOffset(-10, -10).moveByOffset(-8, -10).moveByOffset(-6, -10).moveByOffset(-4, -10).moveByOffset(-2, -10)
		.moveByOffset(0, -50)		
		.release().perform();
		
		action.moveToElement(canvas, 317, 535).clickAndHold().moveByOffset(-15, 15).moveByOffset(0, -15).moveByOffset(15, -15).release().perform();
	}
	public void drawFace(Actions action, WebDriver driver) {
		
		
		//Change Brush Type & Size
		action.moveToElement(brushType).click().perform();
		WebElement dynamicEl = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"moreBrush\"]/li[32]/div")));
		action.moveToElement(brush1).click().perform();
		action.moveToElement(size).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("10").perform();
		
			
		// Nose 
		action.moveToElement(canvas, 372, 400).clickAndHold().moveByOffset(6, 0)
		.moveByOffset(-3, 3).moveByOffset(-3, -3).release().perform();
		
		// Mouth
		action.moveToElement(canvas, 375, 402).clickAndHold().moveByOffset(0, 15)
		.moveByOffset(-6, 6).moveByOffset(-6, -6).release().perform();
		action.moveToElement(canvas, 375, 417).clickAndHold()
		.moveByOffset(6, 6).moveByOffset(6, -6).release().perform();
		
		// Eyes
		action.moveToElement(canvas, 360, 360).clickAndHold().moveByOffset(0, 10).release().perform();
		action.moveToElement(canvas, 390, 360).clickAndHold().moveByOffset(0, 10).release().perform();
		
		// Whiskers
		action.moveToElement(size).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("3").perform();
		action.moveToElement(canvas, 388, 400).clickAndHold().moveByOffset(80, -10).release().perform();
		action.moveToElement(canvas, 362, 400).clickAndHold().moveByOffset(-80, -10).release().perform();
		action.moveToElement(canvas, 388, 410).clickAndHold().moveByOffset(80, -5).release().perform();
		action.moveToElement(canvas, 362, 410).clickAndHold().moveByOffset(-80, -5).release().perform();
		action.moveToElement(canvas, 388, 412).clickAndHold().moveByOffset(80, -0).release().perform();
		action.moveToElement(canvas, 362, 412).clickAndHold().moveByOffset(-80, -0).release().perform();
	}
	
	public void drawTail(Actions action, WebDriver driver) {
		
		
		// Tail
		action.moveToElement(brushType).click().perform();
		WebElement dynamicEl1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"moreBrush\"]/li[17]/div")));
		action.moveToElement(dynamicEl1).click().perform();
		action.moveToElement(size).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("50").perform();
		action.moveToElement(canvas, 540, 570).click().click().perform();
		
		
	}

}


