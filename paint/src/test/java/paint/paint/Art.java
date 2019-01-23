package paint.paint;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class Art {
	
	ExtentReports report = new ExtentReports("C:\\Users\\Admin\\Desktop\\Java Testing\\PaintReport.html",true);
	
	public WebDriver driver;
	public Actions action;
	
	ExtentTest test;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Admin\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		driver = new ChromeDriver();
		action = new Actions(driver);
		test = report.startTest("Draw a Bunny!");
		driver.manage().window().maximize();
	}
	
	@After
	public void teardown() throws InterruptedException {
	
		driver.quit();
		report.endTest(test);
		report.flush();	
	}
	
	@Test
	public void art() throws InterruptedException, IOException  {
		driver.get("https://www.youidraw.com/apps/painter/?_ga=2.2890424.965560150.1548166645-1790323073.1548166645");
		test.log(LogStatus.INFO, "Navigated to the Paint Page");
		PaintPage paintPage = PageFactory.initElements(driver, PaintPage.class);
		
		paintPage.drawHead(action, driver);
		HelperMethods.screenshot(driver);
		test.log(LogStatus.INFO, "Draw the Head" + test.addScreenCapture(HelperMethods.destination1));
		paintPage.drawBody(action, driver);
		HelperMethods.screenshot(driver);
		test.log(LogStatus.INFO, "Draw the Body" + test.addScreenCapture(HelperMethods.destination1));
		paintPage.drawFace(action, driver);
		HelperMethods.screenshot(driver);
		test.log(LogStatus.INFO, "Draw the Face" + test.addScreenCapture(HelperMethods.destination1));
		paintPage.drawTail(action, driver);
		HelperMethods.screenshot(driver);
		test.log(LogStatus.INFO, "Draw the Tail" + test.addScreenCapture(HelperMethods.destination1));
		
		BufferedImage expectedImage = ImageIO.read(new File("C:\\Users\\Admin\\Desktop\\Reports\\Pass20190123105946.png"));
		Screenshot screenshot = new AShot().takeScreenshot(driver);
		
		BufferedImage actualImage = screenshot.getImage();
		
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(expectedImage, actualImage);
		
		
		if (diff.hasDiff() == true) {
			test.log(LogStatus.FAIL, "Drawing varies from expected image");
		} else {
			
		test.log(LogStatus.PASS, "Image is the same as expected");
		}
		Assert.assertFalse(diff.hasDiff());
		
			
			
		}
	
		}


