package com.qa.quickstart.RESTAssured;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;

import cucumber.api.java.en.Given;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PersonSwaggerTests {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	
	@Test
	
	public void put() {
		
		baseURI = "http://localhost:8080/v1/person";
		
		request = given();
		request.header("Content-Type","application/json");
		request.header("userId", "12345678");
		
		Map<String, Object> emptyAddress = new HashMap<String, Object>();
		
		emptyAddress.put("id", 1);

		emptyAddress.put("line1","ABC Street");
		emptyAddress.put("line2", "Anfield");
		emptyAddress.put("city","Liverpool");
		emptyAddress.put("state", "England");
		emptyAddress.put("zip", "L12 2AD");
		
		JSONArray address = new JSONArray();
		address.put(emptyAddress);
		
		JSONObject params = new JSONObject();
		
		params.put("addresses", address);
		params.put("dateOfBirth", "2018-09-26T09:03:05.006Z");
		params.put("firstName", "Greg");
		params.put("gender", "M");
		params.put("id", 1);
		params.put("lastName", "Eden");
		params.put("middleName", "James");
		
		
		System.out.println(request.body(params.toString()));
		
		response = request.put();
		System.out.println(response.prettyPrint());
		System.out.println(response.getStatusCode());
		
			
	}
	
	@Test
	@Ignore
	public void get() {
		Response response = given().contentType(ContentType.JSON).when()
				.get("http://localhost:8080/v1/person/1");
		System.out.println(response.getStatusCode());
		System.out.println(response.asString());
	}
}
