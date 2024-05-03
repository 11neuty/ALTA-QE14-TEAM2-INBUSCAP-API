package starter.inbuscap;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class TransactionAPI {
    public static String GET_TRANSACTIONS = Constants.BASE_URL+"transactions/{returns}";
    public static String TRANSACTIONS_TOPUP = Constants.BASE_URL+"transactions/topup";
    public static String TRANSACTIONS_WITHDRAW = Constants.BASE_URL+"transactions/withdraw";


    @Step("Get transaction")
    public void GetTransaction(String returns){
        SerenityRest.given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTQ3NjU5OTAsImlhdCI6MTcxNDc1NTE5MCwiaWQiOiI5NSIsImlzX2FjdGl2ZSI6MSwiaXNfYWRtaW4iOmZhbHNlfQ.nYoQdXBErS6_-gQwGCG498yaNG8AHK90MzWAvFMmzyA")
                .pathParam("returns", returns);
    }

    @Step("Top Up with valid data")
    public void TopUpWithValidData(File json){
        SerenityRest.given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTQ3NjU5OTAsImlhdCI6MTcxNDc1NTE5MCwiaWQiOiI5NSIsImlzX2FjdGl2ZSI6MSwiaXNfYWRtaW4iOmZhbHNlfQ.nYoQdXBErS6_-gQwGCG498yaNG8AHK90MzWAvFMmzyA")
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Withdraw with valid data")
    public void WithdrawWithValidData(File json){
        SerenityRest.given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTQ3NjU5OTAsImlhdCI6MTcxNDc1NTE5MCwiaWQiOiI5NSIsImlzX2FjdGl2ZSI6MSwiaXNfYWRtaW4iOmZhbHNlfQ.nYoQdXBErS6_-gQwGCG498yaNG8AHK90MzWAvFMmzyA")
                .contentType(ContentType.JSON)
                .body(json);
    }
}
