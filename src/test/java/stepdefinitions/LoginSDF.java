package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import poms.LoginPOM;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSDF {
	
	LoginPOM loginPOM;
	
	public LoginSDF () {
		this.loginPOM = new LoginPOM (DriverSingleton.getInstance ());
	}
	
	@Given ("Login: A user is on the login page")
	public void a_user_is_on_the_login_page () {
		DriverSingleton.getInstance ().get ("http://localhost:4200/login");
		
		assertEquals ("http://localhost:4200/login", this.loginPOM.getCurrentUrl ());
	}
	
	@When ("Login: A user enters correct login credentials")
	public void a_user_enters_correct_login_credentials () {
		this.loginPOM.usernameInput ("johnsmith");
		this.loginPOM.passwordInput ("password");
		this.loginPOM.clickLogin ();
	}
	
	@Then ("Login: The user is redirected to their main feed")
	public void the_user_is_redirected_to_their_main_feed () {
		this.loginPOM.waitForSuccessfulLogin ();
		assertEquals ("http://localhost:4200/", this.loginPOM.getCurrentUrl ());
	}
	
	@When ("Login: A user enters incorrect login credentials")
	public void a_user_enters_incorrect_login_credentials () {
		this.loginPOM.usernameInput ("steel");
		this.loginPOM.passwordInput ("steal");
		this.loginPOM.clickLogin ();
	}
	
	@Then ("Login: An invalid credentials message shows on login form")
	public void an_invalid_credentials_message_shows_on_login_form () {
		assertEquals ("Error! Invalid credentials", this.loginPOM.getErrorMessage ());
	}
	
	@When ("Login: A user clicks on the create account button")
	public void a_user_clicks_on_the_create_account_button () {
		this.loginPOM.clickRegisterBtn ();
	}
	
	@Then ("Login: The user is redirected to the register page")
	public void the_user_is_redirected_to_the_register_page () {
		assertEquals ("http://localhost:4200/register", this.loginPOM.getCurrentUrl ());
	}
	
	@When ("Login: A user clicks on the forgot password button")
	public void a_user_clicks_on_the_forgot_password_button () {
		this.loginPOM.clickForgotPasswordBtn ();
	}
	
	@Then ("Login: The user is redirected to the reset password page")
	public void the_user_is_redirected_to_the_reset_password_page () {
		assertEquals ("http://localhost:4200/reset-password", this.loginPOM.getCurrentUrl ());
	}
	
}
