package starter.investments;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class GetInvestmentsStepDef {
    @Steps
    InvestmentsAPI investmentsAPI;

    @Given("Get all investment proposal with valid parameter page {int}")
    public void getAllInvestmentProposalWithValidParameterPage(int page) {
        investmentsAPI.getAllInvestmentProposalWithValidParameterPage(page);
    }

    @When("Send get investment")
    public void sendGetInvestment() {
        SerenityRest.when()
                .get(InvestmentsAPI.INVESTMENTS);
    }


    @Given("Get all investment proposal with invalid parameter page {}")
    public void getAllInvestmentProposalWithInvalidParameterPagePage(String page) {
        investmentsAPI.getAllInvestmentProposalWithInvalidParameterPage(page);
    }
}
