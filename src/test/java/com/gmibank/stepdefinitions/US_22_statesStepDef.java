package com.gmibank.stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmibank.pojos.Customer;
import com.gmibank.utilities.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class US_22_statesStepDef {
    Response response;
    String bearerToken = ConfigReader.getProperty("token");
    Customer[] customers;
    @Given("user sets all response using api end point {string}")
    public void user_sets_all_response_using_api_end_point(String url) {
        response = given().headers(
                "Authorization",
                "Bearer "+ bearerToken,
                "ContentType",
                ContentType.JSON)
                .when()
                .get(url)
                .then()
                .contentType(ContentType.JSON)
                .extract().response();
      }

    @Given("user deserializes customer data as json to java pojo")
    public void user_deserializes_customer_data_as_json_to_java_pojo() throws IOException {
        ObjectMapper obj = new ObjectMapper();
        customers= obj.readValue(response.asString(),Customer[].class);
        for (int i = 0; i < customers.length ; i++) {
            if(customers[i].getUser() != null)
                System.out.println("State: "+ customers[i].getState());
        }
    }

    @Then("user validates states")
    public void user_validates_states() {

    }

}
