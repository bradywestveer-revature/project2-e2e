Feature: Register Page
  Background:
    Given A user is on the register page

  Scenario: The user enters valid information and creates an account
    When The user enters valid user information
    Then The user will be redirected to the login page

  Scenario: The user enters an invalid first name and an error is shown
    When The user enters an invalid first name
    Then An error is shown saying the first name is invalid

  Scenario: The user enters an invalid last name and an error is shown
    When The user enters an invalid last name
    Then An error is shown saying the last name is invalid

  Scenario: The user enters an invalid email and an error is shown
    When The user enters an invalid email
    Then An error is shown saying the email is invalid

  Scenario: The user enters an invalid username and an error is shown
    When The user enters an invalid username
    Then An error is shown saying the username is invalid

  Scenario: The user enters an invalid password and an error is shown
    When The user enters an invalid password
    Then An error is shown saying the password is invalid

  Scenario: The user enters an invalid password confirmation and an error is shown
    When The user enters an invalid password confirmation
    Then An error is shown saying the password confirmation is invalid

  Scenario: The user clicks the login to an existing account button and is taken to the login page
    When The user clicks the login to an existing account button
    Then The user is redirected to the login page