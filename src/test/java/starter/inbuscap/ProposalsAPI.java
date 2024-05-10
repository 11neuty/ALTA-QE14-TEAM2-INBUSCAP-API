package starter.inbuscap;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.stepdef.UsersStepDef;
import starter.utils.Constants;

import java.io.File;

public class ProposalsAPI {

    public static String GET_PROPOSALS_PARAM = Constants.BASE_URL + "proposals?page={param}";
    public static String GET_PARAM = Constants.BASE_URL + "myproposals?page={param}";
    public static String PROPOSALS_ID = Constants.BASE_URL + "proposals/{proposals_id}";
    public static String PROPOSALS = Constants.BASE_URL + "proposals";
    public static String REPORT = Constants.BASE_URL + "report";
    @Step("Get proposals by path and parameter")
    public void getProposalsByPathAndParam(int page){
        SerenityRest.given()
//                .header("Authorization", Constants.TOKEN_USER)
                .pathParam("param", page);
    }
    @Step("Get proposals by invalid path and parameter")
    public void getProposalsByInvalidPathAndParam(String page){
        SerenityRest.given()
//                .header("Authorization", Constants.TOKEN_USER)
                .pathParam("param", page);
    }


    @Step("Get my proposals by param")
    public void getProposalsByParam(int param){
        SerenityRest.given()
                .header("Authorization", "Bearer " + UsersStepDef.TOKEN_RECIPIENT)
                .pathParam("param", param);
    }
    @Step("Get my proposals by invalid param")
    public void getProposalsByInvalidParam(String param){
        SerenityRest.given()
                .header("Authorization", "Bearer " + UsersStepDef.TOKEN_RECIPIENT)
                .pathParam("param", param);
    }

    @Step("Get proposals by id")
    public void getProposalsById(int proposalsId){
        SerenityRest.given()
                .header("Authorization", "Bearer " + UsersStepDef.TOKEN_RECIPIENT)
                .pathParam("proposals_id", proposalsId);

    }
    @Step("Create proposals by multipart data")
    public void createProposals(File image, String title, String desc, int capital, int share, File proposal){
        SerenityRest.given().log().all()
                .header("Authorization","Bearer " + UsersStepDef.TOKEN_RECIPIENT)
                .contentType("multipart/form-data")
                .multiPart("image", image)
                .multiPart("title", title)
                .multiPart("description", desc)
                .multiPart("capital", capital)
                .multiPart("share", share)
                .multiPart("proposal", proposal);
    }
    @Step("Create proposals by multipart data")
    public void createProposalsInvalid(File image, int title, String desc, int capital, int share, File proposal){
        SerenityRest.given().log().all()
                .header("Authorization","Bearer " + UsersStepDef.TOKEN_RECIPIENT)
                .contentType("multipart/form-data")
                .multiPart("image", image)
                .multiPart("title", title)
                .multiPart("description", desc)
                .multiPart("capital", capital)
                .multiPart("share", share)
                .multiPart("proposal", proposal);
    }
    @Step("Create report by multipart form data")
    public void createReport(int proposal_id, String date, File report, int amount){
        SerenityRest.given().log().all()
                .header("Authorization", "Bearer " + UsersStepDef.TOKEN_RECIPIENT)
                .contentType("multipart/form-data")
                .multiPart("proposal_id", proposal_id)
                .multiPart("date", date)
                .multiPart("document", report)
                .multiPart("amount", amount)
                .post(ProposalsAPI.REPORT);

    }
    @Step("Put proposal by id and multipart form data")
    public void putProposal(int proposals_id, File image, String title, String desc, int capital, int share, File proposal){
        SerenityRest.given().log().all()
                .header("Authorization", "Bearer " + UsersStepDef.TOKEN_RECIPIENT)
                .pathParam("proposals_id", proposals_id)
                .contentType("multipart/form-data")
                .multiPart("image", image)
                .multiPart("title", title)
                .multiPart("description", desc)
                .multiPart("capital", capital)
                .multiPart("share", share)
                .multiPart("proposal", proposal);

    }
    @Step("Put proposal by invalid id and multipart form data")
    public void putProposalInvalid(int proposals_id, File image, int title, String desc, int capital, File proposal ){
        SerenityRest.given().log().all()
                .header("Authorization", "Bearer " + UsersStepDef.TOKEN_RECIPIENT)
                .pathParam("proposals_id", proposals_id)
                .contentType("multipart/form-data")
                .multiPart("image", image)
                .multiPart("title", title)
                .multiPart("description", desc)
                .multiPart("capital", capital)
                .multiPart("proposal", proposal);

    }
    @Step("Delete proposals by proposal id")
    public void deleteProposal(int proposals_id){
        SerenityRest.given().log().all()
                .header("Authorization", UsersStepDef.TOKEN_RECIPIENT)
                .pathParam("proposals_id", proposals_id);
    }
}
