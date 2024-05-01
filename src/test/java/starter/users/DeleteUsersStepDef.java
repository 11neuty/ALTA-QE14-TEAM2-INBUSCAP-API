package starter.users;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class DeleteUsersStepDef {
    @Steps
    InbuscapUsersAPI inbuscapUsersAPI;
    @Given("Delete user with path {string}")
    public void deleteUserWithValidPath(String path) {
        inbuscapUsersAPI.DeleteUser(path);
    }

    @When("Send request delete users")
    public void sendRequestDeleteUsers() {
        SerenityRest.when().delete(InbuscapUsersAPI.GET_PATH);
    }
}
