package starter.transactions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.utils.Constants;

import java.io.File;

public class PostTopUpStepDef {
    @Steps
    TransactionsAPI transactionsAPI;

    @Given("Top Up with valid data {string}")
    public void topUpWithValidData(String json) {
        File jsonFile = new File(Constants.REQ_BODY+"Transaction/"+json);
        transactionsAPI.TopUpWithValidData(jsonFile);
    }

    @When("Send request Top Up")
    public void sendRequestTopUp() {
        SerenityRest.when()
                .post(TransactionsAPI.TRANSACTIONS_TOPUP);
    }

    @Given("Top Up with invalid payment type {}")
    public void topUpWithInvalidPaymentTypeJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY+"Transaction/"+json);
        transactionsAPI.TopUpWithValidData(jsonFile);
    }

    @Given("Top Up with invalid amount {string}")
    public void topUpWithInvalidAmount(String json) {
        File jsonFile = new File(Constants.REQ_BODY+"Transaction/"+json);
        transactionsAPI.TopUpWithValidData(jsonFile);
    }

    @Given("Top Up with invalid payment_type and amount {string}")
    public void topUpWithInvalidPayment_typeAndAmount(String json) {
        File jsonFile = new File(Constants.REQ_BODY+"Transaction/"+json);
        transactionsAPI.TopUpWithValidData(jsonFile);
    }
}
