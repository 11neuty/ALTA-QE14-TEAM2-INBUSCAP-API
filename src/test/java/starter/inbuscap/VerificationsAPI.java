package starter.inbuscap;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class VerificationsAPI {
    public static String USERS = Constants.BASE_URL + "/verifications/users";
    public static String USERS_ID = Constants.BASE_URL + "/verifications/users/{users_id}";
    public static String PROPOSALS_ID = Constants.BASE_URL + "verifications/proposals/{proposals_id}";

    @Step("Verifications users by valid multipart data form")
    public void verificationMultipartData(File ktp, File npwp, File avatar){
        SerenityRest.given().log().all()
                .header("Authorization", Constants.TOKEN_USER)
                .contentType("multipart/form-data")
                .multiPart("photo_ktp", ktp)
                .multiPart("photo_npwp", npwp)
                .multiPart("photo_selfie", avatar)
                .put(VerificationsAPI.USERS);
    }
    @Step("Verificaation by id and json body request")
    public void verificationByIdAndReqBody(int id, File json){
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN_USER)
                .pathParam("user_id", id)
                .contentType(ContentType.JSON).body(json);
    }
    @Step("Verification by proposal id and json body request")
    public void verficationByProposalId(int id, File json){
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN_USER)
                .pathParam("proposal_id", id)
                .contentType(ContentType.JSON).body(json);
    }
}
