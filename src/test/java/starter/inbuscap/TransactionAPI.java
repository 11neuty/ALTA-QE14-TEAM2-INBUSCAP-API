package starter.inbuscap;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.stepdef.UsersStepDef;
import starter.utils.Constants;

import java.io.File;

public class TransactionAPI {
    public static String GET_TRANSACTIONS = Constants.BASE_URL+"transactions/{returns}";
    public static String TRANSACTIONS_TOPUP = Constants.BASE_URL+"transactions/topup";
    public static String TRANSACTIONS_WITHDRAW = Constants.BASE_URL+"transactions/withdraw";

    @Step("Top Up with valid data")
    public void TopUpWithValidData(File json){
        SerenityRest.given()
                .header("Authorization", "Bearer " + UsersStepDef.TOKEN_INVESTOR)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get transaction")
    public void GetTransaction(String returns){
        SerenityRest.given()
                .header("Authorization", "Bearer " + UsersStepDef.TOKEN_INVESTOR)
                .pathParam("returns", returns);
    }

    @Step("Withdraw with valid data")
    public void WithdrawWithValidData(File json){
        SerenityRest.given()
                .header("Authorization", "Bearer " + UsersStepDef.TOKEN_INVESTOR)
                .contentType(ContentType.JSON)
                .body(json);
    }


}
