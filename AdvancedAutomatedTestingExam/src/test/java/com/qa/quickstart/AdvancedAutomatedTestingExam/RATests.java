package com.qa.quickstart.AdvancedAutomatedTestingExam;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class RATests {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	public String updateOwnerTelephone(int id, String telephone ) {
		
		RestAssured.baseURI = Constants.api+"owners/" + id;
		
		request = given();
		request.header("Content-Type", "application/json");
		
		Map<String, Object> visitArray = new HashMap<String, Object>();

		JSONArray visitArray1 = new JSONArray();
		visitArray1.put(visitArray);
			
		
		Map<String, Object> petTypeArray = new HashMap<String, Object>();
		
		petTypeArray.put("id", 1);
		petTypeArray.put("name", "cat");
		
		JSONArray petTypeArray1 = new JSONArray();
		petTypeArray1.put(petTypeArray);
		
		Map<String, Object> petArray = new HashMap<String, Object>();
		
		petArray.put("birthDate", "2010/09/07");
		petArray.put("id", "1");
		petArray.put("name","Leo");
		petArray.put("owner",1);
		petArray.put("type", petTypeArray1);
		petArray.put("visits", visitArray1);
		
		JSONArray petArray1 = new JSONArray();
		petArray1.put(petTypeArray);

		
		JSONObject params = new JSONObject();
		
		params.put("id", 10);
	    params.put("firstName", "Carlos");
	    params.put("lastName", "Franklin");
	    params.put("address", "110 W. Liberty St.");
	    params.put("city", "Madison");
	    params.put("telephone", telephone);
	    params.put("pets", petArray1);
		
	    request.body(params.toString());
	    
	    response = request.put();
	    System.out.println(response.getStatusCode());
	    String completeResponse = "Response Code: "+response.getStatusCode();
	    return completeResponse;
	}
	
	public int deleteAnimal(int id) {
		
		RestAssured.baseURI = Constants.api+"pets/" + id;
		request = given().contentType(ContentType.JSON);
		response = request.when().delete(Constants.api+"pets/" + id);
		
		return response.getStatusCode();
	}
	
	public String addNewPet(String name) {
		
RestAssured.baseURI = Constants.api+"pets/";
		
		request = given();
		request.header("Content-Type", "application/json");
		
		Map<String, Object> visitArray = new HashMap<String, Object>();

		JSONArray visitArray1 = new JSONArray();
		visitArray1.put(visitArray);
			
		
		Map<String, Object> petTypeArray = new HashMap<String, Object>();
		
		petTypeArray.put("id", 1);
		petTypeArray.put("name", "dog");
		
		JSONArray petTypeArray1 = new JSONArray();
		petTypeArray1.put(petTypeArray);
		
		JSONObject params = new JSONObject();
		
		params.put("id", 10);
	    params.put("firstName", "Carlos");
	    params.put("lastName", "Franklin");
	    params.put("address", "110 W. Liberty St.");
	    params.put("city", "Madison");
	    params.put("telephone", "012345888");
	    
	    
	   
		
		JSONObject petArray = new JSONObject();
		
		petArray.put("birthDate", "2010/09/07");
		petArray.put("id", 70);
		petArray.put("name",name);
		petArray.put("owner", params);
		petArray.put("type", petTypeArray);
		petArray.put("visits", visitArray1);
		
		
		
		 request.body(petArray.toString());
		    
		    response = request.put();
		    System.out.println(response.getStatusCode());
		    String completeResponse = "Response Code: "+response.getStatusCode();
		    return completeResponse;

	}
	
	public String newOwner() {
		
		RestAssured.baseURI = Constants.api+"owners/";
		
		request = given();
		request.header("Content-Type", "application/json");
		
		Map<String, Object> visitArray = new HashMap<String, Object>();

		JSONArray visitArray1 = new JSONArray();
		visitArray1.put(visitArray);
			
		
		Map<String, Object> petTypeArray = new HashMap<String, Object>();
		
		petTypeArray.put("id", 1);
		petTypeArray.put("name", "cat");
		
		JSONArray petTypeArray1 = new JSONArray();
		petTypeArray1.put(petTypeArray);
		
		Map<String, Object> petArray = new HashMap<String, Object>();
		
		petArray.put("birthDate", "2010/09/07");
		petArray.put("id", "1");
		petArray.put("name","Leo");
		petArray.put("owner",1);
		petArray.put("type", petTypeArray1);
		petArray.put("visits", visitArray1);
		
		JSONArray petArray1 = new JSONArray();
		petArray1.put(petTypeArray);

		
		JSONObject params = new JSONObject();
		
		params.put("id", 10);
	    params.put("firstName", "Carlos");
	    params.put("lastName", "Franklin");
	    params.put("address", "110 W. Liberty St.");
	    params.put("city", "Madison");
	    params.put("telephone", "2223333444");
	    params.put("pets", petArray1);
		
	    request.body(params.toString());
	    
	    response = request.put();
	    System.out.println(response.getStatusCode());
	    String completeResponse = "Response Code: "+response.getStatusCode();
	    return completeResponse;
		
	}
}
