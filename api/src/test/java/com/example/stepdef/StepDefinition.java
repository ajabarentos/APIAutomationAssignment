package com.example.stepdef;

//Cucumber libraries
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//Rest-Assured libraries
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class StepDefinition {

	// Global variable response so it will be available to all step definition
	// methods within the class
	private Response response;

	// Step definition method for setting the Base URI of the API
	@Given("the Base URL is {string}")
	public void setBaseURI(String url) {
		RestAssured.baseURI = url;
	}

	// Step definition method for setting parameter key and value
	@When("the parameter is {string} = {string}")
	public void setParameter(String paramKey, String paramValue) {
		// Convert string value to boolean since cucumber doesn't support boolean as
		// step definition parameter
		boolean parsedParamValue = Boolean.parseBoolean(paramValue);
		given().queryParam(paramKey, parsedParamValue);
	}

	// Step definition method for sending GET API request with resource as parameter
	@And("the user sends GET request to {string}")
	public void sendGetRequest(String resource) {
		response = get(resource);
	}

	// Step definition method for validating the status code of the API response
	@Then("the status code is {int}")
	public void validateStatusCode(int statusCode) {
		response.then().statusCode(statusCode);
	}

	// Step definition method for validating the value of the Name field
	@And("the Name is {string}")
	public void validateName(String name) {
		response.then().body("Name", equalTo(name));
	}

	// Step definition method for validating the value of the CanRelist field
	@And("the CanRelist is {string}")
	public void validateCanRelist(String canRelist) {
		// Convert string value to boolean since cucumber doesn't support boolean as
		// step definition parameter
		boolean parsedCanRelist = Boolean.parseBoolean(canRelist);
		response.then().body("CanRelist", equalTo(parsedCanRelist));
	}

	// Step definition method for validating value of a specific name
	@And("the Promotions element with Name {string} has a Description that contains {string}")
	public void validatePromotionsDescription(String promotionName, String promotionDesc) {
		// Get the API response body then parse the response using JsonPath class
		String responseBody = response.getBody().asString();
		JsonPath jsonPath = new JsonPath(responseBody);
		// Get Promotions array count in the API response
		int promotionsCount = jsonPath.getInt("Promotions.size()");
		// Initially set boolean to false for the assertion later
		boolean isFound = false;

		// Loop until all promotion items are iterated
		for (int i = 0; i < promotionsCount; i++) {
			// Get the Promotion name and description via the current index value (i)
			String name = jsonPath.getString("Promotions[" + i + "].Name");
			String description = jsonPath.getString("Promotions[" + i + "].Description");

			// Validate if Promotions element with the expected Name has a Description that
			// contains the expected Promotion Description
			if (name.equals(promotionName) && description.contains(promotionDesc)) {
				// If true, then boolean will be set to true for successful assertion and the
				// loop will break
				isFound = true;
				break;
			}
		}
		assertThat(isFound, is(true));
	}

}
