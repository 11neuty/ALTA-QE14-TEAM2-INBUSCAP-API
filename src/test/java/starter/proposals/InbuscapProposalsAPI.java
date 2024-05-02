package starter.proposals;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class InbuscapProposalsAPI {
    public static String GET_PATH = Constants.BASE_URL + "/{path}";
    public static String GET_PARAM = Constants.BASE_URL + "myproposals?{param}";
    public static String PROPOSALS_ID = Constants.BASE_URL + "/proposals/{proposals_id}";
    public static String PROPOSALS = Constants.BASE_URL + "/proposals";
    @Step("Get proposals by path")
    public void getProposalsByPath(String path){
        SerenityRest.given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTQ1ODY0MTUsImlhdCI6MTcxNDU3NTYxNSwiaWQiOiI2MCIsImlzX2FjdGl2ZSI6MCwiaXNfYWRtaW4iOmZhbHNlfQ._s1aas8slYMhCYJZlQowGySQ6O96tzuX1smw_WWd0aY")
                .pathParam("path", path);
    }

    @Step("Get my proposals by param")
    public void getProposalsByParam(String param){
        SerenityRest.given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTQ1ODY0MTUsImlhdCI6MTcxNDU3NTYxNSwiaWQiOiI2MCIsImlzX2FjdGl2ZSI6MCwiaXNfYWRtaW4iOmZhbHNlfQ._s1aas8slYMhCYJZlQowGySQ6O96tzuX1smw_WWd0aY")
                .pathParam("param", param);
    }

    @Step("Get proposals by id")
    public void getProposalsById(int proposalsId){
        SerenityRest.given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTQ1ODY0MTUsImlhdCI6MTcxNDU3NTYxNSwiaWQiOiI2MCIsImlzX2FjdGl2ZSI6MCwiaXNfYWRtaW4iOmZhbHNlfQ._s1aas8slYMhCYJZlQowGySQ6O96tzuX1smw_WWd0aY")
                .pathParam("proposals_id", proposalsId);

    }
    @Step("Create proposals by multipart data")
    public void createProposals(File image, String title, String desc, int capital, int share, File proposal){
        SerenityRest.given().log().all()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTQ1ODY0MTUsImlhdCI6MTcxNDU3NTYxNSwiaWQiOiI2MCIsImlzX2FjdGl2ZSI6MCwiaXNfYWRtaW4iOmZhbHNlfQ._s1aas8slYMhCYJZlQowGySQ6O96tzuX1smw_WWd0aY")
                .contentType("multipart/form-data")
                .multiPart("file", image)
                .multiPart("title", title)
                .multiPart("description", desc)
                .multiPart("capital", capital)
                .multiPart("share", share)
                .multiPart("proposal", proposal)
                .post(InbuscapProposalsAPI.PROPOSALS);
    }
}
