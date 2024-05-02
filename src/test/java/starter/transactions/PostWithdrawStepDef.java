package starter.transactions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.utils.Constants;

import java.io.File;

public class PostWithdrawStepDef {

    @Steps
    TransactionsAPI transactionsAPI;

    @Given("Withdraw with valid data {string}")
    public void withdrawWithValidData(String json) {
        File jsonFile = new File(Constants.REQ_BODY+"Transaction/"+json);
        transactionsAPI.WithdrawWithValidData(jsonFile);
    }

    @When("Send request withdraw")
    public void sendRequestWithdraw() {
        SerenityRest.when()
                .post(TransactionsAPI.TRANSACTIONS_WITHDRAW);
    }

    @Given("Withdraw with invalid bank {string}")
    public void withdrawWithInvalidBank(String json) {
        File jsonFile = new File(Constants.REQ_BODY+"Transaction/"+json);
        transactionsAPI.WithdrawWithValidData(jsonFile);
    }

    @Given("Withdraw with invalid bank account {string}")
    public void withdrawWithInvalidBankAccount(String json) {
        File jsonFile = new File(Constants.REQ_BODY+"Transaction/"+json);
        transactionsAPI.WithdrawWithValidData(jsonFile);
    }

    @Given("Withdraw with invalid amount {string}")
    public void withdrawWithInvalidAmount(String json) {
        File jsonFile = new File(Constants.REQ_BODY+"Transaction/"+json);
        transactionsAPI.WithdrawWithValidData(jsonFile);
    }

    @Given("Withdraw with invalid bank, bank account and amount {string}")
    public void withdrawWithInvalidBankBankAccountAndAmount(String json) {
        File jsonFile = new File(Constants.REQ_BODY+"Transaction/"+json);
        transactionsAPI.WithdrawWithValidData(jsonFile);
    }
}
