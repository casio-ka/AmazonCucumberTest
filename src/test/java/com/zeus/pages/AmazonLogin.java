package com.zeus.pages;

import com.zeus.utilities.ConfigReader;
import com.zeus.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.AssertJUnit.assertEquals;

public class AmazonLogin {

    @FindBy(xpath = "//*[@id=\"ap_email\"]")
    public WebElement usernameInput;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    public WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"ap_password\"]")
    public WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"signInSubmit\"]")
    public WebElement signinSubmit;

    @FindBy(xpath = "//*[@type=\"checkbox\"]")
    public WebElement rememberMe;


    public AmazonLogin() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void goTo(){
        Driver.getDriver().navigate().to(ConfigReader.read("url"));
    }

    public void login(String username, String password){

        this.usernameInput.sendKeys(username);
        this.continueButton.click();
        this.passwordInput.sendKeys(password);
        this.rememberMe.click();
        this.signinSubmit.click();
    }

    public void amazonHomepage(){

        assertEquals(Driver.getDriver().getTitle(),"Amazon.com. Spend less. Smile more.");

    }
}
