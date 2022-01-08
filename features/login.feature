Feature: Login Page
	#todo change all steps to have Login: prefix to not conflict with other files 
	Background:
		Given Login: A user is on the login page
	
	Scenario: Logging in with valid credentials will redirect to users main feed
		When Login: A user enters correct login credentials
		Then Login: The user is redirected to their main feed
	
	Scenario: Logging in with invalid credentials will show error message
		When Login: A user enters incorrect login credentials
		Then Login: An invalid credentials message shows on login form
	
	Scenario: Clicking on the "Create Account" button will redirect user to the register page
		When Login: A user clicks on the create account button
		Then Login: The user is redirected to the register page
	
	Scenario:  Clicking on the "Forgot Password" button will redirect user to the reset password page
		When Login: A user clicks on the forgot password button
		Then Login: The user is redirected to the reset password page