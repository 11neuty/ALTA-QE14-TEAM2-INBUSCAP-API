package starter.proposals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import javax.naming.directory.SearchResult;

public class GetProposalsStepDef {
    @Steps
    InbuscapProposalsAPI inbuscapProposalsAPI;
    @Given("Get proposals with path {string}")
    public void getProposalsWithPath(String path) {
        inbuscapProposalsAPI.getProposalsByPath(path);
    }

    @When("Send request get proposals")
    public void sendRequestGetProposals() {
        SerenityRest.when()
                .get(InbuscapProposalsAPI.GET_PATH);
    }

    @Given("Get myproposals with param {string}")
    public void getMyproposalsWithPath(String param) {
        inbuscapProposalsAPI.getProposalsByParam(param);
    }

    @When("Send request get myproposals")
    public void sendRequestGetMyproposals() {
        SerenityRest.when()
                .get(InbuscapProposalsAPI.GET_PARAM);
    }

    @Given("Get proposals with id {int}")
    public void getProposalsWithId(int proposalsID) {
        inbuscapProposalsAPI.getProposalsById(proposalsID);
    }

    @When("Send request get proposals by id")
    public void sendRequestGetProposalsById() {
        SerenityRest.when()
                .get(InbuscapProposalsAPI.PROPOSALS_ID);
    }
}
