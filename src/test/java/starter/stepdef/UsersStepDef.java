package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.inbuscap.InbuscapResponses;
import starter.inbuscap.UsersAPI;
import starter.utils.Constants;

import javax.swing.plaf.PanelUI;
import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UsersStepDef {
    @Steps
    UsersAPI usersAPI;
    public static String TOKEN_RECIPIENT;
    public static String TOKEN_ADMIN;
    public static String TOKEN_INVESTOR;
    public static String TOKEN_DELETE;

    //POST
    @Given("Create user by json {}")
    public void createUserByValidJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY + "Users/"+ json);
        usersAPI.createUsers(jsonFile);
    }

    @When("Send request create users")
    public void sendRequestCreateUsers() {
        SerenityRest.when()
                .post(UsersAPI.CREATE_USERS);
    }



    @Given("Login user by json {string}")
    public void loginUserByJsonLoginDataJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY + "Users/" + json);
        usersAPI.loginUsers(jsonFile);

    }

    @When("Send request login users {string}")
    public void sendRequestLoginUsers(String role) {
        Response response =  SerenityRest.when()
                .post(UsersAPI.LOGIN_USERS);
        JsonPath jsonpath = response.jsonPath();
        String token = jsonpath.get("data.token");
        if(role.equals("recipient")){
            System.out.println("ini token recipient" + token);
            TOKEN_RECIPIENT = token;
        }
        else if(role.equals("admin")){
            System.out.println("ini token admin" + token);
            TOKEN_ADMIN = token;
        }
        else if(role.equals("investor")){
            System.out.println("ini token investor" + token);
            TOKEN_INVESTOR = token;
        }
        else if(role.equals("delete")){
            System.out.println("ini token hapus" + token);
        }
        else{
            System.out.println("User not found");
        }


    }
    //GET
    @Given("Get users with path {string}")
    public void getUsersWithValidPage(String path) {
        usersAPI.getUsersWithValidPage(path);
    }
    @When("Send request get user")
    public void sendRequestGetUser(){
        SerenityRest.when()
                .get(UsersAPI.GET_PATH);
    }


    @And("Validate json schema {string}")
    public void validateJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA + "Users/"+json);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }
    @And("Validate json schema proposals {string}")
    public void validateJsonSchemaProposals(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA + "Proposals/"+json);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    // PUT
    @Given("Update data with valid multipart form data; full name {string}, email {string}, phone number {string}, password {string}, ktp {string}, npwp {string}, avatar {string}")
    public void UpdateDataWithMultiplePartForm(String name, String email, String number, String pass, String ktp, String npwp, String avatar){
        File avatarFile = new File (Constants.AVATAR+avatar);
        usersAPI.UpdateData(name, email, number, pass, ktp, npwp, avatarFile );
    }
    @When("Send request update data")
    public void sendRequestUpdateData() {
        SerenityRest.when().put(UsersAPI.CREATE_USERS);
    }


    // DELETE
    @Given("Delete user with path {string}")
    public void deleteUserWithValidPath(String path) {
        usersAPI.DeleteUser(path);
    }

    @When("Send request delete users")
    public void sendRequestDeleteUsers() {
        SerenityRest.when().delete(UsersAPI.GET_PATH);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode){
        SerenityRest.then()
                .statusCode(statusCode);
    }
    @And("Response body message should be {string}")
    public void responseBodyMessageShouldBe(String msg) {
        SerenityRest.and()
                .body(InbuscapResponses.MESSAGE, equalTo(msg));
    }
}
