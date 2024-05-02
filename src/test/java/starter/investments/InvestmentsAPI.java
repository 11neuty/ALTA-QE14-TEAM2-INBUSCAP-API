package starter.investments;

import io.restassured.http.ContentType;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class InvestmentsAPI {
    public static String INVESTMENTS = Constants.BASE_URL+"investments?page={page}";
    public static String DETAIL_INVESTED = Constants.BASE_URL+"investments/{proposal_id}";
    public static String ADD_INVESTMENT = Constants.BASE_URL+"investments";
    public static String DELETE_INVESTMENT = Constants.BASE_URL+"investments?proposal_id={proposal_id}";



    @Step("Get all investment proposal with valid parameter page")
    public void getAllInvestmentProposalWithValidParameterPage(int page){
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN_USER)
                .pathParam("page", page);
    }

    @Step("Get all investment proposal with valid parameter page")
    public void getAllInvestmentProposalWithInvalidParameterPage(String page){
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN_USER)
                .pathParam("page", page);
    }

    @Step("Get detail invested proposal with valid proposal id")
    public void getDetailInvestedProposalWithValidProposalId(int proposal_id){
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN_USER)
                .pathParam("proposal_id", proposal_id);
    }

    @Step("Get detail invested proposal with invalid proposal id")
    public void getDetailInvestedProposalWithInvalidProposalId(String proposal_id){
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN_USER)
                .pathParam("proposal_id", proposal_id);
    }

    @Step("Add new investment")
    public void AddInvestment (File json){
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN_USER)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete investment with valid proposal id")
    public void deleteInvestmentWithValidProposalId(int proposal_id){
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN_USER)
                .pathParam("proposal_id", proposal_id);
    }
    @Step("Delete investment with invalid proposal id")
    public void deleteInvestmentWithInvalidProposalId(String proposal_id){
        SerenityRest.given()
                .header("Authorization", Constants.TOKEN_USER)
                .pathParam("proposal_id", proposal_id);
    }

}
