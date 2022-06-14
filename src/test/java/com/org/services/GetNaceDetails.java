package com.org.services;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetNaceDetails {

	
	public Response GetNaceDetailsService() {
		
		return RestAssured.given().get("http://localhost:8080/getNaceDetails/398481");
		
	}
}
