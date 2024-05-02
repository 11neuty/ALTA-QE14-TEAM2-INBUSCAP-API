package starter.transactions;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class TransactionsAPI {
    public static String GET_TRANSACTIONS = Constants.BASE_URL+"transactions/{returns}";
    public static String TRANSACTIONS_TOPUP = Constants.BASE_URL+"transactions/topup";
    public static String TRANSACTIONS_WITHDRAW = Constants.BASE_URL+"transactions/withdraw";

    @Step("Get transaction")
    public void GetTransaction(String returns){
        SerenityRest.given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTQ2NjA0MzAsImlhdCI6MTcxNDY0OTYzMCwiaWQiOiIxIiwiaXNfYWN0aXZlIjoxLCJpc19hZG1pbiI6ZmFsc2V9.m2B8-gwvy60N0UI49oTbWp1S0YFXIa8nbxAdDYDyi0g")
                .pathParam("returns", returns);
    }

    @Step("Top Up with valid data")
    public void TopUpWithValidData(File json){
        SerenityRest.given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTQ2NzE1MzIsImlhdCI6MTcxNDY2MDczMiwiaWQiOiIxIiwiaXNfYWN0aXZlIjoxLCJpc19hZG1pbiI6ZmFsc2V9.EMJnCCsWOfxVZFYlTnrD1BiVDhZpNelmIKO5mvY1tMA")
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Withdraw with valid data")
    public void WithdrawWithValidData(File json){
        SerenityRest.given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTQ2NzE1MzIsImlhdCI6MTcxNDY2MDczMiwiaWQiOiIxIiwiaXNfYWN0aXZlIjoxLCJpc19hZG1pbiI6ZmFsc2V9.EMJnCCsWOfxVZFYlTnrD1BiVDhZpNelmIKO5mvY1tMA")
                .contentType(ContentType.JSON)
                .body(json);
    }


}
