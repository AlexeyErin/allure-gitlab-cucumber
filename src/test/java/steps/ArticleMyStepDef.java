package steps;

import api.Article;
import impl.ArticleServiceImp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import service.ArticleService;


import java.util.List;

import static context.RunContext.RUN_CONTEXT;

public class ArticleMyStepDef {
    ArticleService articleService = new ArticleServiceImp();

    @Given("Get Articles {string} Request")
    public void getArticlesRequest(String url) {
        List<Article> articleList = articleService.getArticles(url);
        System.out.println(articleList);
    }

    @Then("Response code is: {string}")
    public void responseCodeIs(String status) {
        ValidatableResponse validatableResponse = RUN_CONTEXT.get("response", ValidatableResponse.class);
        int actualStatus = validatableResponse.extract().statusCode();
        int expectedStatus = Integer.parseInt(status);

        Assert.assertEquals(actualStatus, expectedStatus);
    }
}
