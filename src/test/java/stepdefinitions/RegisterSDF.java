package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.*;

import poms.RegisterPOM;

public class RegisterSDF {
	RegisterPOM registerPOM;
	
	public RegisterSDF () {
		this.registerPOM = new RegisterPOM (DriverSingleton.getInstance ());
	}
	
	@Given ("Register: A user is on the register page")
	public void register_a_user_is_on_the_register_page () {
        DriverSingleton.getInstance().get("http://localhost:4200/register");
        assertEquals("http://localhost:4200/register", this.registerPOM.getCurrentUrl());
	}
	
	@When ("Register: The user enters an invalid first name")
	public void register_the_user_enters_an_invalid_first_name () {
        this.registerPOM.firstNameInput("");
        this.registerPOM.clickRegisterBtn();
	}
	
	@Then ("Register: An error is shown saying the first name is invalid")
	public void register_an_error_is_shown_saying_the_first_name_is_invalid () {
        assertEquals("First name can not be blank.", this.registerPOM.getErrorMessage());
	}
	
	@When ("Register: The user enters an invalid last name")
	public void register_the_user_enters_an_invalid_last_name () {
        this.registerPOM.firstNameInput("Selenium");
        this.registerPOM.lastNameInput("");
        this.registerPOM.clickRegisterBtn();
	}
	
	@Then ("Register: An error is shown saying the last name is invalid")
	public void register_an_error_is_shown_saying_the_last_name_is_invalid () {
        assertEquals("Last name can not be blank.", this.registerPOM.getErrorMessage());
	}
	
	@When ("Register: The user enters an invalid email")
	public void register_the_user_enters_an_invalid_email () {
        this.registerPOM.firstNameInput("Selenium");
        this.registerPOM.lastNameInput("Test");
        this.registerPOM.emailInput("yes");
        this.registerPOM.clickRegisterBtn();
	}
	
	@Then ("Register: An error is shown saying the email is invalid")
	public void register_an_error_is_shown_saying_the_email_is_invalid () {
        assertEquals("Invalid e-mail address.", this.registerPOM.getErrorMessage());
	}
	
	@When ("Register: The user enters an invalid username")
	public void register_the_user_enters_an_invalid_username () {
        this.registerPOM.firstNameInput("Selenium");
        this.registerPOM.lastNameInput("Test");
        this.registerPOM.emailInput("test@mail.com");
        this.registerPOM.usernameInput("");
        this.registerPOM.clickRegisterBtn();
	}
	
	@Then ("Register: An error is shown saying the username is invalid")
	public void register_an_error_is_shown_saying_the_username_is_invalid () {
        assertEquals("Invalid username.", this.registerPOM.getErrorMessage());
	}
	
	@When ("Register: The user enters an invalid password")
	public void register_the_user_enters_an_invalid_password () {
        this.registerPOM.firstNameInput("Selenium");
        this.registerPOM.lastNameInput("Test");
        this.registerPOM.emailInput("test@mail.com");
        this.registerPOM.usernameInput("SeleniumTest");
        this.registerPOM.passwordInput("");
        this.registerPOM.clickRegisterBtn();
	}
	
	@Then ("Register: An error is shown saying the password is invalid")
	public void register_an_error_is_shown_saying_the_password_is_invalid () {
        assertEquals("Invalid password.", this.registerPOM.getErrorMessage());
	}
	
	@When ("Register: The user enters an invalid password confirmation")
	public void register_the_user_enters_an_invalid_password_confirmation () {
        this.registerPOM.firstNameInput("Selenium");
        this.registerPOM.lastNameInput("Test");
        this.registerPOM.emailInput("test@mail.com");
        this.registerPOM.usernameInput("SeleniumTest");
        this.registerPOM.passwordInput("test");
        this.registerPOM.confirmPasswordInput("");
        this.registerPOM.clickRegisterBtn();
	}
	
	@Then ("Register: An error is shown saying the password confirmation is invalid")
	public void register_an_error_is_shown_saying_the_password_confirmation_is_invalid () {
        assertEquals("Passwords do not match.", this.registerPOM.getErrorMessage());
	}

	@When ("Register: The user enters valid user information")
	public void register_the_user_enters_valid_user_information () {
		this.registerPOM.firstNameInput("Selenium");
		this.registerPOM.lastNameInput("Test");
		this.registerPOM.emailInput("test@mail.com");
		this.registerPOM.usernameInput("SeleniumTest");
		this.registerPOM.passwordInput("test");
		this.registerPOM.confirmPasswordInput("test");
		this.registerPOM.clickRegisterBtn();
	}

	@Then ("Register: The user will be redirected to the login page")
	public void register_the_user_will_be_redirected_to_the_login_page () {
		this.registerPOM.waitForSuccessfulRegister();
		assertEquals("http://localhost:4200/login", this.registerPOM.getCurrentUrl());
	}
	
	@When ("Register: The user clicks the login to an existing account button")
	public void register_the_user_clicks_the_login_to_an_existing_account_button () {
        this.registerPOM.clickLoginPageBtn();
	}
	
	@Then ("Register: The user is redirected to the login page")
	public void register_the_user_is_redirected_to_the_login_page () {
		assertEquals("http://localhost:4200/login", this.registerPOM.getCurrentUrl());
	}
}
