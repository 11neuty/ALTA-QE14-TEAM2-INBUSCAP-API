package starter.inbuscap;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.stepdef.UsersStepDef;
import starter.utils.Constants;

import java.io.File;

public class UsersAPI {
    public static String GET_PATH = Constants.BASE_URL + "{path}";
    public static String CREATE_USERS = Constants.BASE_URL + "users";
    public static String LOGIN_USERS = Constants.BASE_URL + "login";


    @Step("Login user by json")
    public void
    loginUsers(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON).body(json);
    }

    @Step("Get users with valid page")
    public void getUsersWithValidPage(String path){
        SerenityRest.given()
                .header("Authorization", "Bearer " + UsersStepDef.TOKEN_RECIPIENT)
                .pathParam("path", path);


    }
    @Step("Create users with valid json")
    public void createUsers(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON).body(json);
    }


    @Step("Update Data by multipart form data")
    public void UpdateData(String fullname, String email, String number, String password, String ktp, String npwp, File avatar){
        SerenityRest.given().log().all()
                .header("Authorization", "Bearer " + UsersStepDef.TOKEN_RECIPIENT)
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
                .header("Authorization",Constants.TOKEN_USER)
                .pathParam("path",path);
    }
}
