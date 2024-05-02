package starter.users;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import starter.proposals.InbuscapProposalsAPI;
import starter.utils.Constants;

import java.io.File;

public class PutProposalStepDef {
    @Steps
    InbuscapProposalsAPI inbuscapProposalsAPI;
    @Given("Edit proposal by proposal id {int} and multipart form data image {string}, title {string}, description {string}, capital {int}, proposal {string}")
    public void editProposalByProposalIdAndMulupartFormDataImageTitleDescriptionCapitalProposal(int proposal_id, String image, String title, String desc, int capital, String proposal) {
        File imageFile = new File(Constants.IMAGE+image);
        File proposalFile = new File(Constants.PROPOSAL+proposal);
        inbuscapProposalsAPI.putProposal(proposal_id, imageFile, title, desc, capital, proposalFile);
    }

    @When("Send request edit proposal")
    public void sendRequestEditProposal() {
        SerenityRest.when()
                .post(InbuscapProposalsAPI.PROPOSALS_ID);
    }
}
