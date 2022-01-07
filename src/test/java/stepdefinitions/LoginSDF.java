package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import poms.LoginPOM;

public class LoginSDF {

    LoginPOM loginPOM;

    @After
    public void tearDown(){
        DriverSingleton.quitInstance();
    }

    @Given("A user is on the login page")
    public void a_user_is_on_the_login_page() {
        DriverSingleton.getInstance().get("http://localhost:4200");
        this.loginPOM = new LoginPOM(DriverSingleton.getInstance());
        Assertions.assertEquals("http://localhost:4200/login", this.loginPOM.getCurrentUrl());
    }
    @When("A user enters correct login credentials")
    public void a_user_enters_correct_login_credentials() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The user is redirected to their main feed")
    public void the_user_is_redirected_to_their_main_feed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("A user enters incorrect login credentials")
    public void a_user_enters_incorrect_login_credentials() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("An invalid credentials message shows on login form")
    public void an_invalid_credentials_message_shows_on_login_form() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("A user clicks on the create account button")
    public void a_user_clicks_on_the_create_account_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The user is redirected to the register page")
    public void the_user_is_redirected_to_the_register_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("A user clicks on the forgot password button")
    public void a_user_clicks_on_the_forgot_password_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The user is redirected to the reset password page")
    public void the_user_is_redirected_to_the_reset_password_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
