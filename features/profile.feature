Feature: Profile Page
	Background:
		Given Login: A user is on the login page
		When Login: A user enters correct login credentials
		Then Login: The user is redirected to their main feed
		Given Main: The user is on the main page
		When Profile: The user clicks their profile
		Then Profile: The user is taken to their profile page
	Scenario: User navigates to their profile page after logging in User clicks Edit Profile information, should show profile edit fields
		When Profile: User clicks Edit Profile
		Then Profile: Edit profile input text boxes are shown with placeholders pre-populated with correct info
		When Profile: User clicks X button
		Then Profile: User name was not changed no change in header or profile page
	Scenario: Profile: User edits and does NOT make field changes clicks CHECK, profile of user should not change either
		Given Profile: User is already in edit profile mode
		When Profile: User clicks check button
		Then Profile: User name was not changed no change in header or profile page
	Scenario: Profile: User edits and does NOT make field changes clicks X, profile of user should not change either
		Given Profile: User is already in edit profile mode
		When Profile: User clicks X button
		Then Profile: User name was not changed no change in header or profile page
	Scenario: Profile: User edits and saves various fields
		Given Profile: User is already in edit profile mode
		When Profile: User changes firstName and lastName field
		Then Profile: firstName and lastName field are changed
		When Profile: User clicks check button
		Then Profile: Edit fields are hidden and User name is reflected in header and profile page
	Scenario: Profile: User can still log in after doing Edit Profile but NOT changing fields
		When Profile: User logs off
		Given Login: A user is on the login page
		When Login: A user enters correct login credentials
		Then Login: The user is redirected to their main feed
		Given Main: The user is on the main page
		When Profile: The user clicks their profile
		Then Profile: The user is taken to their profile page
	Scenario: Profile: User can still log in after doing Edit Profile and changing password
		Given Profile: User is already in edit profile mode
		When Profile: User changes password field
		Then Profile: password field is filled in and not blank
		When Profile: User clicks check button
		Then Profile: Profile edit fields are hidden
		When Profile: User logs off
		Given Login: A user is on the login page
		When Profile: A user enters correct login credentials
		Then Login: The user is redirected to their main feed
		Given Main: The user is on the main page
		When Profile: The user clicks their profile
		Then Profile: The user is taken to their profile page
		Given Profile: User is already in edit profile mode
		When Profile: User changes password field back to original
		Then Profile: password field is filled in and not blank has original value
		When Profile: User clicks check button
		Then Profile: Profile edit fields are hidden
		When Profile: User logs off
		Given Login: A user is on the login page
		When Login: A user enters correct login credentials
		Then Login: The user is redirected to their main feed
		Given Main: The user is on the main page
		When Profile: The user clicks their profile
		Then Profile: The user is taken to their profile page
	Scenario: Profile: User can still log in after doing Edit Profile and changing username
		Given Profile: User is already in edit profile mode
		When Profile: User changes username field
		Then Profile: username field is filled in and not blank
		When Profile: User clicks check button
		Then Profile: Profile edit fields are hidden
		When Profile: User logs off
		Given Login: A user is on the login page
		When Profile: A user enters correct login credentials for new username
		Then Login: The user is redirected to their main feed
		Given Main: The user is on the main page
		When Profile: The user clicks their profile
		Then Profile: The user is taken to their profile page
		Given Profile: User is already in edit profile mode
		When Profile: User changes username field back to original
		Then Profile: username field is filled in and not blank has original value
		When Profile: User clicks check button
		Then Profile: Profile edit fields are hidden
		When Profile: User logs off
		Given Login: A user is on the login page
		When Login: A user enters correct login credentials
		Then Login: The user is redirected to their main feed
		Given Main: The user is on the main page
		When Profile: The user clicks their profile
		Then Profile: The user is taken to their profile page
	Scenario: Profile: User can change email and log in using changed email address
		Given Profile: User is already in edit profile mode
		When Profile: User changes email field
		Then Profile: email field is filled in and not blank
		When Profile: User clicks check button
		Then Profile: Profile edit fields are hidden
		When Profile: User logs off
		Given Login: A user is on the login page
		When Profile: A user enters correct login credentials for new email
		Then Login: The user is redirected to their main feed
		Given Main: The user is on the main page
		When Profile: The user clicks their profile
		Then Profile: The user is taken to their profile page
		Given Profile: User is already in edit profile mode
		When Profile: User changes email field back to original
		Then Profile: email field is filled in and not blank has original value
		When Profile: User clicks check button
		Then Profile: Profile edit fields are hidden
		When Profile: User logs off
		Given Login: A user is on the login page
		When Login: A user enters correct login credentials
		Then Login: The user is redirected to their main feed
		Given Main: The user is on the main page
		When Profile: The user clicks their profile
		Then Profile: The user is taken to their profile page
	Scenario: Profile: User can update their profile image
		Given Profile: User is already in edit profile mode
		When Profile: The user adds an image to their profile
		Then Profile: The profile image is displayed
		When Profile: User clicks check button
		Then Profile: Profile edit fields are hidden and new image is displayed