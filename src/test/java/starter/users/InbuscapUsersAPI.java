package starter.users;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.utils.Constants;

import java.io.File;

public class InbuscapUsersAPI {
    public static String GET_PATH = Constants.BASE_URL + "/{path}";
    public static String CREATE_USERS = Constants.BASE_URL + "/users";
    public static String LOGIN_USERS = Constants.BASE_URL + "/login";

    @Step("Get users with valid page")
    public void getUsersWithValidPage(String path){
        SerenityRest.given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTQ1NjAyMTIsImlhdCI6MTcxNDU0OTQxMiwiaWQiOiIxIiwiaXNfYWN0aXZlIjoxLCJpc19hZG1pbiI6ZmFsc2V9.UDoUnK69goERvYG9__lQqsuAjKo_oFcHMEVTumFm908")
                .pathParam("path", path);
    }
    @Step("Create users with valid json")
    public void createUsers(File json){
        SerenityRest.given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTQ1NTcxNjYsImlhdCI6MTcxNDU0NjM2NiwiaWQiOiIxIiwiaXNfYWN0aXZlIjoxLCJpc19hZG1pbiI6ZmFsc2V9._KWRyd6wdQVLSP8nBCagjDVVMdM9-BHZnKCqz4LTxrg")
                .contentType(ContentType.JSON).body(json);
    }
    @Step("Login user by json")
    public void
    loginUsers(File json){
        SerenityRest.given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTQ1NTcxNjYsImlhdCI6MTcxNDU0NjM2NiwiaWQiOiIxIiwiaXNfYWN0aXZlIjoxLCJpc19hZG1pbiI6ZmFsc2V9._KWRyd6wdQVLSP8nBCagjDVVMdM9-BHZnKCqz4LTxrg")
                .contentType(ContentType.JSON).body(json);
    }
}
