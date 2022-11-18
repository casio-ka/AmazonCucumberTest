package com.zeus.step_definitions;

import com.zeus.pages.AmazonBasics;
import com.zeus.pages.AmazonLogin;
import com.zeus.pages.AmazonSearchBox;
import com.zeus.utilities.BrowserUtil;
import com.zeus.utilities.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ItemFilterStepdefs {
    AmazonLogin amazonLogin;
    AmazonSearchBox amazonSearchBox;

    @Given("a user is at the amazon homepage")
    public void a_user_is_at_the_amazon_homepage() {
        amazonLogin = new AmazonLogin();

        amazonLogin.goTo();

        String username = ConfigReader.read("username");
        String password = ConfigReader.read("password");

        amazonLogin.login(username,password);
        BrowserUtil.waitFor(1);

    }

    @When("we have searched for an item")
    public void we_have_searched_for_an_item() {
        amazonSearchBox = new AmazonSearchBox();

        amazonSearchBox.search();
        BrowserUtil.waitFor(2);

    }

    @And("we are on the results page")
    public void we_are_on_the_results_page() {
        amazonSearchBox = new AmazonSearchBox();
        amazonSearchBox.resultsDisplay();
        BrowserUtil.waitFor(2);

    }

    @Then("we should be able to filter our search items")
    public void we_should_be_able_to_filter_our_search_items() {
        amazonSearchBox = new AmazonSearchBox();

        amazonSearchBox.sizeClick();
        BrowserUtil.waitFor(3);

        amazonSearchBox.amazonBasicsClick();
        BrowserUtil.waitFor(3);

        amazonSearchBox.checkBoxAfterClick();
        BrowserUtil.waitFor(3);

        amazonSearchBox.sizeCheckBox();

        amazonSearchBox.selectItem();
        BrowserUtil.waitFor(1);
    }
}
