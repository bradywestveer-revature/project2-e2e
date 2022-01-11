package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import poms.ProfilePOM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProfileSDF {
	final ProfilePOM profilePOM;

	public ProfileSDF () {
		this.profilePOM = new ProfilePOM (DriverSingleton.getInstance ());
	}

	//Scenario: User navigates to their profile page after logging in
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

	//Scenario: Profile: User edits and does NOT make field changes clicks CHECK, profile of user should not change either
	@Given("Profile: User is already in edit profile mode")
	public void profile_user_is_already_in_edit_profile_mode() {
		assertEquals(this.profilePOM.getProfileUrl(), this.profilePOM.getCurrentUrl());
	}
	@When("Profile: User clicks check button")
	public void profile_user_clicks_check_button() {
		profilePOM.clickEditProfile();
		profilePOM.clickProfileEditSubmitButton();
	}
	@Then("Profile: User name was not changed no change in header or profile page")
	public void profile_user_name_was_not_changed_no_change_in_header_or_profile_page() {
		this.profilePOM.waitForEditProfileFieldsToBeHidden();
		assertTrue(this.profilePOM.validateEditProfileDidNotChangeProfileUser());
	}
	/*@When("Profile: User clicks Edit Profile")
	public void profile_user_clicks_edit_profile() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}*/
	/*@Then("Profile: Edit profile input text boxes are shown with placeholders pre-populated with correct info")
	public void profile_edit_profile_input_text_boxes_are_shown_with_placeholders_pre_populated_with_correct_info() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}*/
	@When("Profile: User clicks X button")
	public void profile_user_clicks_x_button() {
		this.profilePOM.clickProfileEditXButton();
	}

	// Scenario: Profile: User edits and saves various fields
	@When("Profile: User changes firstName and lastName field")
	public void profile_user_changes_first_name_and_last_name_field() {
		this.profilePOM.setProfileEditFirstname("Jonathan");
		this.profilePOM.setProfileEditLastname("Smythe");
	}
	@Then("Profile: firstName and lastName field are changed")
	public void profile_first_name_and_last_name_field_are_changed() {
		assertEquals(this.profilePOM.getProfileEditFirstname(), "Jonathan");
		assertEquals(this.profilePOM.getProfileEditLastname(), "Smythe");
	}
	/*@When("Profile: User clicks check button")
	public void profile_user_clicks_check_button() {
		this.profilePOM.clickProfileEditSubmitButton();
	}*/
	@Then("Profile: Edit fields are hidden and User name is reflected in header and profile page")
	public void profile_edit_fields_are_hidden_and_user_name_is_reflected_in_header_and_profile_page() {
		this.profilePOM.waitForEditProfileFieldsToBeHidden();
		String[] firstAndLastName = this.profilePOM.getFirstNameLastNameFromHeader();
		assertEquals("Jonathan Smythe", firstAndLastName[0]+" "+firstAndLastName[1]);
	}

	//Scenario: Profile: User can still log in after doing Edit Profile but NOT changing fields
	//...
	@When("Profile: User logs off")
	public void profile_user_logs_off() {
		this.profilePOM.clickLogoutButton();
	}
	//...
	//Scenario: Profile: User can still log in after doing Edit Profile and changing password
	@When("Profile: User changes password field")
	public void profile_user_changes_password_field() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
	@Then("Profile: password field is filled in and not blank")
	public void profile_password_field_is_filled_in_and_not_blank() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
	@Then("Profile: Profile edit fields are hidden")
	public void profile_profile_edit_fields_are_hidden() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
	/*@When("Profile: User logs off")
	public void profile_user_logs_off() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}*/
}
