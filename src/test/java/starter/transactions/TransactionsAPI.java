package starter.transactions;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class TransactionsAPI {
    public static String GET_TRANSACTIONS = Constants.BASE_URL+"transactions/{returns}";

    @Step("Get transaction")
    public void GetTransaction(String returns){
        SerenityRest.given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTQ2NjA0MzAsImlhdCI6MTcxNDY0OTYzMCwiaWQiOiIxIiwiaXNfYWN0aXZlIjoxLCJpc19hZG1pbiI6ZmFsc2V9.m2B8-gwvy60N0UI49oTbWp1S0YFXIa8nbxAdDYDyi0g")
                .pathParam("returns", returns);
    }

}
