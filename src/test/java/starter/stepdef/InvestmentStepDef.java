package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.inbuscap.InbuscapResponses;
import starter.inbuscap.InvestmentAPI;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class InvestmentStepDef {
    @Steps
    InvestmentAPI investmentAPI;

    @Given("Add new investment with valid data json {string}")
    public void addNewInvestmentWithValidDataJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY+"Investments/"+json);
        investmentAPI.AddInvestment(jsonFile);
    }

    @When("Send request add new investment")
    public void sendRequestAddNewInvestment() {
        SerenityRest.when()
                .post(InvestmentAPI.ADD_INVESTMENT);
    }

    @Given("Add new investment with invalid proposal id {string}")
    public void addNewInvestmentWithInvalidProposalId(String json) {
        File jsonFile = new File(Constants.REQ_BODY+"Investments/"+json);
        investmentAPI.AddInvestment(jsonFile);
    }

    @Given("Add new investment with invalid amount {string}")
    public void addNewInvestmentWithInvalidAmount(String json) {
        File jsonFile = new File(Constants.REQ_BODY+"Investments/"+json);
        investmentAPI.AddInvestment(jsonFile);
    }

    @Given("Add new investment with invalid proposal id and amount {string}")
    public void addNewInvestmentWithInvalidProposalIdAndAmount(String json) {
        File jsonFile = new File(Constants.REQ_BODY+"Investments/"+json);
        investmentAPI.AddInvestment(jsonFile);
    }
    InvestmentAPI investmentsAPI;

    @Given("Get all investment proposal with valid parameter page {int}")
    public void getAllInvestmentProposalWithValidParameterPage(int page) {
        investmentAPI.getAllInvestmentProposalWithValidParameterPage(page);
    }

    @When("Send get investment")
    public void sendGetInvestment() {
        SerenityRest.when()
                .get(InvestmentAPI.INVESTMENTS);
    }


    @Given("Get all investment proposal with invalid parameter page {string}")
    public void getAllInvestmentProposalWithInvalidParameterPage(String page) {
        investmentAPI.getAllInvestmentProposalWithInvalidParameterPage(page);
    }

    @Given("Get detail invested proposal with valid proposal id {int}")
    public void getDetailInvestedProposalWithValidProposalId(int proposal_id) {
        investmentAPI.getDetailInvestedProposalWithValidProposalId(proposal_id);
    }

    @When("Send get detail invested proposal")
    public void sendGetDetailInvestedProposal() {
        SerenityRest.when()
                .get(InvestmentAPI.DETAIL_INVESTED);
    }

    @Given("Get detail invested proposal with invalid proposal id {string}")
    public void getDetailInvestedProposalWithInvalidProposalId(String proposal_id) {
        investmentAPI.getDetailInvestedProposalWithInvalidProposalId(proposal_id);
    }

    @Given("Delete data investment with valid proposal id {int}")
    public void deleteDataInvestmentWithValidProposalId(int proposal_id) {
        investmentAPI.deleteInvestmentWithValidProposalId(proposal_id);
    }

    @When("Send delete investment")
    public void sendDeleteInvestment() {
        SerenityRest.when()
                .delete(InvestmentAPI.DELETE_INVESTMENT);
    }

    @Given("Delete data investment with invalid proposal id {string}")
    public void deleteDataInvestmentWithInvalidProposalId(String proposal_id) {
        investmentAPI.deleteInvestmentWithInvalidProposalId(proposal_id);
    }
    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.and()
                .statusCode(statusCode);
    }

    @And("Response body message was {string}")
    public void responseBodyMessageWas(String message) {
        SerenityRest.and()
                .body(InbuscapResponses.MESSAGE,equalTo(message));
    }

    @And("Validate json schema {string}")
    public void validateJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA+"/Investment/" + json);
        SerenityRest.and()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));

    }



}
