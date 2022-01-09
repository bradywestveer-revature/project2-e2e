package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import poms.ChangePasswordPOM;

import static org.junit.jupiter.api.Assertions.*;

public class ChangePasswordSDF {
	final ChangePasswordPOM changePasswordPOM;
	
	public ChangePasswordSDF () {
		this.changePasswordPOM = new ChangePasswordPOM (DriverSingleton.getInstance ());
	}
	
	@Given ("ChangePassword: The user is on the change password page")
	public void change_password_the_user_is_on_the_change_password_page () {
		
	}

	//todo make a mock token for testing?
	@Given ("ChangePassword: The user has a valid token")
	public void change_password_the_user_has_a_valid_token () {
		
	}
	
	@When ("ChangePassword: The user enters valid passwords")
	public void change_password_the_user_enters_valid_passwords () {
		
	}
	
	@Then ("ChangePassword: The user is redirected to the login page")
	public void change_password_the_user_is_redirected_to_the_login_page () {
		
	}
	
	@Given ("ChangePassword: The user has an invalid token")
	public void change_password_the_user_has_an_invalid_token () {
		
	}
	
	@Then ("ChangePassword: An invalid token error message is shown")
	public void change_password_an_invalid_token_error_message_is_shown () {
		
	}
	
	@When ("ChangePassword: The user enters an invalid password")
	public void change_password_the_user_enters_an_invalid_password () {
		
	}
	
	@Then ("ChangePassword: An invalid password error message is shown")
	public void change_password_an_invalid_password_error_message_is_shown () {
		
	}
	
	@When ("ChangePassword: The user enters non-matching passwords")
	public void change_password_the_user_enters_non_matching_passwords () {
		
	}
	
	@Then ("ChangePassword: A non-matching password error message is shown")
	public void change_password_a_non_matching_password_error_message_is_shown () {
		
	}
	
	@When ("ChangePassword: The user clicks the try password reset button")
	public void change_password_the_user_clicks_the_try_password_reset_button () {
		
	}
	
	@Then ("ChangePassword: The user is redirected to the reset password page")
	public void change_password_the_user_is_redirected_to_the_reset_password_page () {
		
	}
}
