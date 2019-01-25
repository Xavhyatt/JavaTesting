package AutoTesting.Project;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class ProjectStepper {
	ExtentReports report;
	ExtentTest test;
	final private String driverType = "webdriver.chrome.driver";
	final private String fileLoc = Constants.getDriverloc();
	WebDriver driver = null;

	@Before
	public void setUp() throws IOException {

		ProjectRunner.counter++;
		report = ProjectRunner.report;
		test = report.startTest("React Page Testing" + ProjectRunner.counter);
		System.setProperty(driverType, fileLoc);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown()  {
		
		driver.quit();
		report.endTest(test);
		report.flush();	
	}
	
	
	@Given("^I navigate to the React Application$")
	public void i_navigate_to_the_React_Application() {
		driver.get(Constants.getUrl1());
		test.log(LogStatus.INFO, "Opened The React Page");
	}

	@When("^I click the Link to Automated Testing Exercise Form$")
	public void i_click_the_Link_to_Automated_Testing_Exercise_Form()  {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.goToForm();
		test.log(LogStatus.INFO, "Navigated to the creation Page");
	}

	@When("^I fill click the \"([^\"]*)\" dropdown menu$")
	public void i_fill_click_the_dropdown_menu(String arg1) {
		Actions action = new Actions(driver);
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.fillCountry(driver, arg1, action);		
	}

	@When("^I fill out the email field with \"([^\"]*)\"$")
	public void i_fill_out_the_email_field_with(String arg1) {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.fillEmail(arg1);
	}

	@When("^I fill out the first password field with \"([^\"]*)\"$")
	public void i_fill_out_the_first_password_field_with(String arg1) {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.fillPassword(arg1);
	}

	@When("^I fill out the second password field with \"([^\"]*)\"$")
	public void i_fill_out_the_second_password_field_with(String arg1) {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.fillPasswordConf(arg1);
		test.log(LogStatus.INFO, "Correct Password Confirmation Entered");
	}

	@Then("^I should see a Success! Message$")
	public void i_should_see_a_Success_Message() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		String check = homePage.checkCreation();
		if(check.equals("Success!")) {
			HelperMethods.screenshot(driver);
			test.log(LogStatus.PASS, "Test Completed Successfully" + test.addScreenCapture(HelperMethods.destination1));
		} else {
			HelperMethods.screenshot(driver);
			test.log(LogStatus.FAIL, "Test Failed" + test.addScreenCapture(HelperMethods.destination1));
		}	
		Assert.assertEquals("Success!", check);
		
	}

	@When("^I fill out the second password field with the wrong password \"([^\"]*)\"$")
	public void i_fill_out_the_second_password_field_with_the_wrong_password(String arg1) {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.fillPasswordConf(arg1);
		test.log(LogStatus.INFO, "Incorrect Password Confirmation Entered");
	}

	@Then("^I should see a message stating that the passwords do not match\\.$")
	public void i_should_see_a_message_stating_that_the_passwords_do_not_match() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		String check = homePage.checkFail();
		
		if(check.equals("The passwords do not match")) {
			HelperMethods.screenshot(driver);
			test.log(LogStatus.PASS, "Test Completed Successfully" + test.addScreenCapture(HelperMethods.destination1));
		} else {
			HelperMethods.screenshot(driver);
			test.log(LogStatus.FAIL, "Test Failed" + test.addScreenCapture(HelperMethods.destination1));
		}	
		Assert.assertEquals("The passwords do not match", check);
	}
	
	
	
}