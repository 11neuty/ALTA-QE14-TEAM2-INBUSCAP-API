package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.inbuscap.InbuscapResponses;
import starter.inbuscap.TransactionAPI;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class TransactionStepDef {

    @Steps
    TransactionAPI transactionAPI;

    @Given("Top Up with valid data {string}")
    public void topUpWithValidData(String jsonData) {
        File jsonFile = new File(Constants.REQ_BODY+"/Transaction/"+jsonData);
        transactionAPI.TopUpWithValidData(jsonFile);
    }

    @When("Send request Top Up")
    public void sendRequestTopUp() {
        SerenityRest.when()
                .post(TransactionAPI.TRANSACTIONS_TOPUP);
    }
//    @Given("Top Up with valid data {string}")
//    public void topUpWithValidData(String json) {
//        File jsonFile = new File(Constants.REQ_BODY+"/Transaction/"+json);
//        transactionAPI.TopUpWithValidData(jsonFile);
//    }
//
//    @When("Send request Top Up")
//    public void sendRequestTopUp() {
//        SerenityRest.when()
//                .post(TransactionAPI.TRANSACTIONS_TOPUP);
//    }

    @Given("Top Up with invalid payment type {}")
    public void topUpWithInvalidPaymentTypeJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY+"Transaction/"+json);
        transactionAPI.TopUpWithValidData(jsonFile);
    }

    @Given("Top Up with invalid amount {string}")
    public void topUpWithInvalidAmount(String json) {
        File jsonFile = new File(Constants.REQ_BODY+"Transaction/"+json);
        transactionAPI.TopUpWithValidData(jsonFile);
    }

    @Given("Top Up with invalid payment_type and amount {string}")
    public void topUpWithInvalidPayment_typeAndAmount(String json) {
        File jsonFile = new File(Constants.REQ_BODY+"Transaction/"+json);
        transactionAPI.TopUpWithValidData(jsonFile);
    }
    @Given("Withdraw with valid data {string}")
    public void withdrawWithValidData(String json) {
        File jsonFile = new File(Constants.REQ_BODY+"Transaction/"+json);
        transactionAPI.WithdrawWithValidData(jsonFile);
    }

    @When("Send request withdraw")
    public void sendRequestWithdraw() {
        SerenityRest.when()
                .post(TransactionAPI.TRANSACTIONS_WITHDRAW);
    }

    @Given("Withdraw with invalid bank {string}")
    public void withdrawWithInvalidBank(String json) {
        File jsonFile = new File(Constants.REQ_BODY+"Transaction/"+json);
        transactionAPI.WithdrawWithValidData(jsonFile);
    }

    @Given("Withdraw with invalid bank account {string}")
    public void withdrawWithInvalidBankAccount(String json) {
        File jsonFile = new File(Constants.REQ_BODY+"Transaction/"+json);
        transactionAPI.WithdrawWithValidData(jsonFile);
    }

    @Given("Withdraw with invalid amount {string}")
    public void withdrawWithInvalidAmount(String json) {
        File jsonFile = new File(Constants.REQ_BODY+"Transaction/"+json);
        transactionAPI.WithdrawWithValidData(jsonFile);
    }

    @Given("Withdraw with invalid bank, bank account and amount {string}")
    public void withdrawWithInvalidBankBankAccountAndAmount(String json) {
        File jsonFile = new File(Constants.REQ_BODY+"Transaction/"+json);
        transactionAPI.WithdrawWithValidData(jsonFile);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.and()
                .statusCode(statusCode);
    }


    @Given("Get available returns from investment with valid path {string}")
    public void getAvailableReturnsFromInvestmentWithValidPath(String returns) {
        transactionAPI.GetTransaction(returns);
    }

    @When("Send request get available returns")
    public void sendRequestGetAvailableReturns() {
        SerenityRest.when()
                .get(TransactionAPI.GET_TRANSACTIONS);
    }

    @Given("Get available returns from investment with invalid path {string}")
    public void getAvailableReturnsFromInvestmentWithInvalidPath(String returns) {
        transactionAPI.GetTransaction(returns);
    }

    @And("Response body message was {string}")
    public void responseBodyMessageWas(String message) {
        SerenityRest.and()
                .body(InbuscapResponses.MESSAGE,equalTo(message));
    }



}
