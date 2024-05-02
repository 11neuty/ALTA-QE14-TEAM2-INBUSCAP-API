package starter.investments;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.utils.Constants;

import java.io.File;

public class PostInvestmentsStepDef {
    @Steps
    InvestmentsAPI investmentsAPI;

    @Given("Add new investment with valid data json {string}")
    public void addNewInvestmentWithValidDataJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY+"Investments/"+json);
        investmentsAPI.AddInvestment(jsonFile);
    }

    @When("Send request add new investment")
    public void sendRequestAddNewInvestment() {
        SerenityRest.when()
                .post(InvestmentsAPI.ADD_INVESMENT);
    }

    @Given("Add new investment with invalid proposal id {string}")
    public void addNewInvestmentWithInvalidProposalId(String json) {
        File jsonFile = new File(Constants.REQ_BODY+"Investments/"+json);
        investmentsAPI.AddInvestment(jsonFile);
    }

    @Given("Add new investment with invalid amount {string}")
    public void addNewInvestmentWithInvalidAmount(String json) {
        File jsonFile = new File(Constants.REQ_BODY+"Investments/"+json);
        investmentsAPI.AddInvestment(jsonFile);
    }

    @Given("Add new investment with invalid proposal id and amount {string}")
    public void addNewInvestmentWithInvalidProposalIdAndAmount(String json) {
        File jsonFile = new File(Constants.REQ_BODY+"Investments/"+json);
        investmentsAPI.AddInvestment(jsonFile);
    }
}
