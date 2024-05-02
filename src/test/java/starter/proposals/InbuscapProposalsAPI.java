package starter.proposals;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.utils.Constants;

import java.io.File;

public class InbuscapProposalsAPI {
    public static String GET_PATH = Constants.BASE_URL + "/{path}";
    public static String GET_PARAM = Constants.BASE_URL + "myproposals?{param}";
    public static String PROPOSALS_ID = Constants.BASE_URL + "/proposals/{proposals_id}";
    public static String PROPOSALS = Constants.BASE_URL + "/proposals";
    public static String REPORT = Constants.BASE_URL + "/report";
    @Step("Get proposals by path")
    public void getProposalsByPath(String path){
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN_USER)
                .pathParam("path", path);
    }

    @Step("Get my proposals by param")
    public void getProposalsByParam(String param){
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN_USER)
                .pathParam("param", param);
    }

    @Step("Get proposals by id")
    public void getProposalsById(int proposalsId){
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN_USER)
                .pathParam("proposals_id", proposalsId);

    }
    @Step("Create proposals by multipart data")
    public void createProposals(File image, String title, String desc, int capital, int share, File proposal){
        SerenityRest.given().log().all()
                .header("Authorization", Constants.TOKEN_USER)
                .contentType("multipart/form-data")
                .multiPart("file", image)
                .multiPart("title", title)
                .multiPart("description", desc)
                .multiPart("capital", capital)
                .multiPart("share", share)
                .multiPart("proposal", proposal)
                .post(InbuscapProposalsAPI.PROPOSALS);
    }
    @Step("Create report by multipart form data")
    public void createReport(int proposal_id, String date, File report, int amount){
        SerenityRest.given().log().all()
                .header("Authorization", Constants.TOKEN_USER)
                .contentType("multipart/form-data")
                .multiPart("proposal_id", proposal_id)
                .multiPart("date", date)
                .multiPart("document", report)
                .multiPart("amount", amount)
                .post(InbuscapProposalsAPI.REPORT);

    }
    @Step("Put proposal by id and multipart form data")
    public void putProposal(int proposals_id, File image, String title,String desc, int capital, File proposal ){
        SerenityRest.given().log().all()
                .header("Authorization", Constants.TOKEN_USER)
                .pathParam("proposals_id", proposals_id)
                .contentType("multipart/form-data")
                .multiPart("image", image)
                .multiPart("title", title)
                .multiPart("descripption", desc)
                .multiPart("capital", capital)
                .multiPart("proposal", proposal)
                .post(InbuscapProposalsAPI.PROPOSALS_ID);

    }
    @Step("Delete proposals by proposal id")
    public void deleteProposal(int proposals_id){
        SerenityRest.given().log().all()
                .header("Authorization", Constants.TOKEN_USER)
                .pathParam("proposals_id", proposals_id);
    }
}
