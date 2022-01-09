package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import poms.ResetPasswordPOM;

import static org.junit.jupiter.api.Assertions.*;

public class ResetPasswordSDF {
	final ResetPasswordPOM resetPasswordPOM;
	
	public ResetPasswordSDF () {
		this.resetPasswordPOM = new ResetPasswordPOM (DriverSingleton.getInstance ());
	}

	@Given("Reset Password: A user is on the reset password page")
	public void reset_password_a_user_is_on_the_reset_password_page () {
		DriverSingleton.getInstance().get("http://localhost:4200/reset-password");
		assertEquals("http://localhost:4200/reset-password", this.resetPasswordPOM.getCurrentUrl());
	}

	@When("Reset Password: A user enters a valid email address")
	public void reset_password_a_user_enters_a_valid_email_address () {
		this.resetPasswordPOM.emailInput("player1foreverr@gmail.com");
		this.resetPasswordPOM.clickResetPasswordBtn();
	}

	@Then("Reset Password: A success message is displayed")
	public void reset_password_a_success_message_is_displayed () {
		assertEquals("Successfully sent password reset e-mail to player1foreverr@gmail.com.", this.resetPasswordPOM.getSuccessMessage());
	}

	@When ("Reset Password: A user enters an invalid email address")
	public void reset_password_a_user_enters_an_invalid_email_address () {
		this.resetPasswordPOM.emailInput("stinkypoopoo");
		this.resetPasswordPOM.clickResetPasswordBtn();
	}

	@Then ("Reset Password: An error message is displayed")
	public void reset_password_an_error_message_is_displayed () {
		assertEquals("Invalid e-mail address.", this.resetPasswordPOM.getErrorMessage());
	}

	@When ("Reset Password: The user is clicks the retry login button")
	public void reset_password_the_user_is_clicks_the_retry_login_button () {
		this.resetPasswordPOM.clickLoginPageBtn();
	}

	@Then ("Reset Password: The user is redirected to the login page")
	public void reset_password_the_user_is_redirected_to_the_login_page () {
		assertEquals("http://localhost:4200/login", this.resetPasswordPOM.getCurrentUrl());
	}
}
