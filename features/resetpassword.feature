Feature: Reset Password Page
	
	Background:
		Given Reset Password: A user is on the reset password page
	
	Scenario: A user enter a valid email address and a success message is displayed
		When Reset Password: A user enters a valid email address
		Then Reset Password: A success message is displayed
	
	Scenario: A user enter an invalid email address and an error message is displayed
		When Reset Password: A user enters an invalid email address
		Then Reset Password: An error message is displayed
	
	Scenario: A user clicks the "Retry Login" button and is redirected to the login page
		When Reset Password: The user is clicks the retry login button
		Then Reset Password: The user is redirected to the login page