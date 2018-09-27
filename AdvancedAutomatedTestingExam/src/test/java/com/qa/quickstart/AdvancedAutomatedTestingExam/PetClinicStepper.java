package com.qa.quickstart.AdvancedAutomatedTestingExam;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Pa;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PetClinicStepper {
	
	ExtentReports report;
	ExtentTest test;
	final private  String driverType = "webdriver.chrome.driver";
	final private String fileLoc = "C:\\Testing\\chromedriver.exe";
	WebDriver driver = null;
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	RATests raTests = new RATests();
	String updateResponse;
	int deleteResponse;
	String addResponse;
	String newOwnerResponse;
	
	
	@Before
	public void setUp() {
		Runner.counter++;
		report = Runner.report;
		test = report.startTest("PetClinic Testing" + Runner.counter);
		System.setProperty(driverType, fileLoc);
		driver = new ChromeDriver();
		//ExcelUtils.setExcelFile(Path, sheetIndex);
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown() {
		driver.quit();
		report.endTest(test);
		report.flush();
	}
	
	@Given("^a vet$")
	public void a_vet()  {
	    driver.get(Constants.url);
	    test.log(LogStatus.INFO, "Viewing available animal care test");
	    test.log(LogStatus.INFO, "Opened the Pet Clinic Home Page");
	    request = given().contentType(ContentType.JSON);
	}

	@When("^I click on some records$")
	public void i_click_on_some_records()  {
		PetClinicHome petClinicHome = PageFactory.initElements(driver, PetClinicHome.class);
	    petClinicHome.goToSpecialties();
	    test.log(LogStatus.INFO, "Navigated to Specialties Page");
	    response = request.when().get(Constants.api+"specialties");
	    test.log(LogStatus.INFO, "Sent Get Request to the API");
	}

	@Then("^I can see the care available for animals$")
	public void i_can_see_the_care_available_for_animals() throws Throwable {
	    PetClinicSpecialties petClinicSpecialties = PageFactory.initElements(driver, PetClinicSpecialties.class);
	    if ( petClinicSpecialties.checkSpecialties() == true & response.getStatusCode() == 200) {
	    	HelperMethods.screenshot(driver);
	    	test.log(LogStatus.INFO, "Recieved the successful 200 response code");
	    	test.log(LogStatus.INFO, "API returned: " + response.asString());
	    	test.log(LogStatus.PASS, "Pet Care available Shown" + test.addScreenCapture(HelperMethods.destination1));
	    } else {
	    	HelperMethods.screenshot(driver);
	    	test.log(LogStatus.INFO, "API returned code: " + response.getStatusCode());
	    	test.log(LogStatus.FAIL, "Pet Care available not shown" + test.addScreenCapture(HelperMethods.destination1));
	    }   
	    test.log(LogStatus.INFO, "Spike Test on get specialties command" + test.addScreenCapture("C:\\Users\\Admin\\Desktop\\Eclipse workspace\\JMeter Graphs\\Spike\\"+"Get Specialties graphsResponseTimesOverTime.png"));
	    test.log(LogStatus.INFO, "Load Test on get specialties command" + test.addScreenCapture("C:\\Users\\Admin\\Desktop\\Eclipse workspace\\JMeter Graphs\\Load\\"+ "Get Specialties graphsResponseTimesOverTime.png"));
	    test.log(LogStatus.INFO, "Stress Test on get specialties command" + test.addScreenCapture("C:\\Users\\Admin\\Desktop\\Eclipse workspace\\JMeter Graphs"+"Get Specialties graphsResponseCodesPerSecond.png"));
	    assertTrue(petClinicSpecialties.checkSpecialties() == true);
	    
	}

	@Given("^an admin$")
	public void an_admin() {
		 driver.get(Constants.url);
		 test.log(LogStatus.INFO, "Opened the Pet Clinic Home Page");
		 request = given().contentType(ContentType.JSON);
	}

	@When("^I update a record$")
	public void i_update_a_record() throws InterruptedException {
		test.log(LogStatus.INFO, "Updating a Record Test");
		PetClinicHome petClinicHome = PageFactory.initElements(driver, PetClinicHome.class);
		petClinicHome.goToAllOwners();
		test.log(LogStatus.INFO, "Navigated to Add Owner Page");
		PetClinicOwners petClinicOwners = PageFactory.initElements(driver, PetClinicOwners.class);
		petClinicOwners.goToCarlos();
		PetClinicSpecificOwner petClinicSpecifOwner = PageFactory.initElements(driver, PetClinicSpecificOwner.class);
		petClinicSpecifOwner.goToEditOwner();
		PetClinicEditOwner petClinicEditOwner = PageFactory.initElements(driver, PetClinicEditOwner.class);
		petClinicEditOwner.changeAddress(Constants.testAddress);
		petClinicEditOwner.confirmEdit();
		updateResponse = raTests.updateOwnerTelephone(10,"1234567891");
		test.log(LogStatus.INFO, "Owner Telephone Updated!");
		System.out.println(updateResponse);
	}

	@Then("^the correct details are now shown$")
	public void the_correct_details_are_now_shown() throws InterruptedException {
		PetClinicSpecificOwner petClinicSpecificOwner = PageFactory.initElements(driver, PetClinicSpecificOwner.class);
		if (petClinicSpecificOwner.checkInfoUpdate(Constants.testAddress) == true & updateResponse.contains("204")) {
			test.log(LogStatus.INFO, updateResponse);
			HelperMethods.screenshot(driver);
	    	test.log(LogStatus.PASS, "Record Update Successful" + test.addScreenCapture(HelperMethods.destination1));
		} else {
			test.log(LogStatus.INFO, updateResponse);
			HelperMethods.screenshot(driver);
	    	test.log(LogStatus.FAIL, "Record Update Unsuccessful" + test.addScreenCapture(HelperMethods.destination1));
		}
		assertTrue(petClinicSpecificOwner.checkInfoUpdate(Constants.testAddress) == true);
		
	}

	@When("^I delete a animal$")
	public void i_delete_a_animal() throws InterruptedException  {
		test.log(LogStatus.INFO, "Deleting an animal record");
		PetClinicHome petClinicHome = PageFactory.initElements(driver, PetClinicHome.class);
		petClinicHome.goToAllOwners();
		PetClinicOwners petClinicOwners = PageFactory.initElements(driver, PetClinicOwners.class);
		petClinicOwners.goToCarlos();
		PetClinicSpecificOwner petClinicSpecificOwner = PageFactory.initElements(driver, PetClinicSpecificOwner.class);
		petClinicSpecificOwner.deletePet1();
		deleteResponse = raTests.deleteAnimal(23);
		test.log(LogStatus.INFO, "Attempt to delete animal");
	}

	@Then("^emails arent sent to deceased annimals$")
	public void emails_arent_sent_to_deceased_annimals() throws Throwable {
		PetClinicSpecificOwner petClinicSpecificOwner = PageFactory.initElements(driver, PetClinicSpecificOwner.class);
		if (petClinicSpecificOwner.checkPetTable("Lucky") == false & deleteResponse == 204) {
			HelperMethods.screenshot(driver);
			test.log(LogStatus.INFO, "Delete Response: " + deleteResponse);
	    	test.log(LogStatus.PASS, "Record of Animal Deleted!" + test.addScreenCapture(HelperMethods.destination1));
		} else {
			HelperMethods.screenshot(driver);
			test.log(LogStatus.INFO, "Delete Response: " + deleteResponse);
	    	test.log(LogStatus.FAIL, "Record of Animal Still Exists" + test.addScreenCapture(HelperMethods.destination1));
		}
		assertTrue(petClinicSpecificOwner.checkPetTable("Lucky") == false );
	    
	}

	@When("^I add new records$")
	public void i_add_new_records() throws InterruptedException  {
		PetClinicHome petClinicHome = PageFactory.initElements(driver, PetClinicHome.class);
		petClinicHome.goToAllOwners();
		test.log(LogStatus.INFO, "Navigated to Add Owner Page");
		PetClinicOwners petClinicOwners = PageFactory.initElements(driver, PetClinicOwners.class);
		petClinicOwners.goToCarlos();
		PetClinicSpecificOwner petClinicSpecifOwner = PageFactory.initElements(driver, PetClinicSpecificOwner.class);
		petClinicSpecifOwner.addNewPet();
		PetClinicAddNewPet PetClinicAddNewPet = PageFactory.initElements(driver, PetClinicAddNewPet.class);
		PetClinicAddNewPet.addNewPet(Constants.petName, Constants.petDOB);
		test.log(LogStatus.INFO, "New Pet Details Submitted");
		addResponse = raTests.addNewPet(Constants.petName);
		
	}

	@Then("^the records are correct$")
	public void the_records_are_correct() throws Throwable {
		PetClinicSpecificOwner petClinicSpecificOwner = PageFactory.initElements(driver, PetClinicSpecificOwner.class);
		if (petClinicSpecificOwner.checkPetTable(Constants.petName) == true) {
			HelperMethods.screenshot(driver);
	    	test.log(LogStatus.PASS, "New Animal Record Created" + test.addScreenCapture(HelperMethods.destination1));
		} else {
			HelperMethods.screenshot(driver);
	    	test.log(LogStatus.FAIL, "Error: New Animal not found" + test.addScreenCapture(HelperMethods.destination1));
		}
		assertTrue(petClinicSpecificOwner.checkPetTable(Constants.petName) == true);
	}

	@When("^I add new owners to the records$")
	public void i_add_new_owners_to_the_records()  {
		PetClinicHome petClinicHome = PageFactory.initElements(driver, PetClinicHome.class);
		petClinicHome.goToOwners();
		test.log(LogStatus.INFO, "Navigated to Add Owner Page");
	    PetClinicAddOwner petClinicAddOwner = PageFactory.initElements(driver, PetClinicAddOwner.class);
	    petClinicAddOwner.createNewOwner();
	    test.log(LogStatus.INFO, "New Owner details submitted");
	    newOwnerResponse = raTests.newOwner();
	}

	@Then("^the details show the change$")
	public void the_details_show_the_change() throws Throwable {
		  PetClinicOwners petClinicOwners = PageFactory.initElements(driver, PetClinicOwners.class);
		    if (petClinicOwners.checkNewOwnerAdded() == true) {
		    	HelperMethods.screenshot(driver);
		    	test.log(LogStatus.PASS, "New Owner is Shown" + test.addScreenCapture(HelperMethods.destination1));
		    } else {
		    	HelperMethods.screenshot(driver);
		    	test.log(LogStatus.FAIL, "New Owner not shown" + test.addScreenCapture(HelperMethods.destination1));
		    }
		    assertTrue(petClinicOwners.checkNewOwnerAdded() == true);
	}

	
}

	

