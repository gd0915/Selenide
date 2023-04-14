package stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.TestPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class TestCenterStepDefinitions {

    TestPage testPage = new TestPage();
    @Given("I enter username")
    public void i_enter_username() {
        testPage.username.setValue("techproed");//In Selenide we use setValue() instead of sendKeys() in Selenium
    }
    @Given("I enter password")
    public void i_enter_password() {
        testPage.password.setValue("SuperSecretPassword");
    }
    @Given("I enter submit button")
    public void i_enter_submit_button() {
        testPage.submitButton.click();
    }

    @And("click on logout link")
    public void clickOnLogoutLink() {
        testPage.logOutButton.click();
    }

    //SELENIDE ASSERTION => IF IT FAILS, IT WILL TAKE THE SCREENSHOT AUTOMATICALLY.!!
    @Then("verify login is successful")
    public void verifyLoginIsSuccessful() {
        //Assert.assertTrue(testPage.successMessage.isDisplayed()); //comes from JUnit Selenium
        //testPage.successMessage.shouldBe(Condition.visible); //comes from Selenide -> no need to put Condition since we used Condition import
        testPage.successMessage.shouldBe(visible); //comes from Selenide - SELENIDE ASSERTION
    }

    @And("I click on {string} if not already selected")
    public void iClickOnIfNotAlreadySelected(String string) {
        if(string.equals("Checkbox 1")&&!testPage.checkBox1.isSelected()){
            testPage.checkBox1.click();
            //Assert.assertTrue(testPage.checkBox1.isSelected());//Selenium assertion
            //testPage.checkBox1.shouldBe(Condition.checked);//selenide long version
            testPage.checkBox1.shouldBe(Condition.checked);//selenide short version
        }
        if(string.equals("Checkbox 2")&&!testPage.checkBox2.isSelected()){
            testPage.checkBox2.shouldNotBe(checked);
            testPage.checkBox2.click();
            testPage.checkBox2.shouldBe(checked);
        }
    }


}
