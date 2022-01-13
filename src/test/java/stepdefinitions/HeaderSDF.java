package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import poms.HeaderPOM;

import static org.junit.jupiter.api.Assertions.*;

public class HeaderSDF {

    HeaderPOM headerPOM;

    public HeaderSDF(){
        this.headerPOM = new HeaderPOM(DriverSingleton.getInstance());
    }

    @Then("Header: The user component and logout button are not displayed")
    public void header_the_user_component_and_logout_button_are_not_displayed() {
        assertFalse(this.headerPOM.userCompAndLogoutBtnVisible());
    }

    @Then("Header: The User Component and Logout Button are visible")
    public void header_the_user_component_and_logout_button_are_visible() {
        assertTrue(this.headerPOM.userCompAndLogoutBtnVisible());
    }

    @When("Header: A user clicks the logout button")
    public void header_a_user_clicks_the_logout_button() {
        this.headerPOM.clickLogoutBtn();
    }
    @Then("Header: The user is redirected to the login page")
    public void header_the_user_is_redirected_to_the_login_page() {
        assertEquals("http://localhost:4200/login", this.headerPOM.getCurrentUrl());
    }
}
