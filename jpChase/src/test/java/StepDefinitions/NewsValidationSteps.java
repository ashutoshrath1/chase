package StepDefinitions;

import Pages.NewsPage;
import Pages.SearchPage;
import Utilities.ConfigLoader;
import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class NewsValidationSteps {
    SearchPage searchPage= new SearchPage();
    NewsPage newsPage= new NewsPage();
    String s="";
    public NewsValidationSteps() {
    }

    @Given("I am on The Guardian news page")
    public void i_am_on_the_guardian_news_page() {
        Driver.getDriver().get(ConfigLoader.getInstance().getBaseUrl());
    }

    @When("I extract the content of the first news article")
    public void i_extract_the_content_of_the_first_news_article() {
         s= newsPage.getArticleName();
    }

    @And("I search for similar articles on Google")
    public void i_search_for_similar_articles_on_google() {
        Driver.getDriver().get(ConfigLoader.getInstance().secondaryBaseUrl());
        searchPage.enterSearchResult(s);
    }

    @And("The first Guardian news article is marked as valid")
    public void the_first_guardian_news_article_is_marked_as_valid() {
       Boolean validArticle= searchPage.validArticle();
       Assert.assertTrue(validArticle);
    }

    }