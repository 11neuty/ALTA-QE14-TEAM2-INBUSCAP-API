package starter.users;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

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

}
