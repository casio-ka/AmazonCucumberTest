package com.zeus.step_definitions;

import com.zeus.pages.AmazonBasics;
import com.zeus.pages.AmazonLogin;
import com.zeus.utilities.BrowserUtil;
import com.zeus.utilities.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonBasicsStepdefs {
    AmazonLogin amazonLogin;
    AmazonBasics amazonBasics;

    @Given("user is at the amazon homepage")
    public void userIsAtTheAmazonHomepage() {
        amazonLogin = new AmazonLogin();

        amazonLogin.goTo();

        String username = ConfigReader.read("username");
        String password = ConfigReader.read("password");

        amazonLogin.login(username,password);
        BrowserUtil.waitFor(1);


    }
    @When("we select the amazon basics option")
    public void we_select_the_amazon_basics_option() {
        amazonBasics = new AmazonBasics();

        amazonBasics.clickAmazonBasics();
        BrowserUtil.waitFor(2);

    }
    @Then("we should see amazon basics page")
    public void we_should_see_amazon_basics_page() {
        amazonBasics = new AmazonBasics();

        amazonBasics.afterAmazonBasicsClick();
        BrowserUtil.waitFor(2);

    }



}
