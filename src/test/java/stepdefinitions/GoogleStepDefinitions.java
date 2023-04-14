package stepdefinitions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.GooglePage;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class GoogleStepDefinitions {

    GooglePage googlePage = new GooglePage();

    @Given("I navigate to {string}")
    public void i_navigate_to(String string) {
//        open("https://google.com");
        open(string);//going to the URL
        sleep(3000);//3 seconds
    }

    @Given("I wait for {int} seconds")
    public void i_wait_for_seconds(Integer int1) {
        sleep(int1*1000);
        //3 seconds = 3000 milliseconds => sleep method uses millisecond, we need to multiply the digit inside parenthesis with 1000
        //Selenide waits 4 seconds as default
        //To wait more than 4 seconds we use sleep method
    }
    @Given("I navigate back")
    public void i_navigate_back() {
        back();
    }
    @Given("I navigate forward")
    public void i_navigate_forward() {
        forward();
    }
    @Given("I refresh the page")
    public void i_refresh_the_page() {
        refresh();
    }
    @Then("I hold the browser open")
    public void i_hold_the_browser_open() {
        Configuration.holdBrowserOpen=true;
    }

    @When("I search for {string}")
    public void i_search_for(String string) {
        googlePage.searchButton.setValue(string).pressEnter();
    }
    @Then("verify page source contains {string}")
    public void verify_page_source_contains(String string) {
//        WebDriverRunner.url();//RETURNS URL OF THE PAGE
        String pageSource = WebDriverRunner.source();// RETURNS THE PAGE SOURCE
        Assert.assertTrue(pageSource.contains(string));
    }
    @Then("verify the result should contain {string} keyword")
    public void verify_the_result_should_contain_keyword(String string) {
//       Assert.assertTrue( googlePage.resultSection.toString().contains(string)); //Traditional selenium
        googlePage.resultSection.shouldBe(visible);//checks if this element is visible on the page
        googlePage.resultSection.shouldHave(text(string));//About 702,000,000 results  (0.55 seconds) . contains (About)
        googlePage.resultSection.shouldNotHave(text("MERCEDES TRUCK"));//NEGATIVE TEST CHECKING IF THE ELEMENT TEXT DOES NOT CONTAIN A SPECIFIC WORD
//        googlePage.resultSection.shouldHave(exactText("About 702,000,000 results"));//Checks the exact text match
    }

    @Then("the first result in the page sections should contain {string}")
    public void theFirstResultInThePageSectionsShouldContain(String string) {
        //        List<SelenideElement> allSections = googlePage.getAllSections;
//        allSections.get(0).shouldHave(text(string));
        googlePage.getAllSections.get(0).shouldHave(text(string));//checks if the first section contains Tesla keyword
    }
}
