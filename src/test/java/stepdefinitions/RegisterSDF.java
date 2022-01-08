package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import poms.RegisterPOM;

public class RegisterSDF {
	final RegisterPOM registerPOM;
	
	public RegisterSDF () {
		this.registerPOM = new RegisterPOM (DriverSingleton.getInstance ());
	}
	
	@Given ("Register: A user is on the register page")
	public void register_a_user_is_on_the_register_page () {
		
	}
	
	@When ("Register: The user enters valid user information")
	public void register_the_user_enters_valid_user_information () {
		
	}
	
	@Then ("Register: The user will be redirected to the login page")
	public void register_the_user_will_be_redirected_to_the_login_page () {
		
	}
	
	@When ("Register: The user enters an invalid first name")
	public void register_the_user_enters_an_invalid_first_name () {
		
	}
	
	@Then ("Register: An error is shown saying the first name is invalid")
	public void register_an_error_is_shown_saying_the_first_name_is_invalid () {
		
	}
	
	@When ("Register: The user enters an invalid last name")
	public void register_the_user_enters_an_invalid_last_name () {
		
	}
	
	@Then ("Register: An error is shown saying the last name is invalid")
	public void register_an_error_is_shown_saying_the_last_name_is_invalid () {
		
	}
	
	@When ("Register: The user enters an invalid email")
	public void register_the_user_enters_an_invalid_email () {
		
	}
	
	@Then ("Register: An error is shown saying the email is invalid")
	public void register_an_error_is_shown_saying_the_email_is_invalid () {
		
	}
	
	@When ("Register: The user enters an invalid username")
	public void register_the_user_enters_an_invalid_username () {
		
	}
	
	@Then ("Register: An error is shown saying the username is invalid")
	public void register_an_error_is_shown_saying_the_username_is_invalid () {
		
	}
	
	@When ("Register: The user enters an invalid password")
	public void register_the_user_enters_an_invalid_password () {
		
	}
	
	@Then ("Register: An error is shown saying the password is invalid")
	public void register_an_error_is_shown_saying_the_password_is_invalid () {
		
	}
	
	@When ("Register: The user enters an invalid password confirmation")
	public void register_the_user_enters_an_invalid_password_confirmation () {
		
	}
	
	@Then ("Register: An error is shown saying the password confirmation is invalid")
	public void register_an_error_is_shown_saying_the_password_confirmation_is_invalid () {
		
	}
	
	@When ("Register: The user clicks the login to an existing account button")
	public void register_the_user_clicks_the_login_to_an_existing_account_button () {
		
	}
	
	@Then ("Register: The user is redirected to the login page")
	public void register_the_user_is_redirected_to_the_login_page () {
		
	}
}
