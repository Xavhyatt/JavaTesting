package com.qa.quickstart.RESTAssured;

import org.junit.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class SimpleRESTAssured {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	
	@Test
	public void exampleRestTestWhichShouldBe200() {
		given()
		.contentType(ContentType.JSON)
		.when()
		.get(Constants.url1 + "&t=IT")
		.then().statusCode(200);
	}

}
