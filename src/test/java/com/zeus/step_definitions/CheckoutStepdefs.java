package com.zeus.step_definitions;

import com.zeus.pages.AmazonLogin;
import com.zeus.pages.AmazonSearchBox;
import com.zeus.utilities.BrowserUtil;
import com.zeus.utilities.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutStepdefs {
    AmazonLogin amazonLogin;
    AmazonSearchBox amazonSearchBox;

    @Given("a user is on the amazon homepage")
    public void a_user_is_on_the_amazon_homepage() {
        amazonLogin = new AmazonLogin();

        amazonLogin.goTo();

        String username = ConfigReader.read("username");
        String password = ConfigReader.read("password");

        amazonLogin.login(username,password);
        BrowserUtil.waitFor(1);

    }
    @When("we searched for an item")
    public void we_searched_for_an_item() {
        amazonSearchBox = new AmazonSearchBox();

        amazonSearchBox.search();
        BrowserUtil.waitFor(2);


    }
    @And("we are redirected to the results page")
    public void we_are_redirected_to_the_results_page() {
        amazonSearchBox = new AmazonSearchBox();
        amazonSearchBox.resultsDisplay();
        BrowserUtil.waitFor(2);


    }
    @And("we have filtered the item")
    public void we_have_filtered_the_item() {
        amazonSearchBox = new AmazonSearchBox();

        amazonSearchBox.amazonBasicsClick();
        BrowserUtil.waitFor(3);

        amazonSearchBox.sizeClick();
        BrowserUtil.waitFor(3);

        amazonSearchBox.checkBoxAfterClick();
        BrowserUtil.waitFor(3);

        amazonSearchBox.sizeCheckBox();

        amazonSearchBox.selectItem();
        BrowserUtil.waitFor(2);


    }
    @Then("we should be able to checkout our preferred item")
    public void we_should_be_able_to_checkout_our_preferred_item() {
        amazonSearchBox = new AmazonSearchBox();

        amazonSearchBox.addItemToCart();
        BrowserUtil.waitFor(2);

        amazonSearchBox.clickRejectProtection();
        BrowserUtil.waitFor(2);

        amazonSearchBox.checkAddedToCart();

        amazonSearchBox.checkout();

        amazonSearchBox.checkOneItem();


    }
}
