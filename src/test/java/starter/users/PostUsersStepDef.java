package starter.users;

import io.cucumber.java.bs.I;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.utils.Constants;

import java.io.File;

public class PostUsersStepDef {
    @Steps
    InbuscapUsersAPI inbuscapUsersAPI;
    @Given("Create user by json {}")
    public void createUserByValidJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        inbuscapUsersAPI.createUsers(jsonFile);
    }

    @When("Send request create users")
    public void sendRequestCreateUsers() {
        SerenityRest.when()
                .post(InbuscapUsersAPI.CREATE_USERS);
    }


    @Given("Login user by json {}")
    public void loginUserByJsonLoginDataJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        inbuscapUsersAPI.loginUsers(jsonFile);

    }

    @When("Send request login users")
    public void sendRequestLoginUsers() {
        SerenityRest.when()
                .post(InbuscapUsersAPI.LOGIN_USERS);
    }
}
