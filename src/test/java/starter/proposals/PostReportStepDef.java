package starter.proposals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.utils.Constants;

import java.io.File;

public class PostReportStepDef {
    @Steps
    InbuscapProposalsAPI inbuscapProposalsAPI;
    @Given("Create new report by multipart form data proposal_id {int}, date {string}, document {string}, amount {int}")
    public void createNewReportByMultipartFormDataProposal_idDateDocumentAmount(int proposal_id, String date, String report, int amount) {
        File reportFile = new File(Constants.REPORT + report);
        inbuscapProposalsAPI.createReport(proposal_id,date, reportFile ,amount);
    }

    @When("Send request create report")
    public void sendRequestCreateReport() {
        SerenityRest.when()
                .post(InbuscapProposalsAPI.REPORT);
    }
}
