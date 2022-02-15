package org.apiTestingFramework.cuke.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apiTestingFramework.cuke.apis.OrderApi;
import org.apiTestingFramework.cuke.base.BaseTest;
import org.testng.Assert;

public class PayPalSteps {


    @Before
    public void setUp() {
        BaseTest.init();
    }

    @Given("^I want to get access Token from Paypal api$")
    public void i_want_to_get_access_token_from_paypal_api() {
       OrderApi.getAccessToken();
    }

    @When("^I set currency code as \"([^\"]*)\" and value as \"([^\"]*)\"$")
    public void i_set_currency_code_as_and_value_as(String currencyCode, String currencyValue) {
        BaseTest.response = OrderApi.createOrder(currencyCode, currencyValue);
    }

    @And("^I verify the status of CREATED$")
    public void i_verify_the_status_of_created() {
        Assert.assertEquals(BaseTest.response.jsonPath().getString("status"), "CREATED");
    }
    @When("^I get Order from the paypal api$")
    public void i_get_order_from_the_paypal_api() {
        BaseTest.response = OrderApi.getOrderDetails();
    }
    @And("^I verify the status code as \"([^\"]*)\"$")
    public void i_verify_the_status_code_as(int statusCode) {
        Assert.assertEquals(BaseTest.response.getStatusCode(),statusCode);
    }
}
