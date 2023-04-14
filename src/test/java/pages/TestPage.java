package pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class TestPage {
    //This is my TestCenter page class
    //All objects in TestCenter page will go here


    //LOCATING THE ELEMENT USING FUNCTION
    //1st Way
//    public SelenideElement username(){
//        return $(By.id("exampleInputEmail1"));
//    }

    //WebElement -> Selenide Element

    //OR ALTERNATIVELY
    //2nd Way:

    //Username
    public SelenideElement username = $(By.id("exampleInputEmail1"));
    //using cssSelector:
    public SelenideElement username1 = $("#exampleInputEmail1");

    //Password
    public SelenideElement password = $(By.id("exampleInputPassword1"));

    //Submit button
    public SelenideElement submitButton = $(By.xpath("//button[@type='submit']"));

    //Logout button
    public SelenideElement logOutButton = $(By.partialLinkText("Logout"));//Since there is a space in text I used partial link text.
                                                                          //I do not want that this space breaks my code.

    //Login Message
    public SelenideElement successMessage = $(By.xpath("//*[contains(text(),'You logged into a secure area!')]"));

    //CheckBox Elements
    public SelenideElement checkBox1 = $(By.id("box1"));
    public SelenideElement checkBox2 = $(By.id("box2"));

}
