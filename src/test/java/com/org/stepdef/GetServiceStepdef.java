package com.org.stepdef;

import org.testng.Assert;

import com.org.services.GetNaceDetails;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;



public class GetServiceStepdef {
	
	private Response response;

@Given("^Get nace details order is called$")
public void get_resources_service_called() {
	
    System.out.println("get  resources called");
    
    GetNaceDetails getNaceDetails=new GetNaceDetails();
    response=getNaceDetails.GetNaceDetailsService();
    System.out.println(response.getStatusCode());
}

@Then("^Status should be (\\d+)$")
public void status_should_be(int arg1)  {
   System.out.println(" status code should be 200");
   response.prettyPrint();
   Assert.assertEquals(response.getStatusCode(), 200);
}

@Then("^response should have different user parameters$")
public void response_should_have_different_user_parameters()  {
	System.out.println(response.body().jsonPath().getString("Order"));
   Assert.assertTrue(response.body().jsonPath().getString("Order").contains("398481"));
}
	
}
