package com.org.stepdef;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Stubs {
	
	public static  WireMockServer server= new WireMockServer(8080);
	
	
	@Before
	public void startServer() throws JsonProcessingException, IOException {
		server.start();
		WireMock.configureFor("localhost", 8080);
		
		ResponseDefinitionBuilder response= new ResponseDefinitionBuilder();
		response.withStatus(200);
		response.withHeader("Content-type", "application/json");
		//JsonNode node= new
		ObjectMapper mapper = new ObjectMapper();
		File from = new File("response.json");
		JsonNode masterJSON = mapper.readTree(from);
		response.withJsonBody(masterJSON);
		WireMock.stubFor(WireMock.get("/getNaceDetails/398481").willReturn(response));
		System.out.println("server started");
		
	}
	@After
	public void stopServer() {
		server.shutdown();
	}

}
