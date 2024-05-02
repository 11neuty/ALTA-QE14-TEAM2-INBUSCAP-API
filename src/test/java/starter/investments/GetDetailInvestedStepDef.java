package starter.investments;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class GetDetailInvestedStepDef {
    @Steps
    InvestmentsAPI investmentsAPI;

    @Given("Get detail invested proposal with valid proposal id {int}")
    public void getDetailInvestedProposalWithValidProposalId(int proposal_id) {
        investmentsAPI.getDetailInvestedProposalWithValidProposalId(proposal_id);
    }

    @When("Send get detail invested proposal")
    public void sendGetDetailInvestedProposal() {
        SerenityRest.when()
                .get(InvestmentsAPI.DETAIL_INVESTED);
    }

    @Given("Get detail invested proposal with invalid proposal id {}")
    public void getDetailInvestedProposalWithInvalidProposalIdProposal_id(String proposal_id) {
        investmentsAPI.getDetailInvestedProposalWithInvalidProposalId(proposal_id);
    }
}
