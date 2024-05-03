package starter.proposals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.utils.Constants;

import java.io.File;

public class PostProposalsStepDef {
    @Steps
    InbuscapProposalsAPI inbuscapProposalsAPI;
    @Given("Create proposals by multipart data form image {string}, title {string}, description {string}, capital {int}, share {int}, proposal {string}")
    public void createProposalsByMultipartDataFormImageTitleDescriptionCapitalShareProposal(String image, String title, String desc, int capital, int share, String proposal) {
        File imageFile = new File (Constants.IMAGE + image);
        File proposalFile = new File(Constants.PROPOSAL + proposal);
        inbuscapProposalsAPI.createProposals(imageFile, title, desc, capital, share, proposalFile);
    }

    @When("Send request create proposal")
    public void sendRequestCreateProposal() {
        SerenityRest.when().post(InbuscapProposalsAPI.PROPOSALS);
    }

    public static class PutProposalStepDef {
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
}
