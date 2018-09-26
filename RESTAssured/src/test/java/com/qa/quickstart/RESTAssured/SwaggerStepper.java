package com.qa.quickstart.RESTAssured;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static io.restassured.RestAssured.*;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class SwaggerStepper {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	JSONObject params = new JSONObject();
	JSONArray ratingArray = new JSONArray();
	
	@Given("^that you are on the Swagger Page$")
	public void that_you_are_on_the_Swagger_Page() {
	   request = given().contentType(ContentType.JSON);
	    
	}

	@When("^the details \"([^\"]*)\" city, \"([^\"]*)\" description, \"([^\"]*)\" name, \"([^\"]*)\" rating are entered$")
	public void the_details_city_description_name_rating_are_entered(String arg1, String arg2, String arg3, String arg4)  {
		
		String[] myArray = arg4.split(",");
				
	    params.put("city", arg1);
		params.put("description", arg2);
		params.put("name", arg3);
		params.put("rating",myArray);
	    
	}

	@When("^the details are submitted$")
	public void the_details_are_submitted() { 
			response = request.body(params.toString()).post("http://localhost:8090/example/v1/hotels");
			System.out.println(response.statusCode());

	}

	@Then("^the details should be retrievable$")
	public void the_details_should_be_retrievable() throws Throwable {
	   Response response1 = given().contentType(ContentType.JSON).when().get("http://localhost:8090/example/v1/hotels?page=0&size=100");
	    System.out.println(response1.getStatusCode());
	    System.out.println(response1.asString());
	}

}
