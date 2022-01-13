package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import poms.LoginPOM;
import poms.ProfilePOM;

import java.net.URISyntaxException;

import static org.junit.Assert.*;

public class ProfileSDF {
	final ProfilePOM profilePOM;
	final LoginPOM loginPOM;

	public ProfileSDF () {
		this.profilePOM = new ProfilePOM (DriverSingleton.getInstance ());
		this.loginPOM = new LoginPOM (DriverSingleton.getInstance ());
	}

	@When("Profile: The user clicks their profile")
	public void profile_the_user_clicks_their_profile() {
		profilePOM.clickProfileElement();
	}
	@Then("Profile: The user is taken to their profile page")
	public void profile_the_user_is_taken_to_their_profile_page() {
		assertTrue(profilePOM.waitForProfilePageToAppear());
	}
	@When("Profile: User clicks Edit Profile")
	public void profile_user_clicks_edit_profile() {
		profilePOM.getProfileFieldsBeforeEditProfileClicked();
		profilePOM.clickEditProfile();
	}
	@Then("Profile: Edit profile input text boxes are shown with placeholders pre-populated with correct info")
	public void profile_edit_profile_input_text_boxes_are_shown_with_placeholders_pre_populated_with_correct_info() {
		profilePOM.waitForProfileEditElems();
		assertTrue(profilePOM.validateProfileEditControlPlaceholders());
	}

	@Given("Profile: User is already in edit profile mode")
	public void profile_user_is_already_in_edit_profile_mode() {
		assertEquals(this.profilePOM.getProfileUrl(), this.profilePOM.getCurrentUrl());
		profilePOM.getProfileFieldsBeforeEditProfileClicked();
		profilePOM.clickEditProfile();
	}
	@When("Profile: User clicks check button")
	public void profile_user_clicks_check_button() {
		profilePOM.clickProfileEditSubmitButton();
	}
	@Then("Profile: User name was not changed no change in header or profile page")
	public void profile_user_name_was_not_changed_no_change_in_header_or_profile_page() {
		//this.profilePOM.waitForEditProfileFieldsToBeHidden();
		this.profilePOM.waitForProfileInfoContainerToAppear();
		assertTrue(this.profilePOM.validateEditProfileDidNotChangeProfileUser());
	}
	@When("Profile: User clicks X button")
	public void profile_user_clicks_x_button() {
		this.profilePOM.clickProfileEditXButton();
	}

	@When("Profile: User changes firstName and lastName field")
	public void profile_user_changes_first_name_and_last_name_field() {
		this.profilePOM.setProfileEditFirstname("Jonathan");
		this.profilePOM.setProfileEditLastname("Smythe");
	}
	@Then("Profile: firstName and lastName field are changed")
	public void profile_first_name_and_last_name_field_are_changed() {
		assertEquals("Jonathan", this.profilePOM.getProfileEditFirstname());
		assertEquals("Smythe", this.profilePOM.getProfileEditLastname());
	}

	@Then("Profile: Edit fields are hidden and User name is reflected in header and profile page")
	public void profile_edit_fields_are_hidden_and_user_name_is_reflected_in_header_and_profile_page() {
		this.profilePOM.waitForEditProfileFieldsToBeHidden();
		String[] firstAndLastName = this.profilePOM.getFirstNameLastNameFromHeader();
		assertEquals("Jonathan Smythe", firstAndLastName[0]+" "+firstAndLastName[1].trim());
	}

	@When("Profile: User logs off")
	public void profile_user_logs_off() {
		this.profilePOM.clickLogoutButton();
	}

	@When("Profile: User changes password field")
	public void profile_user_changes_password_field() {
		this.profilePOM.setProfileEditPassword("pass123");
	}
	@Then("Profile: password field is filled in and not blank")
	public void profile_password_field_is_filled_in_and_not_blank() {
		assertEquals("pass123", this.profilePOM.getProfileEditPassword());
	}
	@Then("Profile: Profile edit fields are hidden")
	public void profile_profile_edit_fields_are_hidden() {
		this.profilePOM.waitForEditProfileFieldsToBeHidden();
	}
	@When("Profile: A user enters correct login credentials")
	public void profile_a_user_enters_correct_login_credentials() {
		this.loginPOM.usernameInput ("johnsmith");
		this.loginPOM.passwordInput ("pass123");
		this.loginPOM.clickLogin ();
		this.loginPOM.waitForSuccessfulLogin ();
	}
	@When("Profile: User changes password field back to original")
	public void profile_user_changes_password_field_back_to_original() {
		this.profilePOM.setProfileEditPassword("password");
	}
	@Then("Profile: password field is filled in and not blank has original value")
	public void profile_password_field_is_filled_in_and_not_blank_has_original_value() {
		assertEquals("password", this.profilePOM.getProfileEditPassword());
	}

	@When("Profile: User changes username field")
	public void profile_user_changes_username_field() {
		this.profilePOM.setProfileEditUsername("jsmythe");
	}
	@Then("Profile: username field is filled in and not blank")
	public void profile_username_field_is_filled_in_and_not_blank() {
		assertEquals("jsmythe", this.profilePOM.getProfileEditUsername());
	}
	@When("Profile: A user enters correct login credentials for new username")
	public void profile_a_user_enters_correct_login_credentials_for_new_username() {
		this.loginPOM.usernameInput ("jsmythe");
		this.loginPOM.passwordInput ("password");
		this.loginPOM.clickLogin ();
		this.loginPOM.waitForSuccessfulLogin ();
	}

	@When("Profile: User changes username field back to original")
	public void profile_user_changes_username_field_back_to_original() {
		this.profilePOM.setProfileEditUsername("johnsmith");
	}
	@Then("Profile: username field is filled in and not blank has original value")
	public void profile_username_field_is_filled_in_and_not_blank_has_original_value() {
		// Write code here that turns the phrase above into concrete actions
		assertEquals("johnsmith", this.profilePOM.getProfileEditUsername());
	}

	@When("Profile: User changes email field")
	public void profile_user_changes_email_field() {
		this.profilePOM.setProfileEditEmail("johnsmith@gmail.com");
	}
	@Then("Profile: email field is filled in and not blank")
	public void profile_email_field_is_filled_in_and_not_blank() {
		assertEquals("johnsmith@gmail.com", this.profilePOM.getProfileEditEmail());
	}
	@When("Profile: A user enters correct login credentials for new email")
	public void profile_a_user_enters_correct_login_credentials_for_new_email() {
		this.loginPOM.usernameInput ("johnsmith@gmail.com");
		this.loginPOM.passwordInput ("password");
		this.loginPOM.clickLogin ();
		this.loginPOM.waitForSuccessfulLogin ();
	}
	@When("Profile: User changes email field back to original")
	public void profile_user_changes_email_field_back_to_original() {
		this.profilePOM.setProfileEditEmail("johnsmith@example.com");
	}
	@Then("Profile: email field is filled in and not blank has original value")
	public void profile_email_field_is_filled_in_and_not_blank_has_original_value() {
		assertEquals("johnsmith@example.com", this.profilePOM.getProfileEditEmail());
	}
	@When("Profile: The user adds an image to their profile")
	public void profile_the_user_adds_an_image_to_their_profile() throws URISyntaxException {
		this.profilePOM.addImageToProfile();
	}
	@Then("Profile: The profile image is displayed")
	public void profile_the_profile_image_is_displayed() {
		assertTrue(this.profilePOM.validateTempProfileImageWasSet());
	}
	@Then("Profile: Profile edit fields are hidden and new image is displayed")
	public void profile_profile_edit_fields_are_hidden_and_new_image_is_displayed() {
		this.profilePOM.waitForEditProfileFieldsToBeHidden();
		assertTrue(this.profilePOM.validateProfileImageWasSet());
	}

	@When("Profile: User creates post from their profile page")
	public void profile_user_creates_post_from_their_profile_page() {
		this.profilePOM.setPostBody ("First user's post 12345");
		this.profilePOM.submitPost ();
		this.profilePOM.waitForPost("First user's post 12345");
	}
	@Then("Profile: User own post is shown")
	public void profile_user_own_post_is_shown() {
		assertTrue(this.profilePOM.foundPost("First user's post 12345"));
	}
	@When("Profile: User logs out")
	public void profile_user_logs_out() {
		this.profilePOM.clickLogoutButton();
	}
	@Then("Profile: Login page is now shown")
	public void profile_login_page_is_now_shown() {
		this.profilePOM.waitForLoginPage();
		Assertions.assertEquals ("http://localhost:4200/login", this.profilePOM.getCurrentUrl ());
	}
	@When("Profile: Second user logs in and clicks their info in header")
	public void profile_second_user_logs_in_and_clicks_their_info_in_header() {
		this.loginPOM.usernameInput ("seconduser");
		this.loginPOM.passwordInput ("password");
		this.loginPOM.clickLogin ();
		this.loginPOM.waitForSuccessfulLogin ();
		profilePOM.clickProfileElement();
	}
	@Then("Profile: Second user is now in profile page and can only see their own posts not from anyone else")
	public void profile_second_user_is_now_in_profile_page_and_can_only_see_their_own_posts_not_from_anyone_else() {
		assertTrue(profilePOM.waitForProfilePageToAppear());
		//assertTrue(profilePOM.waitForProfilePageToAppear2("seconduser"));
		assertFalse(this.profilePOM.foundPost("First user's post 12345"));
	}
	@When("Profile: Second user creates post")
	public void profile_second_user_creates_post() {
		this.profilePOM.setPostBody ("Second user's post 54321");
		this.profilePOM.submitPost ();
		this.profilePOM.waitForPost("Second user's post 54321");
		profilePOM.clickProfileElement();
		assertTrue(profilePOM.waitForProfilePageToAppear());
	}
	@Then("Profile: Second user only sees their own post")
	public void profile_second_user_only_sees_their_own_post() throws InterruptedException {
		this.profilePOM.waitForPosts();
		assertTrue(this.profilePOM.foundPost("Second user's post 54321"));
		assertFalse(this.profilePOM.foundPost("First user's post 12345"));
	}
	@When("Profile: Second user logs out")
	public void profile_second_user_logs_out() {
		this.profilePOM.clickLogoutButton();
	}

	@When("First User is on their own page")
	public void first_user_is_on_their_own_page() {
		assertTrue(profilePOM.waitForProfilePageToAppear());
	}
	@Then("No other users posts are shown")
	public void no_other_users_posts_are_shown() {
		this.profilePOM.waitForPosts();
		assertFalse(this.profilePOM.foundPost("Second user's post 54321"));
		assertTrue(this.profilePOM.foundPost("First user's post 12345"));
	}
	@When("First user now goes to second users profile")
	public void first_user_now_goes_to_second_users_profile() {
		this.profilePOM.gotoProfilePage("seconduser");
	}
	@Then("Only second users posts are shown")
	public void only_second_users_posts_are_shown() {
		this.profilePOM.waitForPosts();
		assertTrue(this.profilePOM.foundPost("Second user's post 54321"));
		assertFalse(this.profilePOM.foundPost("First user's post 12345"));
	}
}
