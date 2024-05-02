package starter.proposals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class DeleteProposalsStepDef {
    @Steps
    InbuscapProposalsAPI inbuscapProposalsAPI;
    @Given("Delete user by id {int}")
    public void deleteUserById(int proposals_id) {
        inbuscapProposalsAPI.deleteProposal(proposals_id);
    }

    @When("Send request delete proposals")
    public void sendRequestDeleteProposals() {
        SerenityRest.when()
                .delete(InbuscapProposalsAPI.PROPOSALS_ID);
    }
}
