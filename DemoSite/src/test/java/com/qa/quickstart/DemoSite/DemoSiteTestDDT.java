package com.qa.quickstart.DemoSite;

import static org.junit.Assert.*;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


	public class DemoSiteTestDDT {
		
		public ExtentReports report;
		public ExtentTest test;
		String LoginData = "";
		WebDriver driver = null;
		
		
		@Before
		public void setup() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			report = new ExtentReports(Constants.getReportfilepath()+Constants.getReportfilename(), true);
			ExcelUtils.setExcelFile(Constants.getDatafilepath() + Constants.getDatafilename(),0);
			driver.manage().window().maximize();
		}
		
		@After
		public void teardown() throws InterruptedException {
			Thread.sleep(3000);
			report.flush();
			driver.quit();
		}
		
		@Test
		public void createUser() throws IOException{
			
			FileInputStream file = new FileInputStream(Constants.getDatafilepath()+Constants.getDatafilename());
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			String usernamet = "";
			String passwordt = "";
			
			for (int i = 1; i< sheet.getPhysicalNumberOfRows(); i++) {
			test = report.startTest("Demo Site Test Report");	
			Cell username = sheet.getRow(i).getCell(0);
			Cell password = sheet.getRow(i).getCell(1);
			
			usernamet = username.getStringCellValue();
			passwordt = password.getStringCellValue();
			
			test.log(LogStatus.INFO, "Open DemoSite Webpage");
			driver.get(Constants.getUrl1());
			
			test.log(LogStatus.INFO, "Go To Create User Page");
			DemoSiteHome page = PageFactory.initElements(driver, DemoSiteHome.class);
			page.goToAddUser();
			
			test.log(LogStatus.INFO, "Create a User:" + usernamet + "password" + passwordt);
			DemoSiteAddUser createPage = PageFactory.initElements(driver, DemoSiteAddUser.class);
			createPage.createUser(usernamet, passwordt);
			
			test.log(LogStatus.INFO, "Login Attempt" + " User: " + usernamet + "password" + passwordt );
			DemoSiteLogin loginPage = PageFactory.initElements(driver, DemoSiteLogin.class);
			loginPage.login(usernamet, passwordt);
			
			WebElement checkElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
			
			if(checkElement.getText().equals("**Successful Login**")) {
				//report as pass
				test.log(LogStatus.PASS, "Login Successful with new user");
				ExcelUtils.setCellData("Pass", i, 2);
			} else {
				test.log(LogStatus.FAIL, "Login Unsuccessful");
				ExcelUtils.setCellData("Fail", i, 2);
			}
			report.endTest(test);
			assertEquals("Login not successful", "**Successful Login**", checkElement.getText());
			}
			workbook.close();
		}	
	}
