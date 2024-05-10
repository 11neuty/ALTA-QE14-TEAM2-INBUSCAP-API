package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.inbuscap.ProposalsAPI;
import starter.utils.Constants;

import java.io.File;

public class ProposalsStepDef {
    @Steps
    ProposalsAPI proposalsAPI;

    //POST PROPOSAL

    @Given("Create proposals by multipart data form image {string}, title {string}, description {string}, capital {int}, share {int}, proposal {string}")
    public void createProposalsByMultipartDataFormImageTitleDescriptionCapitalShareProposal(String image, String title, String desc, int capital, int share, String proposal) {
        File imageFile = new File(Constants.IMAGE + image);
        File proposalFile = new File(Constants.PROPOSAL + proposal);
        proposalsAPI.createProposals(imageFile, title, desc, capital, share, proposalFile);
    }
    @Given("Create proposals by invalid multipart data form image {string}, title {int}, description {string}, capital {int}, share {int}, proposal {string}")
    public void createProposalsByInvalidMultipartDataFormImageTitleDescriptionCapitalShareProposal(String image, int title, String desc, int capital, int share, String proposal) {
        File imageFile = new File(Constants.IMAGE + image);
        File proposalFile = new File(Constants.PROPOSAL + proposal);
        proposalsAPI.createProposalsInvalid(imageFile, title, desc, capital, share, proposalFile);
    }

    @When("Send request create proposal")
    public void sendRequestCreateProposal() {
        SerenityRest.when().post(ProposalsAPI.PROPOSALS);
    }



    // POST REPORT
    @Given("Create new report by multipart form data proposal_id {int}, date {string}, document {string}, amount {int}")
    public void createNewReportByMultipartFormDataProposal_idDateDocumentAmount(int proposal_id, String date, String report, int amount) {
        File reportFile = new File(Constants.REPORT + report);
        proposalsAPI.createReport(proposal_id, date, reportFile, amount);
    }

    @When("Send request create report")
    public void sendRequestCreateReport() {
        SerenityRest.when()
                .post(ProposalsAPI.REPORT);
    }

    // GET PROPOSALS

    @Given("Get proposals with parameters page {int}")
    public void getProposalsWithPathAndParametersPage(int page) {
        proposalsAPI.getProposalsByPathAndParam(page);
    }
    @Given("Get proposals with invalid parameters page {string}")
    public void getProposalsWithPathAndParametersPage(String page) {
        proposalsAPI.getProposalsByInvalidPathAndParam(page);
    }

    @When("Send request get proposals")
    public void sendRequestGetProposals() {
        SerenityRest.when()
                .get(ProposalsAPI.GET_PROPOSALS_PARAM);
    }

    @Given("Get myproposals with param {int}")
    public void getMyproposalsWithPath(int param) {
        proposalsAPI.getProposalsByParam(param);
    }
    @Given("Get myproposals with invalid param {}")
    public void getMyproposalsWithInvalidPath(String param) {
        proposalsAPI.getProposalsByInvalidParam(param);
    }

    @When("Send request get myproposals")
    public void sendRequestGetMyproposals() {
        SerenityRest.when()
                .get(ProposalsAPI.GET_PARAM);
    }

    @Given("Get proposals with id {int}")
    public void getProposalsWithId(int proposalsID) {
        proposalsAPI.getProposalsById(proposalsID);
    }

    @When("Send request get proposals by id")
    public void sendRequestGetProposalsById() {
        SerenityRest.when()
                .get(ProposalsAPI.PROPOSALS_ID);
    }

    // PUT PROPOSALS
    @Given("Edit proposal by proposal id {int} and multipart form data image {string}, title {string}, description {string}, capital {int}, share {int}, proposal {string}")
    public void editProposalByProposalIdAndMulupartFormDataImageTitleDescriptionCapitalProposal(int proposal_id, String image, String title, String desc, int capital, int share, String proposal) {
        File imageFile = new File(Constants.IMAGE + image);
        File proposalFile = new File(Constants.PROPOSAL + proposal);
        proposalsAPI.putProposal(proposal_id, imageFile, title, desc, capital, share, proposalFile);
    }
    @Given("Edit proposal by invalid proposal id {int} and multipart form data image {string}, title {int}, description {string}, capital {int}, proposal {string}")
    public void editProposalByInvalidProposalIdAndMulupartFormDataImageTitleDescriptionCapitalProposal(int proposal_id, String image, int title, String desc, int capital, String proposal) {
        File imageFile = new File(Constants.IMAGE + image);
        File proposalFile = new File(Constants.PROPOSAL + proposal);
        proposalsAPI.putProposalInvalid(proposal_id, imageFile, title, desc, capital, proposalFile);
    }

    @When("Send request edit proposal")
    public void sendRequestEditProposal() {
        SerenityRest.when()
                .put(ProposalsAPI.PROPOSALS_ID);
    }

    // DELETE PROPOSALS
    @Given("Delete user by id {int}")
    public void deleteUserById(int proposals_id) {
        proposalsAPI.deleteProposal(proposals_id);
    }

    @When("Send request delete proposals")
    public void sendRequestDeleteProposals() {
        SerenityRest.when()
                .delete(ProposalsAPI.PROPOSALS_ID);
    }

}
