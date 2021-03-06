package com.qa.quickstart.DemoSite;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class DemoSiteDDTAdc {

	public ExtentReports report;
	public ExtentTest test;
	String LoginData = "";
	WebDriver driver = null;
	int fails=0;
	String usernamet = "";
	String passwordt = "";
	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;


	@Before
	public void setup() throws IOException {

		file = new FileInputStream(Constants.getDatafilepath() + Constants.getDatafilename());
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheetAt(0);
		report = new ExtentReports(Constants.getReportfilepath() + Constants.getReportfilename(), true);
		ExcelUtils.setExcelFile(Constants.getDatafilepath() + Constants.getDatafilename(), 0);

	}

	@After
	public void teardown() throws InterruptedException {
		report.flush();

		
	}

	@Test
	public void createUser() throws IOException {

		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			
			Cell browser = sheet.getRow(i).getCell(3);
			String browsert = browser.getStringCellValue();
			Cell username = sheet.getRow(i).getCell(0);
			Cell password = sheet.getRow(i).getCell(1);

			usernamet = username.getStringCellValue();
			passwordt = password.getStringCellValue();
			
			test = report.startTest("Demo Site Test Report! User: " + usernamet);
			if (browsert.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\Admin\\downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
				driver = new FirefoxDriver();
				test.log(LogStatus.INFO, "Using FireFox");
			} else {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				test.log(LogStatus.INFO, "Using Chrome");
			}
			driver.manage().window().maximize();
			
			try {

			test.log(LogStatus.INFO, "Open DemoSite Webpage");
			driver.get(Constants.getUrl1());

			test.log(LogStatus.INFO, "Go To Create User Page");
			DemoSiteHome page = PageFactory.initElements(driver, DemoSiteHome.class);
			page.goToAddUser();

			test.log(LogStatus.INFO, "Create a User: " + usernamet + " password " + passwordt);
			DemoSiteAddUser createPage = PageFactory.initElements(driver, DemoSiteAddUser.class);
			createPage.createUser(usernamet, passwordt);

			test.log(LogStatus.INFO, "Login Attempt: " + " User: " + usernamet + " password " + passwordt);
			DemoSiteLogin loginPage = PageFactory.initElements(driver, DemoSiteLogin.class);
			loginPage.login(usernamet, passwordt);

			WebElement checkElement = driver
					.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));

			if (checkElement.getText().equals("**Successful Login**")) {
				// report as pass
				test.log(LogStatus.PASS, "Login Successful with new user");
				ExcelUtils.setCellData("Pass", i, 2);
			} else {
				test.log(LogStatus.FAIL, "Login Unsuccessful");
				fails ++;
				ExcelUtils.setCellData("Fail", i, 2);
			}
			report.endTest(test);
		
			driver.quit();
			}
			catch(UnhandledAlertException exception){
				test.log(LogStatus.INFO, driver.switchTo().alert().getText());
				fails ++;
				test.log(LogStatus.FAIL, "Login Unsuccessful");
				
				ExcelUtils.setCellData("Fail", i, 2);
				
				report.endTest(test);
				driver.quit();
			}
		}
		assertEquals("Atleast one data set failed. Fails = " + fails , 0, fails);
		workbook.close();
	}
}
