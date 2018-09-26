package com.qa.quickstart.RESTAssured;

import org.junit.Ignore;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

import org.json.JSONArray;
import org.json.JSONObject;

import static io.restassured.RestAssured.*;

public class Advanced {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	@Test
	
	public void getAllHotels() {
		
		Response response = given().contentType(ContentType.JSON).when()
				.get("http://localhost:8090/example/v1/hotels?page=0&size=100");
		System.out.println(response.getStatusCode());
		System.out.println(response.asString());
	}
	
	@Test
	
	public void post() {
		
		RestAssured.baseURI = "http://localhost:8090/example/v1/hotels";
		
		request = given();
		request.header("Content-Type", "application/json");
		
		JSONArray ratingArray = new JSONArray();
		ratingArray.put(5);
		ratingArray.put(9);
		ratingArray.put(8);
		ratingArray.put(7);
		ratingArray.put(8);
		
		//Build a Json Object to send to the API
		JSONObject params = new JSONObject();
		
		//params.put("id", 20);
		params.put("city", "Newcastle");
		params.put("description", "test");
		params.put("name", "Glenn");
		params.put("rating", ratingArray);
		
		System.out.println(request.body(params.toString()));
		
		//Send the Object
		response = request.post("/");
		
		System.out.println(response.getStatusCode());	
	}
	
	@Test
	@Ignore
	public void delete() {
		RestAssured.baseURI = "http://localhost:8090/example/v1/hotels";
		
		Response response = given().contentType(ContentType.JSON).when()
				.delete("http://localhost:8090/example/v1/hotels/14");
		System.out.println(response.getStatusCode());
		
		
	}

	@Test
	@Ignore
	public void getExample() {
		given()
		.contentType(ContentType.JSON)
		.when()
		.get(Constants.url2)
		.then().statusCode(200);
	}
	
	@Test
	@Ignore
	public void getOneHotel() {
		Response response = given().contentType(ContentType.JSON).when()
				.get("http://localhost:8090/example/v1/hotels/1");
		System.out.println(response.getStatusCode());
		System.out.println(response.asString());
	}
	
	@Test
	@Ignore
	public void put() {
	RestAssured.baseURI = "http://localhost:8090/example/v1/hotels/4";
		
		request = given();
		request.header("Content-Type", "application/json");
		
		//Build a Json Object to send to the API
		JSONObject params = new JSONObject();
		
		params.put("id", 4);
		params.put("city", "Newcastle");
		params.put("description", "update2");
		params.put("name", "Glenn");
		params.put("rating",8);
		
		System.out.println(request.body(params.toString()));
		
		//Send the Object
		response = request.put();
		
		System.out.println(response.getStatusCode());
	}

}
