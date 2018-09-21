package com.qa.quickstart.AutomatedTestingExam;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.quickstart.AutomatedTestingExam.Constants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JenkinsStepper {
	
	ExtentReports report;
	ExtentTest test;
	final private  String driverType = "webdriver.chrome.driver";
	final private String fileLoc = "C:\\Testing\\chromedriver.exe";
	WebDriver driver = null;
	
	
	@Before
	public void setUp() throws IOException {
		FileInputStream file = new FileInputStream(Constants.getDatafilepath()+Constants.getDatafilename());
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Runner.counter++;
		report = Runner.report;
		test = report.startTest("Jenkins Testing" + Runner.counter);
		System.setProperty(driverType, fileLoc);
		driver = new ChromeDriver();
		ExcelUtils.setExcelFile(Constants.getDatafilepath() + Constants.getDatafilename(),0);
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown()  {
		
		driver.quit();
		report.endTest(test);
		report.flush();
		
	}
	

	@Given("^that you are on the create UserScreen$")
	public void that_you_are_on_the_create_UserScreen()  {
		
	   driver.get(Constants.getUrl1());
	   test.log(LogStatus.INFO, "Opened the Jenkins Login Page");
	   JenkinsLoginPage jenkinsLoginPage = PageFactory.initElements(driver, JenkinsLoginPage.class);
	   jenkinsLoginPage.adminLogIn();
	   test.log(LogStatus.INFO, "Admin Logged in");
	   JenkinsHome jenkinsHomePage = PageFactory.initElements(driver, JenkinsHome.class);
	   jenkinsHomePage.goToManageJenkins();
	   JenkinsManagePage jenkinsManagePage = PageFactory.initElements(driver, JenkinsManagePage.class);
	   jenkinsManagePage.goToManageUsers(driver);
	   JenkinsUsersPage jenkinsUsersPage = PageFactory.initElements(driver, JenkinsUsersPage.class);
	   jenkinsUsersPage.goToCreateUser(); 
	   test.log(LogStatus.INFO, "Navigated to the Create User Page");
	   
	}

	@When("^the User details are entered on the Create UserScreen$")
	public void the_User_details_are_entered_on_the_Create_UserScreen() {
		JenkinsCreateUserPage jenkinsCreateUserPage = PageFactory.initElements(driver,JenkinsCreateUserPage.class);;
		jenkinsCreateUserPage.userDetails(Constants.getUsername(), Constants.getPassword(), Constants.getPassword(), Constants.getFullname(), Constants.getEmail());
		test.log(LogStatus.INFO, "New User Details Inputted");
	}


	@When("^the details are submitted on the Create UserScreen$")
	public void the_details_are_submitted_on_the_Create_UserScreen() throws InterruptedException  {
		JenkinsCreateUserPage jenkinsCreateUserPage = PageFactory.initElements(driver,JenkinsCreateUserPage.class);;
		jenkinsCreateUserPage.createUser();
		test.log(LogStatus.INFO, "New User Details Submitted");	    
	}

	@Then("^the Username should be visible on the UsersScreen$")
	public void the_Username_should_be_visible_on_the_UsersScreen()  {
		ExcelUtils.setCellData("Is Username Visible on Users Screen", Runner.counter, 0);
		ExcelUtils.setCellData(Constants.getUsername(), Runner.counter, 1);
		JenkinsUsersPage jenkinsUsersPage = PageFactory.initElements(driver, JenkinsUsersPage.class);
		if (jenkinsUsersPage.confirmUserCreation(driver, Constants.getUsername()) == true) {
			HelperMethods.screenshot(driver);
			test.log(LogStatus.PASS, "User Created with the username:" + Constants.getUsername() + test.addScreenCapture(HelperMethods.destination1));
			ExcelUtils.setCellData("Pass", Runner.counter, 2);
		} else {
			HelperMethods.screenshot(driver);
			test.log(LogStatus.FAIL, "User Creation Failed" + test.addScreenCapture(HelperMethods.destination1));
			ExcelUtils.setCellData("Fail", Runner.counter, 2);
		}
		assertTrue(jenkinsUsersPage.confirmUserCreation(driver, Constants.getUsername()) == true);
	   
	}

	@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, \"([^\"]*)\" Fullname and \"([^\"]*)\" EmailAddress are entered on the Create UserScreen$")
	public void the_User_details_username_password_confirm_Password_Fullname_and_EmailAddress_are_entered_on_the_Create_UserScreen(String arg1, String arg2, String arg3, String arg4, String arg5)  {
		JenkinsCreateUserPage jenkinsCreateUserPage = PageFactory.initElements(driver,JenkinsCreateUserPage.class);
		jenkinsCreateUserPage.userDetails(arg1,arg2,arg3,arg4,arg5);
		test.log(LogStatus.INFO, "New User: " + arg1 + " submitted");	
	}

	@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
	public void the_username_should_be_visible_on_the_UsersScreen(String arg1)  {
		ExcelUtils.setCellData("Is Username Visible on Users Screen", Runner.counter, 0);
		ExcelUtils.setCellData(arg1, Runner.counter, 1);
		JenkinsUsersPage jenkinsUsersPage = PageFactory.initElements(driver, JenkinsUsersPage.class);
		if (jenkinsUsersPage.confirmUserCreation(driver, arg1) == true) {
			HelperMethods.screenshot(driver);
			test.log(LogStatus.PASS, "User Created with the username:" + arg1 + test.addScreenCapture(HelperMethods.destination1));
			ExcelUtils.setCellData("Pass", Runner.counter, 2);
		} else {
			HelperMethods.screenshot(driver);
			test.log(LogStatus.FAIL, "User Creation Failed" + test.addScreenCapture(HelperMethods.destination1));
			ExcelUtils.setCellData("Fail", Runner.counter, 2);
		}
		assertTrue(jenkinsUsersPage.confirmUserCreation(driver, arg1)==true);
	    
	}

	@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
	public void the_username_is_visible_on_the_UsersScreen(String arg1) {
		 driver.get(Constants.getUrl1());
		   test.log(LogStatus.INFO, "Opened the Jenkins Login Page");
		   JenkinsLoginPage jenkinsLoginPage = PageFactory.initElements(driver, JenkinsLoginPage.class);
		   jenkinsLoginPage.adminLogIn();
		   test.log(LogStatus.INFO, "Admin Logged in");
		   JenkinsHome jenkinsHomePage = PageFactory.initElements(driver, JenkinsHome.class);
		   jenkinsHomePage.goToManageJenkins();
		   JenkinsManagePage jenkinsManagePage = PageFactory.initElements(driver, JenkinsManagePage.class);
		   jenkinsManagePage.goToManageUsers(driver);
		   JenkinsUsersPage jenkinsUsersPage = PageFactory.initElements(driver, JenkinsUsersPage.class);
		   if(jenkinsUsersPage.confirmUserCreation(driver, arg1) == true) {
			   test.log(LogStatus.INFO, "Username is visible on UserPage");
		   }else {
			   test.log(LogStatus.INFO, "Username not visible");
		   }
		
		 
	}

	@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
	public void the_username_is_clicked_on_the_UserScreen(String arg1) {
		JenkinsUsersPage jenkinsUsersPage = PageFactory.initElements(driver, JenkinsUsersPage.class);
		jenkinsUsersPage.goToViewProfile(driver, arg1);
		
	}

	@Then("^the User Profile should display the \"([^\"]*)\" Username on the ProfileScreen$")
	public void the_User_Profile_should_display_the_Username_on_the_ProfileScreen(String arg1)  {
		ExcelUtils.setCellData("User Profile Displayed", Runner.counter, 0);
		ExcelUtils.setCellData(arg1, Runner.counter, 1);
		JenkinsPersonPage jenkinsPersonPage = PageFactory.initElements(driver, JenkinsPersonPage.class);
		if(jenkinsPersonPage.confirmPersonPage(arg1) == true) {
			HelperMethods.screenshot(driver);
			test.log(LogStatus.PASS, "Navigated to:" + arg1 + test.addScreenCapture(HelperMethods.destination1));
			ExcelUtils.setCellData("Pass", Runner.counter, 2);
		} else {
			HelperMethods.screenshot(driver);
			test.log(LogStatus.FAIL, "Navigated to the wrong page" + test.addScreenCapture(HelperMethods.destination1));
			ExcelUtils.setCellData("Fail", Runner.counter, 2);
		}
		
		assertTrue(jenkinsPersonPage.confirmPersonPage(arg1)==true);
	}

	@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
	public void the_Username_s_profile_page_has_been_loaded(String arg1)  {
		 driver.get(Constants.getUrl1());
		   test.log(LogStatus.INFO, "Opened the Jenkins Login Page");
		   JenkinsLoginPage jenkinsLoginPage = PageFactory.initElements(driver, JenkinsLoginPage.class);
		   jenkinsLoginPage.adminLogIn();
		   test.log(LogStatus.INFO, "Admin Logged in");
		   JenkinsHome jenkinsHomePage = PageFactory.initElements(driver, JenkinsHome.class);
		   jenkinsHomePage.goToManageJenkins();
		   JenkinsManagePage jenkinsManagePage = PageFactory.initElements(driver, JenkinsManagePage.class);
		   jenkinsManagePage.goToManageUsers(driver);
		   JenkinsUsersPage jenkinsUsersPage = PageFactory.initElements(driver, JenkinsUsersPage.class);
		   jenkinsUsersPage.goToViewProfile(driver, arg1);
	   
	}

	@Given("^the configure button has been clicked on the profile page$")
	public void the_configure_button_has_been_clicked_on_the_profile_page() {
	    JenkinsPersonPage jenkinsPersonPage = PageFactory.initElements(driver, JenkinsPersonPage.class);
	    jenkinsPersonPage.goToConfigurePage();
	    
	}

	@When("^I change the old email address on the Configure Page to a new email address \"([^\"]*)\"$")
	public void i_change_the_old_email_address_on_the_Configure_Page_to_a_new_email_address(String arg1) {
		JenkinsConfigurePage jenkinsConfigurePage = PageFactory.initElements(driver, JenkinsConfigurePage.class);
		jenkinsConfigurePage.changeEmail(arg1);
	    
	}

	@When("^I save the changes to the Configure Page$")
	public void i_save_the_changes_to_the_Configure_Page() throws Throwable {
		JenkinsConfigurePage jenkinsConfigurePage = PageFactory.initElements(driver, JenkinsConfigurePage.class);
		jenkinsConfigurePage.saveChanges();
	    
	}

	@Then("^the Configure Page should show the new email address \"([^\"]*)\"$")
	public void the_Configure_Page_should_show_the_new_email_address(String arg1) throws Throwable {
		JenkinsPersonPage jenkinsPersonPage = PageFactory.initElements(driver, JenkinsPersonPage.class);
	    jenkinsPersonPage.goToConfigurePage();
	    JenkinsConfigurePage jenkinsConfigurePage = PageFactory.initElements(driver, JenkinsConfigurePage.class);
	    if(jenkinsConfigurePage.confirmEmailChange(arg1)==true) {
	    	HelperMethods.screenshot(driver);
			test.log(LogStatus.PASS, "Email Change Successfully changed to: " + arg1 + test.addScreenCapture(HelperMethods.destination1));
	    } else {
	    	HelperMethods.screenshot(driver);
			test.log(LogStatus.FAIL, "Email Change Unsuccessful" + test.addScreenCapture(HelperMethods.destination1));
	    }
	   assertTrue(jenkinsConfigurePage.confirmEmailChange(arg1)==true); 
	   
	}


}
