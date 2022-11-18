package com.zeus.step_definitions;

import com.zeus.pages.AmazonLogin;
import com.zeus.pages.AmazonSearchBox;
import com.zeus.utilities.BrowserUtil;
import com.zeus.utilities.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchBoxStepdefs {
    AmazonLogin amazonLogin;
    AmazonSearchBox amazonSearchBox;

    @Given("we are at the amazon homepage")
    public void we_are_at_the_amazon_homepage() {
        amazonLogin = new AmazonLogin();

        amazonLogin.goTo();

        String username = ConfigReader.read("username");
        String password = ConfigReader.read("password");

        amazonLogin.login(username,password);
        BrowserUtil.waitFor(1);
    }

    @When("we search for an item")
    public void we_search_for_an_item() {
        amazonSearchBox = new AmazonSearchBox();

        amazonSearchBox.search();
        BrowserUtil.waitFor(1);

    }
    @Then("we should see the search page with matching results")
    public void we_should_see_the_search_page_with_matching_results() {

        amazonSearchBox = new AmazonSearchBox();
        amazonSearchBox.resultsDisplay();
        BrowserUtil.waitFor(2);
    }

    }

