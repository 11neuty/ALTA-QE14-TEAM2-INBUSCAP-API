package starter.inbuscap;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class UsersAPI {
    public static String GET_PATH = Constants.BASE_URL + "/{path}";
    public static String CREATE_USERS = Constants.BASE_URL + "/users";
    public static String LOGIN_USERS = Constants.BASE_URL + "/login";




    @Step("Get users with valid page")
    public void getUsersWithValidPage(String path){
        SerenityRest.given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTQ3MzA2NDgsImlhdCI6MTcxNDcxOTg0OCwiaWQiOiI5NSIsImlzX2FjdGl2ZSI6MCwiaXNfYWRtaW4iOmZhbHNlfQ.51SPjEBvqeJ5g_O6ZBUYqGMTxkrlvrgouU7kdVKMxu0")
                .pathParam("path", path);


    }
    @Step("Create users with valid json")
    public void createUsers(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON).body(json);
    }
    @Step("Login user by json")
    public void
    loginUsers(File json){
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN_USER)
                .contentType(ContentType.JSON).body(json);
    }

    @Step("Update Data by multipart form data")
    public void UpdateData(String fullname, String email, String number, String password, String ktp, String npwp, File avatar){
        SerenityRest.given().log().all()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTQ3Mjg5NDAsImlhdCI6MTcxNDcxODE0MCwiaWQiOiI5NSIsImlzX2FjdGl2ZSI6MCwiaXNfYWRtaW4iOmZhbHNlfQ.gIJcEF5Rgvbpa2Wwan_UDNqaaZd8D3o4u1QEKuReM1A")
                .contentType("multipart/form-data")
                .multiPart("fullname", fullname)
                .multiPart("email", email)
                .multiPart("handphone", number)
                .multiPart("password", password)
                .multiPart("ktp", ktp)
                .multiPart("npwp", npwp)
                .multiPart("avatar", avatar)
                .post(UsersAPI.CREATE_USERS);

    }
    @Step("Delete User with valid path")
    public void DeleteUser(String path){
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN_USER)
                .pathParam("path",path);
    }
}
