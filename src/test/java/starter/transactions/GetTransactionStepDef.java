package starter.transactions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class GetTransactionStepDef {

    @Steps
    TransactionsAPI transactionsAPI;

    @Given("Get available returns from investment with valid path {string}")
    public void getAvailableReturnsFromInvestmentWithValidPath(String returns) {
        transactionsAPI.GetTransaction(returns);
    }


    @When("Send request get available returns")
    public void sendRequestGetAvailableReturns() {
        SerenityRest.when()
                .get(TransactionsAPI.GET_TRANSACTIONS);
    }

    @Given("Get available returns from investment with invalid path {string}")
    public void getAvailableReturnsFromInvestmentWithInvalidPath(String returns) {
        transactionsAPI.GetTransaction(returns);
    }
}
