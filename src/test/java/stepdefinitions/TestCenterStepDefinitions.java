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
            testPage.checkBox1.shouldNotBe(checked);//not mandatory -> first verify it is not selected
            testPage.checkBox1.click(); // select
            //Assert.assertTrue(testPage.checkBox1.isSelected());//Selenium assertion
            //testPage.checkBox1.shouldBe(Condition.checked);//selenide long version
            testPage.checkBox1.shouldBe(checked);//selenide short version -> verify it is selected now
        }
        if(string.equals("Checkbox 2")&&!testPage.checkBox2.isSelected()){
            testPage.checkBox2.shouldNotBe(checked);
            testPage.checkBox2.click();
            testPage.checkBox2.shouldBe(checked);
        }
        if (string.equals("Red")&&!testPage.red.isSelected()) {
            testPage.red.shouldNotBe(Condition.checked);
            testPage.red.click();
            testPage.red.shouldBe(Condition.checked);

        }
        if (string.equals("Yellow")&&!testPage.yellow.isSelected()) {
            testPage.yellow.shouldNotBe(checked);
            testPage.yellow.click();
            testPage.yellow.shouldBe(checked);

        }
        if (string.equals("Football")&&!testPage.football.isSelected()) {
            testPage.football.shouldNotBe(checked);
            testPage.football.click();
            testPage.football.shouldBe(checked);
        }
    }


}
