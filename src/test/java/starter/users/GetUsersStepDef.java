package starter.users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Condition;
import starter.utils.Constants;


import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetUsersStepDef {
    @Steps
    InbuscapUsersAPI inbuscapUsersAPI;
    @Given("Get users with path {string}")
    public void getUsersWithValidPage(String path) {
        inbuscapUsersAPI.getUsersWithValidPage(path);
    }
    @When("Send request get user")
    public void sendRequestGetUser(){
        SerenityRest.when()
                .get(InbuscapUsersAPI.GET_PATH);
    }

    @And("Response body name should be {string} and email should be {string}")
    public void responseBodyNameShouldBeAndEmailShouldBe(String name, String email) {
        SerenityRest.and()
                .body(InbuscapUsersResponses.NAME, equalTo(name))
                .body(InbuscapUsersResponses.EMAIL, equalTo(email));
    }

    @And("Validate json schema {string}")
    public void validateJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }
}
