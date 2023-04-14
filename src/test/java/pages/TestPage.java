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
    public SelenideElement username = $(By.id("exampleInputEmail1"));
    //using cssSelector:
    public SelenideElement username1 = $("#exampleInputEmail1");
    public SelenideElement password = $(By.id("exampleInputPassword1"));
    public SelenideElement submitButton = $(By.xpath("//button[@type='submit']"));
    public SelenideElement logOutButton = $(By.partialLinkText("Logout"));//Since there is a space in text I used partial link text.
                                                                          //I do not want that this space breaks my code.

}
