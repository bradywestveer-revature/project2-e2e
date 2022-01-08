Feature: Register Page
	
	Background:
		Given Register: A user is on the register page
	
	Scenario: The user enters valid information and creates an account
		When Register: The user enters valid user information
		Then Register: The user will be redirected to the login page
	
	Scenario: The user enters an invalid first name and an error is shown
		When Register: The user enters an invalid first name
		Then Register: An error is shown saying the first name is invalid
	
	Scenario: The user enters an invalid last name and an error is shown
		When Register: The user enters an invalid last name
		Then Register: An error is shown saying the last name is invalid
	
	Scenario: The user enters an invalid email and an error is shown
		When Register: The user enters an invalid email
		Then Register: An error is shown saying the email is invalid
	
	Scenario: The user enters an invalid username and an error is shown
		When Register: The user enters an invalid username
		Then Register: An error is shown saying the username is invalid
	
	Scenario: The user enters an invalid password and an error is shown
		When Register: The user enters an invalid password
		Then Register: An error is shown saying the password is invalid
	
	Scenario: The user enters an invalid password confirmation and an error is shown
		When Register: The user enters an invalid password confirmation
		Then Register: An error is shown saying the password confirmation is invalid
	
	Scenario: The user clicks the login to an existing account button and is taken to the login page
		When Register: The user clicks the login to an existing account button
		Then Register: The user is redirected to the login page