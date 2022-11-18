package com.zeus.step_definitions;

import com.zeus.pages.AmazonLogin;
import com.zeus.utilities.BrowserUtil;
import com.zeus.utilities.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepdefs {
    AmazonLogin amazonLogin;

    @Given("we are at amazon login page")
    public void we_are_at_amazon_login_page() {
        amazonLogin = new AmazonLogin();

        amazonLogin.goTo();

    }
    @When("we provide valid credentials")
    public void we_provide_valid_credentials() {

        amazonLogin = new AmazonLogin();

        String username = ConfigReader.read("username");
        String password = ConfigReader.read("password");

        amazonLogin.login(username,password);

    }
    @Then("we should see the homepage")
    public void we_should_see_the_homepage() {

        amazonLogin = new AmazonLogin();
        BrowserUtil.waitFor(2);

        amazonLogin.amazonHomepage();


    }

    }
