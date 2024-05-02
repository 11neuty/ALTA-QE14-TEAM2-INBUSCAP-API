package starter.investments;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class DeleteInvestmentStepDef {
    @Steps
    InvestmentsAPI investmentsAPI;

    @Given("Delete data investment with valid proposal id {int}")
    public void deleteDataInvestmentWithValidProposalId(int proposal_id) {
        investmentsAPI.deleteInvestmentWithValidProposalId(proposal_id);
    }

    @When("Send delete investment")
    public void sendDeleteInvestment() {
        SerenityRest.when()
                .delete(InvestmentsAPI.DELETE_INVESMENT);
    }

    @Given("Delete data investment with invalid proposal id {string}")
    public void deleteDataInvestmentWithInvalidProposalId(String proposal_id) {
        investmentsAPI.deleteInvestmentWithInvalidProposalId(proposal_id);
    }
}
