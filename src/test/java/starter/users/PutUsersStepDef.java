package starter.users;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import starter.utils.Constants;

import java.io.File;

public class PutUsersStepDef {
    @Steps
    InbuscapUsersAPI inbuscapUsersAPI;
    @Given("Update data with valid multipart form data; phone number {string}, password {string}, ktp {string}, npwp {string}, avatar {string}")
    public void UpdateDataWithMultiplePartForm(String number, String pass, String ktp, String npwp, String avatar){
        File avatarFile = new File (Constants.AVATAR+avatar);
        inbuscapUsersAPI.UpdateData(number, pass, ktp, npwp, avatarFile );
    }
    @When("Send request update data")
    public void sendRequestUpdateData() {
        SerenityRest.when().put(InbuscapUsersAPI.CREATE_USERS);
    }
}
