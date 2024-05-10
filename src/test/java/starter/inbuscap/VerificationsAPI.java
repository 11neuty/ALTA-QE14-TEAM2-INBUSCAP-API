package starter.inbuscap;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.stepdef.UsersStepDef;
import starter.utils.Constants;

import java.io.File;

public class VerificationsAPI {
    public static String USERS = Constants.BASE_URL + "verifications/users/{status}";
    public static String VERIF_USERS = Constants.BASE_URL + "verifications/users";
    public static String PROPOSALS_ID = Constants.BASE_URL + "verifications/proposals/{proposals_id}";
    public static String GET_VERIFICATION_USERS = Constants.BASE_URL + "verifications/users?status={status}&page={page}";
    public static String GET_VERIFICATION_PROPOSALS = Constants.BASE_URL + "verifications/proposals?status={status}&page={page}";


    @Step("Verifications users by valid multipart data form")
    public void verificationMultipartData(File ktp, File npwp, File avatar){
        SerenityRest.given().log().all()
                .header("Authorization", "Bearer " + UsersStepDef.TOKEN_RECIPIENT)
                .contentType("multipart/form-data")
                .multiPart("photo_ktp", ktp)
                .multiPart("photo_npwp", npwp)
                .multiPart("photo_selfie", avatar);
    }
    @Step("Verificaation by id and json body request")
    public void verificationByIdAndReqBody(int id, File json){
        SerenityRest.given()
                .header("Authorization", "Bearer " + UsersStepDef.TOKEN_ADMIN)
                .pathParam("status", id)
                .contentType(ContentType.JSON).body(json);
    }
    @Step("Verification by proposal id and json body request")
    public void verficationByProposalId(int id, File json){
        SerenityRest.given()
                .header("Authorization", "Bearer " + UsersStepDef.TOKEN_ADMIN)
                .pathParam("proposals_id", id)
                .contentType(ContentType.JSON).body(json);
    }

    @Step("Get verification with valid parameter status and page")
    public void getVerificationValid(int status, int page){
        SerenityRest.given()
                .header("Authorization", "Bearer " + UsersStepDef.TOKEN_ADMIN)
                .pathParam("status", status)
                .pathParam("page", page);
    }

    @Step("Get verification with invalid parameter status and page")
    public void getVerificationInvalid(String status, String page){
        SerenityRest.given()
                .header("Authorization", "Bearer " + UsersStepDef.TOKEN_ADMIN)
                .pathParam("status", status)
                .pathParam("page", page);
    }

    @Step("Get verification with valid proposal id")
    public void getVerificationValidProposalId(int proposal_id){
        SerenityRest.given()
                .header("Authorization", "Bearer " + UsersStepDef.TOKEN_ADMIN)
                .pathParam("proposals_id", proposal_id);
    }

    @Step("Get verification with invalid proposal id")
    public void getVerificationInvalidProposalId(String proposal_id){
        SerenityRest.given()
                .header("Authorization", "Bearer " + UsersStepDef.TOKEN_ADMIN)
                .pathParam("proposals_id", proposal_id);
    }

    @Step("Get verification proposal with valid parameter status and page")
    public void getVerificationProposalValid(int status, int page){
        SerenityRest.given()
                .header("Authorization", "Bearer " + UsersStepDef.TOKEN_ADMIN)
                .pathParam("status", status)
                .pathParam("page", page);

    }

    @Step("Get verification proposal with invalid parameter status and page")
    public void getVerificationProposalInvalid(String status, String page){
        SerenityRest.given()
                .header("Authorization", "Bearer " + UsersStepDef.TOKEN_ADMIN)
                .pathParam("status", status)
                .pathParam("page", page);
    }



}
