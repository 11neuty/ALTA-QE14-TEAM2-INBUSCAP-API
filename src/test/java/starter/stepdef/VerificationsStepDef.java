package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.inbuscap.InbuscapResponses;
import starter.inbuscap.VerificationsAPI;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class VerificationsStepDef {
    @Steps
    VerificationsAPI verificationsAPI;

    @Given("Verification users send multipart data form photo ktp {string} photo npwp {string} photo selfie {string}")
    public void verificationUsersSendMultipartDataFormPhotoKtpPhotoNpwpPhotoSelfie(String ktp, String npwp, String selfie) {
        File ktpFile = new File(Constants.KTP + ktp);
        File npwpFile = new File(Constants.NPWP + npwp);
        File selfieFile = new File(Constants.AVATAR + selfie);
        verificationsAPI.verificationMultipartData(ktpFile,npwpFile,selfieFile);
    }

    @When("Send request verification")
    public void sendRequestVerification() {
        SerenityRest.when()
                .put(VerificationsAPI.VERIF_USERS);
    }

//    @Then("Status code should be {int}")
//    public void statusCodeShouldBe(int statusCode) {
//        SerenityRest.then()
//                .statusCode(statusCode);
//    }

    @Given("Verification users by status {int} and json request body {string}")
    public void verificationUsersById(int id, String json) {
        File jsonFile = new File(Constants.REQ_BODY + "Verifications\\"+ json);
        verificationsAPI.verificationByIdAndReqBody(id, jsonFile);
    }

    @When("Send request verification user by id")
    public void sendRequestVerificationUserById() {
        SerenityRest.when()
                .put(VerificationsAPI.USERS);
    }

    @Given("Verification users by proposals id {} and body {string}")
    public void verificationUsersByProposalsId(int proposal_id, String json) {
        File jsonFile = new File(Constants.REQ_BODY + "Verifications/" + json);
        verificationsAPI.verficationByProposalId(proposal_id,jsonFile);

    }

    @When("Request verification user by proposals id")
    public void requestVerificationUserByProposalsId() {
        SerenityRest.when()
                .put(VerificationsAPI.PROPOSALS_ID);
    }

    @Given("Get verification with valid parameter status {int} and page {int}")
    public void getVerificationWithValidParameterStatusAndPage(int status, int page) {
        verificationsAPI.getVerificationValid(status,page);
    }

    @When("Send request get verification by status and page")
    public void sendRequestGetVerificationByStatusAndPage() {
        SerenityRest.when()
                .get(VerificationsAPI.GET_VERIFICATION_USERS);
    }

    @Given("Get verification with valid parameter status {string} and page {string}")
    public void getVerificationWithValidParameterStatusAndPage(String status, String page) {
        verificationsAPI.getVerificationInvalid(status,page);
    }

    @Given("Get verification proposal with valid proposal id {int}")
    public void getVerificationWithValidProposalId(int proposal_id) {
        verificationsAPI.getVerificationValidProposalId(proposal_id);
    }

    @When("Send request get verification by proposal id")
    public void sendRequestGetVerificationByProposalId() {
        SerenityRest.when()
                .get(VerificationsAPI.PROPOSALS_ID);
    }


    @Given("Get verification proposal with invalid proposal id {string}")
    public void getVerificationProposalWithInvalidProposalId(String proposal_id) {
        verificationsAPI.getVerificationInvalidProposalId(proposal_id);
    }

    @Given("Get verification proposal with valid status {int} and page {int}")
    public void getVerificationProposalWithValidStatusAndPage(int status, int page) {
        verificationsAPI.getVerificationProposalValid(status, page);
    }

    @Given("Get verification proposal with invalid status {string} and page {string}")
    public void getVerificationProposalWithInvalidStatusAndPage(String status, String page) {
        verificationsAPI.getVerificationProposalInvalid(status, page);
    }

//    @And("Response body message was {string}")
//    public void responseBodyMessageWas(String message) {
//        SerenityRest.and()
//                .body(InbuscapResponses.MESSAGE,equalTo(message));
//    }

    @And("Validate Top up json schema {string}")
    public void validateTopUpJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA +"Verification/"+json);
        SerenityRest.and()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @When("Send request get verification proposal by status and page")
    public void sendRequestGetVerificationProposalByStatusAndPage() {
        SerenityRest.when()
                .get(VerificationsAPI.GET_VERIFICATION_PROPOSALS);
    }
}
