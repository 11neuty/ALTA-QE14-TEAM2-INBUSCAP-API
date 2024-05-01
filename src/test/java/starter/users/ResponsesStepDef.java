package starter.users;

import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;

public class ResponsesStepDef {
    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode){
        SerenityRest.then()
                .statusCode(statusCode);
    }
}
