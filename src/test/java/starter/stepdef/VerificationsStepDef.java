package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.zh_cn.假如;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.inbuscap.VerificationsAPI;
import starter.utils.Constants;

import java.io.File;

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
                .put(VerificationsAPI.USERS);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }

    @Given("Verification users by id {int} and json request body {string}")
    public void verificationUsersById(int id, String json) {
        File jsonFile = new File(Constants.REQ_BODY + "Verifications/"+ json);
        verificationsAPI.verificationByIdAndReqBody(id, jsonFile);
    }

    @When("Send request verification user by id")
    public void sendRequestVerificationUserById() {
        SerenityRest.when()
                .post(VerificationsAPI.USERS_ID);
    }

    @Given("Verification users by proposals id")
    public void verificationUsersByProposalsId(int proposal_id, String json) {
        File jsonFile = new File(Constants.REQ_BODY + "Verifications/" + json);
        verificationsAPI.verficationByProposalId(proposal_id,jsonFile);

    }

    @When("Request verification user by proposals id")
    public void requestVerificationUserByProposalsId() {
        SerenityRest.when()
                .post(VerificationsAPI.PROPOSALS_ID);
    }

}
